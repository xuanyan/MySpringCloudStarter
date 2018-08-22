package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Lazy(true)
@Configuration
public class ApplicationConfig  {

    // 添加logger bean
//    @Bean
//    public Logger logger(InjectionPoint injectionPoint) {
//        Class<?> targetClass = injectionPoint.getMember().getDeclaringClass();
//
//        return LoggerFactory.getLogger(targetClass);
//    }
    // 计划任务${com.xxx.username}
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void timer1(){
//        System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(new Date()));
//    }


//    @Bean(name = "primaryDataSource")
//    @ConfigurationProperties(prefix="spring.datasource.primary")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
////
//    @Bean(name = "primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(
//            @Qualifier("primaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
}
