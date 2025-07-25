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
    private String id1;
    private String id2;
    private String id3;
    private String color1;
    private String color2;
    private String color3;
}
