package com.honsoft.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.honsoft.service.PersonService;
import com.honsoft.service.PersonServiceDaoImpl;
import com.honsoft.service.PersonServiceImpl;
import com.honsoft.springbatch.listener.ApplicationContextAwareBean;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = { "classpath:spring/jdbc.properties" }, ignoreResourceNotFound = true)
@EnableJpaRepositories(basePackages = "com.honsoft.repository.oracle",entityManagerFactoryRef = "oracleEntityManagerFactory",transactionManagerRef = "oracleJpaTransactionManager")
public class OracleDataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource oracleDataSource() {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("oracle.hikari.jdbc.driverClassName"));
		config.setJdbcUrl(env.getProperty("oracle.hikari.jdbc.url"));
		config.setUsername(env.getProperty("oracle.hikari.jdbc.username"));
		config.setPassword(env.getProperty("oracle.hikari.jdbc.password"));
		
		HikariDataSource hds = new HikariDataSource(config);
		return hds;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(oracleDataSource());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setPersistenceUnitName("oracleUnit");
		factory.setPackagesToScan("com.honsoft.entity.oracle");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto","update");
		jpaProperties.put("hibernate.show-sql", true);
		
		factory.setJpaProperties(jpaProperties);
		
		return factory;
		
	}
	
	
	@Bean
	public PlatformTransactionManager oracleJpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(oracleEntityManagerFactory().getObject());
		
		return transactionManager;
	}

}
