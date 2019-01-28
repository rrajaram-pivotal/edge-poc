package io.pivotal.pa.pks.poc.service;


import java.util.List;

import org.springframework.stereotype.Service;

import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;
import lombok.extern.slf4j.Slf4j;


public interface QuoteService {
	

    public void recieveQuoteRequest(final QuoteRequestDTO quoteRequest); 
    
    public List<QuoteRequestDTO> listAll(); 
    
    public void saveQuoteRequest(final QuoteRequestDTO quoteRequest); 
    
    

}
