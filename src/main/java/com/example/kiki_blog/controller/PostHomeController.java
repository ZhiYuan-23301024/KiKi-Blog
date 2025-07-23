package com.example.kiki_blog.controller;

import com.example.kiki_blog.service.PCHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PostHomeController {
    @Autowired
    @Qualifier("PCHServiceImpl")
    private PCHService pchService;
    @GetMapping("/posthome")
    public Map<String,Object> GetContent(@RequestParam(value = "id", defaultValue = "1") int id) {
        System.out.println("显示博客内容"+Map.of("content", pchService.GetContent(id)));
        return Map.of("content", pchService.GetContent(id));
    }
}
