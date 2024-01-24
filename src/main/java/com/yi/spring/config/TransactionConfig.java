package com.yi.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {

//    @EnableTransactionManagement 어노테이션이 사용된 이 클래스에서 PlatformTransactionManager 빈을 정희하고
//    이 빈은 데이터 소스를 기반으로 하는 DataSourceTransactionManager 를 생성함

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
