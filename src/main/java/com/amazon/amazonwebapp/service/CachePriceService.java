package com.amazon.amazonwebapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazon.amazonwebapp.domain.CachePrice;
import com.amazon.amazonwebapp.repository.CachePriceRepository;

@Service
public class CachePriceService {

    private final CachePriceRepository cpRepository;

    public CachePriceService(CachePriceRepository cpRepository) {
        this.cpRepository = cpRepository;
    }

    public List<CachePrice> buscarDestacados() {
        return cpRepository.buscarTodos();
    }
    
    public List<CachePrice> buscarPorNombre(String consulta){
        return cpRepository.buscarPorNombre(consulta);
    }
}
