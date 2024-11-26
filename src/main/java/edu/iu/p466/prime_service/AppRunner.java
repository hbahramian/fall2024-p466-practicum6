package edu.iu.p466.prime_service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AppRunner implements ApplicationRunner {

    private final DataSource dataSource;

    public AppRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("----connection string log ----");
        System.out.println(dataSource.getConnection().getMetaData().getURL());
    }
}
