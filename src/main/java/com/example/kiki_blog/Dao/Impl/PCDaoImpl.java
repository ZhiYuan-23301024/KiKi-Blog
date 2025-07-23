package com.example.kiki_blog.Dao.Impl;

import com.example.kiki_blog.Dao.PCDao;
import com.example.kiki_blog.entity.PostCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class PCDaoImpl implements PCDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;  // 网页1、网页4、网页6、网页7均推荐此方式
    @Override
    public List<String> find_by_page(int currentPage){
        List<String> list =new ArrayList<>();
        // 查询单个字符串（如用户姓名）
        for(int i=0;i<3;i++) {
            try {
                int userId = 3*(currentPage-1)+i+1;
                System.out.println("UserID为 "+userId);
                String sql = "SELECT id,title,updateTime FROM blog_posts WHERE id = ?";
                String line = jdbcTemplate.queryForObject(
                        sql,
                        new BeanPropertyRowMapper<>(PostCard.class),  // 指定返回类型为字符串[1,3](@ref)
                        userId         // 参数值
                ).toString();
                list.add(line);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int count_page() {
        int temp=0;
        try {
            String sql ="SELECT COUNT(*) FROM blog_posts";
            temp =jdbcTemplate.queryForObject(sql,Integer.class);
            System.out.println("total="+temp);
        }catch (Exception e){
            e.printStackTrace();
        }

        return temp/3+(temp%6==0?0:1);
    }
}
