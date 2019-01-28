package io.pivotal.pa.pks.poc.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;


@Component ("quoteStream")
public interface QuoteStream {
	
	String INPUT = "quote-in";
    String OUTPUT = "quote-out";
 
    @Input(QuoteStream.INPUT)
    SubscribableChannel inboundQuoteStream();
 
    @Output(QuoteStream.OUTPUT)
    MessageChannel outboundQuoteStream();

}
