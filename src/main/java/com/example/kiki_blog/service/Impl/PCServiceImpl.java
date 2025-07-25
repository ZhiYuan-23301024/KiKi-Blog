package com.example.kiki_blog.service.Impl;

import com.example.kiki_blog.Constant.HelloworldConstant;
import com.example.kiki_blog.Dao.PCDao;
import com.example.kiki_blog.entity.PostCard;
import com.example.kiki_blog.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class PCServiceImpl implements PCService {
    @Autowired
    private PCDao pcDao;
    @Override
    public List<PostCard> getPostCards(int currentPage){
        int startId=(currentPage-1)* HelloworldConstant.PAGE_SIZE+1;
        int endId=currentPage*HelloworldConstant.PAGE_SIZE;
        return pcDao.getByPage(startId,endId);
    }
    @Override
    public int getTotalNum(){
        return pcDao.count_page();
    }

}
