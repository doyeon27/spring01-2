package com.yi.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.yi.spring"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.yi\\.spring\\.excludepackage\\..*")
)
public class AutoAppConfig {

}
