package com.niit.social.chatbe.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.social.chatbe.model.Blog;
import com.niit.social.chatbe.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.niit.social.chatbe" })
public class ApplicationContextConfig {
	 @Bean(name ="dataSource")
	    public DataSource getdataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	       
	        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	        dataSource.setUsername("social");
	        dataSource.setPassword("social");
	        return dataSource;
	    }
	 private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql","true");
	        properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	        properties.put("hibernate.hbm2ddl.auto","update");
	        return properties;        
	    }
	     

   
	@Autowired
   @Bean(name ="sessionFactory")
   public SessionFactory getSessionFactory(DataSource dataSource) {
       LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
       sessionBuilder.addProperties(getHibernateProperties());
       sessionBuilder.addAnnotatedClass(User.class);
     //  sessionBuilder.addAnnotatedClass(Friend.class);
    //   sessionBuilder.addAnnotatedClass(Job.class);
      sessionBuilder.addAnnotatedClass(Blog.class);
    //   sessionBuilder.addAnnotatedClass(Event.class);
     //  sessionBuilder.addAnnotatedClass(JobApplication.class);
       return sessionBuilder.buildSessionFactory();
    }
    
   @Autowired
   @Bean(name ="transactionManager")
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
      transactionManager.setSessionFactory(sessionFactory);
      return transactionManager;
   }
}

/*public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getdataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("saurabh");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.jdbc.use_get_generated_keys", "true");
		
		return properties;
		
	}
	

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}*/