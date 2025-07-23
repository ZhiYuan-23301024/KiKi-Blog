package com.example.kiki_blog.controller;

import com.example.kiki_blog.entity.PostCard;
import com.example.kiki_blog.service.PCService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
class PostResult{
    private int pageNum;
    private List<PostCard> postCardList;
    public PostResult(int pageNum,List<PostCard> postCardList){
        this.pageNum=pageNum;
        this.postCardList=postCardList;
    }
    // 必须添加 Getter
    public int getPageNum() { return this.pageNum; }
    public List<PostCard> getPostCardList() { return this.postCardList; }
}
@RestController
public class PostCardController {
    @Autowired
    @Qualifier("PCServiceImpl")
    private PCService pcService;

    @GetMapping("/helloworld")  // 明确使用 GET 请求映射[3,5](@ref)
    public PostResult test(
            @RequestParam(value = "currentpage", defaultValue = "1") int currentpage) {
        System.out.println("这是第"+currentpage+"页的内容");
        System.out.println(pcService.getPostCards(currentpage));
        int totalNum= pcService.getTotalNum();
        //return pcService.getPostCards(currentpage);
        System.out.println("页码总数为"+totalNum);
        return new PostResult(totalNum,pcService.getPostCards(currentpage));
    }
}
