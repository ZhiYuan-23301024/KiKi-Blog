package com.example.kiki_blog.controller;
import com.example.kiki_blog.result.result;
import com.example.kiki_blog.entity.PostCard;
import com.example.kiki_blog.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.kiki_blog.vo.HelloworldVO;
import java.util.List;
@RestController
public class PostCardController {
    @Autowired
    @Qualifier("PCServiceImpl")
    private PCService pcService;

    @GetMapping("/postcardlist")  // 明确使用 GET 请求映射[3,5](@ref)
    public result<HelloworldVO> test(@RequestParam(value = "currentpage", defaultValue = "1") int currentpage) {
        System.out.println("这是第"+currentpage+"页的内容");
        int totalNum= pcService.getTotalNum();
        System.out.println("页码总数为"+totalNum);
        HelloworldVO helloworldVO = new HelloworldVO();
        helloworldVO.setPageNum(currentpage);
        helloworldVO.setPostcardlist(pcService.getPostCards(currentpage));
        return result.success(helloworldVO);
    }
}
