package com.example.controller.api;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private Logger logger;

    @GetMapping("abc")
    public Map<String, Object> index()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("result", "ok");

        return map;
    }
}
