package com.amazon.amazonwebapp.repository;

import com.amazon.amazonwebapp.domain.CachePrice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CachePriceRepository extends JpaRepository<CachePrice, Integer>{
  
    
    @Query("select v from CachePrice v order by v.item.itemname")
    List<CachePrice> buscarTodos();
    
    @Query(value="SELECT idItems, discountPrice, ImageUrl, max(PriceDate) as ultimaFecha FROM amazon.cacheprices group by idItems", nativeQuery=true)
    List<CachePrice> buscarUltimoItem();
    
    @Query("select v from CachePrice v where v.item.itemname like %?1%")
    List<CachePrice> buscarPorNombre(String consulta);
    
    
}
