package com.cssrc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import javax.sql.DataSource;

/**
 * Created by panduanduan on 28/03/2017.
 */
@Configuration
public class ActivitiConfig {

    @Autowired
    DataSource dataSource;

    @Autowired
    HibernateTransactionManager hibernateTransactionManager;

    SpringProcessEngineConfiguration springProcessEngineConfiguration;

    ProcessEngine processEngine;

    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration() {
        if (null == springProcessEngineConfiguration) {
            springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
            springProcessEngineConfiguration.setDataSource(dataSource);
            springProcessEngineConfiguration.setTransactionManager(hibernateTransactionManager);
            springProcessEngineConfiguration.setDatabaseSchemaUpdate("false");
            springProcessEngineConfiguration.setJobExecutorActivate(false);
            springProcessEngineConfiguration.setDatabaseType("oracle");
            springProcessEngineConfiguration.setActivityFontName("宋体");
            springProcessEngineConfiguration.setLabelFontName("宋体");
        }
        return springProcessEngineConfiguration;
    }

    @Bean
    public ProcessEngine processEngine() {
        if (null == processEngine) {
            ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
            processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration());
            try {
                processEngine = processEngineFactoryBean.getObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return processEngine;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RepositoryService repositoryService() {
        return processEngine().getRepositoryService();

    }

    @Bean
    public RuntimeService runtimeService() {
        return processEngine().getRuntimeService();

    }

    @Bean
    public TaskService taskService() {
        return processEngine().getTaskService();

    }

    @Bean
    public HistoryService historyService() {
        return processEngine().getHistoryService();

    }

    @Bean
    public ManagementService managementService() {
        return processEngine().getManagementService();
    }
}
