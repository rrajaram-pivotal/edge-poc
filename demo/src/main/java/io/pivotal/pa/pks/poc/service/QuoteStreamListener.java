package io.pivotal.pa.pks.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class QuoteStreamListener {
	
		@Autowired
		private QuoteService quotesService;
	
	    @StreamListener(QuoteStream.INPUT)
	    public void handleQuoteRequest(@Payload QuoteRequestDTO message) {
	        log.debug("Entry into QuoteStreamListener.handleQuoteRequest() ", message.toString());
	        if (message.getClassDesignation() != null)
	        {
	        	if (message.getClassDesignation().equals("55"))
	        	{
	        		message.setQuotePrice(200);
	        	}
	        	else if (message.getClassDesignation().equals("75"))
	        	{
	        		message.setQuotePrice(250);
	        	}
	        	else if (message.getClassDesignation().equals("100"))
	        	{
	        		message.setQuotePrice(300);
	        	}
	        	else 
	        	{
	        		message.setQuotePrice(140);
	        	}
	        }
	        quotesService.saveQuoteRequest(message);
	        log.debug("Exiting QuoteStreamListener.handleQuoteRequest() ");
	    }
	

}
