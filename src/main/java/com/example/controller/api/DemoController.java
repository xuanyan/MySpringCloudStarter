package com.example.controller.api;

import com.example.ConfigProperties;
import com.example.entity.Person;
import com.example.entity.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@Slf4j
public class DemoController {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private  ConfigProperties configProperties;

    @Value("${spring.main.banner-mode}")
    private String aaa;

    @GetMapping("abc")
    public String index()
    {

        Map<String, Object> map = new HashMap<>();
        map.put("result", "ok");
        log.error(configProperties.toString());
        return aaa;
    }

    @PostMapping(path = "addPerson")
    public Person addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return personRepository.findFirstByName(person.getName());
    }
}
