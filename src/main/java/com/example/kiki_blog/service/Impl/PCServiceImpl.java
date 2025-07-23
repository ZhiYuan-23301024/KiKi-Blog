package com.example.kiki_blog.service.Impl;

import com.example.kiki_blog.Dao.Impl.PCDaoImpl;
import com.example.kiki_blog.Dao.PCDao;
import com.example.kiki_blog.entity.PostCard;
import com.example.kiki_blog.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class PCServiceImpl implements PCService {
    @Autowired
    @Qualifier("PCDaoImpl")
    private PCDao pcDao;
    @Override
    public List<PostCard> getPostCards(int currentPage){
        List<String> list=pcDao.find_by_page(currentPage);
        List<PostCard> postCardList=new ArrayList<>();
        for(int i=0;i< list.size();i++){
            String rawStr = list.get(i);
            String jsonStr = rawStr
                    .replace("PostCard(", "")
                    .replace("id","")
                    .replace("title","")
                    .replace("updateTime","")
                    .replace("=","")
                    .replace(")", "")
                    .replaceAll("(\\w+)=", "\"$1\":"); // 替换等号为冒号，键加双引号[2,4](@ref)
            System.out.println(jsonStr);
            String[] parts=jsonStr.split(", ");
            int id=Integer.parseInt(parts[0]);
            String title=parts[1];
            LocalDateTime updateTime=LocalDateTime.parse(parts[2]);
            postCardList.add(new PostCard(id,title,updateTime));
        }

        return postCardList;
    }
    @Override
    public int getTotalNum(){
        return pcDao.count_page();
    }

}
