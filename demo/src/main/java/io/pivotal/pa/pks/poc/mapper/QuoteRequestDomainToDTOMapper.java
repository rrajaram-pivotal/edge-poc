package io.pivotal.pa.pks.poc.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.pivotal.pa.pks.poc.domain.QuoteRequest;
import io.pivotal.pa.pks.poc.domain.QuoteRequestKey;
import io.pivotal.pa.pks.poc.dto.QuoteRequestDTO;

@Component ("quoteRequestDomainToDTOMapper")
public class QuoteRequestDomainToDTOMapper implements Converter<QuoteRequest, QuoteRequestDTO> {

	    @Override
	    public QuoteRequestDTO convert(QuoteRequest quoteRequest) {
		  QuoteRequestDTO quoteRequestDTO = new QuoteRequestDTO();
		  
		  quoteRequestDTO.setFromZipCode(quoteRequest.getQuoteRequestKey().getFromZipCode());
		  quoteRequestDTO.setRequestDate(quoteRequest.getQuoteRequestKey().getRequestDate());
		  quoteRequestDTO.setToZipCode(quoteRequest.getToZipCode());
		  quoteRequestDTO.setClassDesignation(quoteRequest.getClassDesignation());
		  quoteRequestDTO.setWeight(quoteRequest.getWeight());
		  quoteRequestDTO.setWeightUnitOfMeasure(quoteRequest.getWeightUnitOfMeasure());
		  quoteRequestDTO.setHandlingUnitType(quoteRequest.getHandlingUnitType());
		  quoteRequestDTO.setHandlingUnitCount(quoteRequest.getHandlingUnitCount());
		  quoteRequestDTO.setQuotePrice(quoteRequest.getQuotePrice());
	        return quoteRequestDTO;
	    }
	    
	    public List<QuoteRequestDTO> convertList(List<QuoteRequest> quoteRequests)
	    {
	    	List<QuoteRequestDTO> quoteRequestDTOList = new ArrayList<QuoteRequestDTO>();
	    	if (quoteRequests != null || !quoteRequests.isEmpty()) {
		    	
		    	for (ListIterator<QuoteRequest> iter = quoteRequests.listIterator(); iter.hasNext(); ) {
		    		quoteRequestDTOList.add(convert(iter.next()));
		    	}
	    	}
		    	return quoteRequestDTOList;
	    }
	
}
