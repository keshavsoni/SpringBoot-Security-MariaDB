package com.keshav.hl.springsecurity.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = {
"${keshav.learning.repository.component.scan}" }, entityManagerFactoryRef = "keshavLearningEntityManager", transactionManagerRef = "keshavLearningTransactionManager")
@EntityScan(value = { "${keshav.learning.entity.component.scan}" })
@EnableSpringConfigured
public class RepositoryConfiguration {
	

	@Autowired
	@Qualifier("keshavLearningDataSource")
	private DataSource dataSource;

	@Value("${keshav.learning.entity.component.scan}")
	private String entityPackage;
	
	
	@Bean(name = "keshavLearningEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { entityPackage });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setPersistenceProvider(new HibernatePersistenceProvider());
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.show_sql", "true");
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean(name = "keshavLearningTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManager().getObject());
		return transactionManager;
	}
	
	
}
