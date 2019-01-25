package io.pivotal.pa.pks.poc.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import io.pivotal.pa.pks.poc.domain.QuoteRequest;
import io.pivotal.pa.pks.poc.domain.QuoteRequestKey;

@Repository
public interface QuoteRepository extends CassandraRepository<QuoteRequest, QuoteRequestKey> {
	
	// List<QuoteRequest> findByKeyFromZipCode(final String fromZipCode);
}
