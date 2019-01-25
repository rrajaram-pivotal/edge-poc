package io.pivotal.pa.pks.poc.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter 
@AllArgsConstructor 
@EqualsAndHashCode
@PrimaryKeyClass
public class QuoteRequestKey implements Serializable{
	
	  @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	  private String fromZipCode;
	  
	  @PrimaryKeyColumn(ordinal = 0,ordering = Ordering.DESCENDING)
	  private Date requestDate;
	 
	 
}
