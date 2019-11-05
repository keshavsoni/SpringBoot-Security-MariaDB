package com.keshav.hl.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
/*@EnableJpaRepositories(basePackages = "com.keshav.hl.springsecurity.repository",
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "transactionManager")*/
@EnableSpringConfigured
public class JpaConfiguration {	
		    
	    
	    @Bean(name = "keshavLearningDataSource")
	    public DataSource keshavLearningDataSource() {
	    	HikariDataSourceConfig hikariCfg = new HikariDataSourceConfig();
	    	hikariCfg.setJdbcUrl("jdbc:mariadb://localhost:3306/springbootapp_db");
	    	hikariCfg.setUsername("root");
	    	hikariCfg.setPassword("admin");
	    	hikariCfg.setDriverClassName("org.mariadb.jdbc.Driver");
	        return createDataSource(hikariCfg);
	    }
	    
	 
	 private static DataSource createDataSource(HikariDataSourceConfig hikariCfg) {
	        HikariConfig config = new HikariConfig();
	        BeanUtils.copyProperties(hikariCfg, config);
	        return new HikariDataSource(config);
	    }
	    
	    
	     
	 
}