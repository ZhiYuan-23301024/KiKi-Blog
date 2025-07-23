package com.example.kiki_blog.Dao.Impl;

import com.example.kiki_blog.Dao.PCDao;
import com.example.kiki_blog.Dao.PCHDao;
import com.example.kiki_blog.entity.PostCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Component
public class PCHDaoImpl implements PCHDao {
    @Autowired
    private JdbcOperations jdbcTemplate;

    @Override
    public String GetContent(int id) {
        String sql = "SELECT content FROM blog_posts WHERE id = ?";
        try {
            System.out.println(jdbcTemplate.queryForObject(sql, String.class, id));
            return jdbcTemplate.queryForObject(sql, String.class, id);
        } catch (EmptyResultDataAccessException e) {
            return "内容不存在"; // 或返回 null/空字符串
        }
    }
}