package io.pivotal.pa.pks.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;
import io.pivotal.pa.pks.poc.mapper.QuoteRequestDTOToDomainMapper;
import io.pivotal.pa.pks.poc.mapper.QuoteRequestDomainToDTOMapper;
import io.pivotal.pa.pks.poc.repositories.QuoteRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service ("qoutesService")
public class QuoteServiceImpl implements QuoteService{
	
	@Autowired
	private QuoteRequestDTOToDomainMapper quoteRequestDTOToDomainMapper;
	
	
	@Autowired
	private QuoteRequestDomainToDTOMapper quoteRequestDomainToDTOMapper;
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Override
	public void quoteRequest(QuoteRequestDTO quoteRequestDTO) {
		 log.info("Entry into quoteRequest. Request Details - ", quoteRequestDTO.toString());
		 quoteRepository.save(quoteRequestDTOToDomainMapper.convert(quoteRequestDTO));
		 
	    return ;
	}
	
	public List<QuoteRequestDTO> listAll() 
	{
		
		log.info("Entry into listAll. ");
		return quoteRequestDomainToDTOMapper.convertList(quoteRepository.findAll());
	   
		
	}
	

}
