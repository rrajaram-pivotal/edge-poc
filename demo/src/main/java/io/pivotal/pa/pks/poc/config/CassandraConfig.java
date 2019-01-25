package io.pivotal.pa.pks.poc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableCassandraRepositories (basePackages = "io.pivotal.pa.pks.poc.repositories") 
public class CassandraConfig extends AbstractCassandraConfiguration 
{

	  @Value("${cassandra.contactpoints}")
	  private String contactPoints;
	  
	  @Value("${cassandra.port}")
	  private int port;
	  
	  @Value("${cassandra.keyspace}")
	  private String keySpace;
	  
	  @Value("${cassandra.basePackages}")
	  private String basePackages;

	  @Value("${cassandra.entityBasePackages}")
	  private String entityBasePackages;
	  
	  @Value("${cassandra.username}")
	  private String userName;
	  
	  @Value("${cassandra.password}")
	  private String password;
	 
	  
	  @Override
	  protected AuthProvider getAuthProvider() {
		  
		  PlainTextAuthProvider authProvider = new PlainTextAuthProvider(userName,password);
		  log.info("Overriden Auth Provider " + authProvider);
		  return authProvider;
	  }

	@Override
	  protected String getKeyspaceName() {
	    return keySpace;
	  }
	  
	  @Override
	  protected String getContactPoints() {
	    return contactPoints;
	  }
	  
	  @Override
	  protected int getPort() {
	    return port;
	  }
	  
	  @Override
	  public SchemaAction getSchemaAction() {
	    return SchemaAction.CREATE_IF_NOT_EXISTS;
	  }


	@Override
	  public String[] getEntityBasePackages() {
		  log.info("Entity Base Packages -------------------------> " + entityBasePackages);
		return new String[] {entityBasePackages};
	  }
	  
	  @Override
	  protected boolean getMetricsEnabled() { return false; }

}
