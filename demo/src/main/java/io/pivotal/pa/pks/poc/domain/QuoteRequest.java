package io.pivotal.pa.pks.poc.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter 
@AllArgsConstructor 
@Builder
@NoArgsConstructor
public class QuoteRequest {
	
	@PrimaryKey
	private QuoteRequestKey quoteRequestKey;
	
	@Column
	private String toZipCode;
	
	@Column
	private String handlingUnitType;
	
	@Column
	private Integer handlingUnitCount;
	
	@Column
	private Integer weight;
	
	@Column
	private String weightUnitOfMeasure;
	
	@Column
	private String classDesignation;
	
	

}
