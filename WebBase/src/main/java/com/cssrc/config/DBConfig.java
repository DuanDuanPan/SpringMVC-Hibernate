package com.cssrc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {


    @Autowired
    private Environment environment;

    @Bean
    public HibernateTemplate hibernateTemplate(){
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());
        localSessionFactoryBean.setPackagesToScan("com.cssrc");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        try{
            localSessionFactoryBean.afterPropertiesSet();
        }catch (IOException e){
            e.printStackTrace();
        }
        return localSessionFactoryBean.getObject();
    }

    @Bean
    public DataSource getDataSource(){
        DruidDataSource DruidDataSource = new DruidDataSource();
        DruidDataSource.setDriverClassName(environment.getProperty("database.driver"));
        DruidDataSource.setUrl(environment.getProperty("database.url"));
        DruidDataSource.setUsername(environment.getProperty("database.username"));
        DruidDataSource.setPassword(environment.getProperty("database.password"));
        return DruidDataSource;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        return new HibernateTransactionManager(sessionFactory());
    }


    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        return properties;
    }
}
