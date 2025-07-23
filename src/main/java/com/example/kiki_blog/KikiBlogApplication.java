package com.example.kiki_blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class KikiBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(KikiBlogApplication.class, args);
    }


}
