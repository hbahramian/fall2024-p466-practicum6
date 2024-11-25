package edu.iu.p466.prime_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseConnectionLogger {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

   @PostConstruct
    public void logDatabaseConnection() {
        System.out.println("Database URL: " + datasourceUrl);
    }
}

