package com.honsoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.honsoft.repository.mysql",entityManagerFactoryRef = "mysqlPayEntityManagerFactory",transactionManagerRef = "mysqlPayJpaTransactionManager")
public class MysqlDataSourceJpaRepoConfig {

}
P