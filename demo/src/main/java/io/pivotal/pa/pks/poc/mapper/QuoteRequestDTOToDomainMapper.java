package io.pivotal.pa.pks.poc.mapper;



import io.pivotal.pa.pks.poc.domain.QuoteRequest;
import io.pivotal.pa.pks.poc.domain.QuoteRequestKey;
import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component ("quoteRequestDTOToDomainMapper")
public class QuoteRequestDTOToDomainMapper implements Converter<QuoteRequestDTO, QuoteRequest> 
{
	  @Override
	    public QuoteRequest convert(QuoteRequestDTO quoteRequestDTO) {
		  QuoteRequest quoteRequest = new QuoteRequest();
		  QuoteRequestKey quoteRequestKey = new QuoteRequestKey(quoteRequestDTO.getFromZipCode(),new Date());
		  quoteRequest.setQuoteRequestKey(quoteRequestKey);
		  quoteRequest.setToZipCode(quoteRequestDTO.getToZipCode());
		  quoteRequest.setClassDesignation(quoteRequestDTO.getClassDesignation());
		  quoteRequest.setWeight(quoteRequestDTO.getWeight());
		  quoteRequest.setWeightUnitOfMeasure(quoteRequestDTO.getWeightUnitOfMeasure());
		  quoteRequest.setHandlingUnitType(quoteRequestDTO.getHandlingUnitType());
		  quoteRequest.setHandlingUnitCount(quoteRequestDTO.getHandlingUnitCount());
	        return quoteRequest;
	    }
	
	
}
