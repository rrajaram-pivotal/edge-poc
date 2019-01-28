package io.pivotal.pa.pks.poc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;
import io.pivotal.pa.pks.poc.service.QuoteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/services/quote")
public class QuotesController {
	
	@Autowired
	private QuoteService qouteService;
	
	
    /*public QuotesController(QuoteService qoutesService) {
        this.qoutesService = qoutesService;
    }*/
 
    @PostMapping("/quoteRequest")
    public void quoteRequest(@RequestBody QuoteRequestDTO quoteRequestDTO) {
    	log.info("Entry into QuotesController.quoteRequest");
    	qouteService.recieveQuoteRequest(quoteRequestDTO);
    	log.info("Exit QuotesController.quoteRequest");
    	return;
    }

    @GetMapping("/")
    public List<QuoteRequestDTO> listAll() {
    	log.info("Entry into QuotesController.listAll");
    	List<QuoteRequestDTO> results = qouteService.listAll();
    	log.info("Exit QuotesController.quoteRequest");
    	return results;
    }
    
    @GetMapping("/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getStatus() {
    	
       return "Quotes Service is up & running";
    }
	

	
}
