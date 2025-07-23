package com.example.kiki_blog.Dao;

import java.util.List;

public interface PCDao {
    public List<String> find_by_page(int currentPage);
    public int count_page();
}
