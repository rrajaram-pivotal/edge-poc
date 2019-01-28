package io.pivotal.pa.pks.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;
import io.pivotal.pa.pks.poc.mapper.QuoteRequestDTOToDomainMapper;
import io.pivotal.pa.pks.poc.mapper.QuoteRequestDomainToDTOMapper;
import io.pivotal.pa.pks.poc.repositories.QuoteRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service ("quoteService")
public class QuoteServiceImpl implements QuoteService{
	
	@Autowired
	private QuoteRequestDTOToDomainMapper quoteRequestDTOToDomainMapper;
	
	
	@Autowired
	private QuoteRequestDomainToDTOMapper quoteRequestDomainToDTOMapper;
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private QuoteStream quoteStream;
	
	
	@Override
	public void recieveQuoteRequest(QuoteRequestDTO quoteRequestDTO) {
		 log.info("Entry into QuoteServiceImpl.recieveQuoteRequest() - ", quoteRequestDTO.toString());
	      MessageChannel messageChannel = quoteStream.outboundQuoteStream();
	        messageChannel.send(MessageBuilder
	                .withPayload(quoteRequestDTO)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	     log.info("Exiting QuoteServiceImpl.recieveQuoteRequest() - ");
	    return ;
	}
	
	public List<QuoteRequestDTO> listAll() 
	{
		
		log.info("Entry into listAll. ");
		return quoteRequestDomainToDTOMapper.convertList(quoteRepository.findAll());
	   
		
	}
	
	@Override
	public void saveQuoteRequest(QuoteRequestDTO quoteRequestDTO) {
		 log.info("Entry into quoteRequest. Request Details - ", quoteRequestDTO.toString());
		 quoteRepository.save(quoteRequestDTOToDomainMapper.convert(quoteRequestDTO));
		 
	    return ;
	}
	

}
