package com.spring.jdbc;

import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class JdbcConfig {

  @Bean(name={"ds"})
  public DriverManagerDataSource getDriver()
  {
	 DriverManagerDataSource ds=new DriverManagerDataSource();
	 ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	 ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	 ds.setUsername("saurav11");
	 ds.setPassword("Root1234A");
	 return ds;
  }
  
  @Bean(name={"jdbcTemplate"})
  public JdbcTemplate getTemplate()
  {
	JdbcTemplate template=new JdbcTemplate();
	template.setDataSource(getDriver());
	 return template;
  }
  
  
  // Now using Autowring to automatically inject JdbcTemplate Object into StudentDaoimpl
  // and for that we will use @Component to Declare StudentImpl as bean & @Autowired for inject JdbcTemplate
	
	 @Bean(name={"studentImpl2"})
	 public StudentDao getStudentDao() {
     StudentDaoImpl sdao=new StudentDaoImpl(); 
     sdao.setTemplate(getTemplate());
	 return sdao; 
	 }
	 
}
