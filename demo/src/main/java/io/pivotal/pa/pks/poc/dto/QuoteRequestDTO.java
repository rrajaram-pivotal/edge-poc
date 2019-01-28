package io.pivotal.pa.pks.poc.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@ToString 
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class QuoteRequestDTO {
	
	private String fromZipCode;
	private String toZipCode;
	private String handlingUnitType;
	private Integer handlingUnitCount;
	private Integer weight;
	private String weightUnitOfMeasure;
	private String classDesignation; 
	private Date requestDate;
	private Integer quotePrice;

	

}
