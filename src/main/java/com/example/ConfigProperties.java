package com.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Lazy(true)
@RefreshScope
@Component// 以组件的方式使用，使用的时候可以直接注入
@ConfigurationProperties(prefix="com.chhliu.springboot")// 用来指定properties配置文件中的key前缀
//@PropertySource("classpath:config/user.properties")// 用来指定配置文件的位置
@Data
public class ConfigProperties {
    private String author;
    private int age;
    private String sex;
    private String time;
}
