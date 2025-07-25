package com.example.kiki_blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.kiki_blog.entity.PostCard;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HelloworldVO implements Serializable {
    private List<PostCard> postcardlist;
    private int pageNum;
}
