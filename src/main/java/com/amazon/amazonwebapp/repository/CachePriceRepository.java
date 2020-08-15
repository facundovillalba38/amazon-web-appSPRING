package com.amazon.amazonwebapp.repository;

import com.amazon.amazonwebapp.domain.CachePrice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CachePriceRepository extends JpaRepository<CachePrice, Integer>{
  
    
    @Query("select v from CachePrice v order by v.pricedate desc")
    List<CachePrice> buscarTodos(); 
    
    
    @Query(value="SELECT items.itemName, items.brand, items.Category, items.ItemPrice, items.ItemUrl, cacheprices.idItems, cacheprices.imageurl, discountPrice, ultimaFecha from cacheprices inner join (" +
    "SELECT idItems,  max(PriceDate) as ultimaFecha FROM amazon.cacheprices group by idItems order by idItems, pricedate) ultimoprecio on cacheprices.idItems = ultimoprecio.idItems and " +
    "cacheprices.priceDate = ultimoPrecio.ultimaFecha inner join items on cacheprices.idItems = items.idItems order by priceDate desc ;", nativeQuery=true)
    List<CachePrice> buscarUltimoItem();
    
    @Query("select v from CachePrice v where v.item.itemname like %?1%")
    List<CachePrice> buscarPorNombre(String consulta);
    
    
}
