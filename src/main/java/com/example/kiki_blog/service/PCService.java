package com.example.kiki_blog.service;

import com.example.kiki_blog.entity.PostCard;

import java.util.List;

public interface PCService {
    public List<PostCard> getPostCards(int CurrentPage);
    public int getTotalNum();
}
