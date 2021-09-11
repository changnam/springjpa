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
@EnableJpaRepositories(basePackages = "com.honsoft.repository.mysql",entityManagerFactoryRef = "mysqlUnit1EntityManagerFactory",transactionManagerRef = "mysqlUnit1TransactionManager")
public class MysqlDataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource mysqlDataSource() {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("mysql.hikari.jdbc.driverClassName"));
		config.setJdbcUrl(env.getProperty("mysql.hikari.jdbc.url"));
		config.setUsername(env.getProperty("mysql.hikari.jdbc.username"));
		config.setPassword(env.getProperty("mysql.hikari.jdbc.password"));
		
		HikariDataSource hds = new HikariDataSource(config);
		return hds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlUnit1EntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(mysqlDataSource());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setPersistenceUnitName("mysqlUnit1");
		factory.setPackagesToScan("com.honsoft.entity.mysql");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto","update");
		jpaProperties.put("hibernate.show-sql", true);
		
		factory.setJpaProperties(jpaProperties);
		
		return factory;
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlUnit2EntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(mysqlDataSource());
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setPersistenceUnitName("mysqlUnit2");
		factory.setPackagesToScan("com.honsoft.entity.mysql");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto","update");
		jpaProperties.put("hibernate.show-sql", true);
		
		factory.setJpaProperties(jpaProperties);
		
		return factory;
		
	}
	
	
	@Bean
	public PlatformTransactionManager mysqlUnit1TransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(mysqlUnit1EntityManagerFactory().getObject());
		
		return transactionManager;
	}
	
	@Bean
	public PlatformTransactionManager mysqlUnit2TransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(mysqlUnit2EntityManagerFactory().getObject());
		
		return transactionManager;
	}
}
