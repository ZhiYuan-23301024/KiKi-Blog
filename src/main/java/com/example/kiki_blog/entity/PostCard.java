package com.example.kiki_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCard {
    private int id;
    private String title;
    private LocalDateTime updateTime;
}
