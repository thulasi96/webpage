package com.logic.jdbc;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.logic.dao.userDetailOperation;
import com.logic.model.userDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.logic")
public class databaseConnection 
{
	@Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/web");
		datasource.setUsername("web");
		datasource.setPassword("");
		System.out.println("******Datasource object created******");
		return datasource;
	}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		
		hibernateprop.put("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		hibernateprop.setProperty("showsql", "true");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateprop);
		factory.addAnnotatedClass(userDetail.class);

		
		System.out.println("******SessionFactory Object created******");

		return factory.buildSessionFactory();
		
	}
        @Bean(name="TransactionManager")
        public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
        {
        	System.out.println("******TransactionManager Object created******");
        	return new HibernateTransactionManager(sessionFactory);
        }
    	@Bean(name="userDao")
	public userDetailOperation getCategoryDAO()
	{
		return new userDetailOperation();
	}
}