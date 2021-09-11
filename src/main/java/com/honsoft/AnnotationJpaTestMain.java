package com.honsoft;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.honsoft.config.ApplicationConfig;
import com.honsoft.config.MysqlDataSourceConfig;
import com.honsoft.config.OracleDataSourceConfig;
import com.honsoft.dto.PersonDto;
import com.honsoft.service.PersonService;

public class AnnotationJpaTestMain {
	private static Logger logger = LoggerFactory.getLogger(AnnotationJpaTestMain.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MysqlDataSourceConfig.class,OracleDataSourceConfig.class,ApplicationConfig.class);
		//ApplicationContext context = new AnnotationConfigApplicationContext(MysqlDataSourceConfig.class,ApplicationConfig.class);
		
		DataSource ds = context.getBean("mysqlDataSource",DataSource.class);
		
		PersonService ps = context.getBean("personServiceRepository",PersonService.class);
		PersonDto dto = ps.findPersonById(1);

		logger.info(dto.toString());
		
		PersonService psDao = context.getBean("personServiceDao",PersonService.class);
		dto = psDao.findPersonById(2);
		
		logger.info(dto.toString());
		
	}
}
