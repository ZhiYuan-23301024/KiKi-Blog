package com.example.kiki_blog.service.Impl;

import com.example.kiki_blog.Dao.PCDao;
import com.example.kiki_blog.Dao.PCHDao;
import com.example.kiki_blog.service.PCHService;
import com.example.kiki_blog.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PCHServiceImpl implements PCHService {
    @Autowired
    @Qualifier("PCHDaoImpl")
    private PCHDao pchDao;
    @Override
    public String GetContent(int id){
        return pchDao.GetContent(id);
    }
}
