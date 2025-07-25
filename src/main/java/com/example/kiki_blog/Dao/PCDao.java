package com.example.kiki_blog.Dao;

import com.example.kiki_blog.entity.PostCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PCDao {
    @Select("select count(*) from blog_posts")
    int count_page();

    /**
     * 获取指定ID范围内的帖子集合
     * @param startId
     * @param endId
     * @return
     */
    @Select("SELECT bp.id, bp.title, bp.updatetime AS updateTime, " +
            "bp.id1, bp.id2, bp.id3, " +  // 补全逗号分隔
            "t1.color AS color1, t2.color AS color2, t3.color AS color3 " +
            "FROM blog_posts bp " +
            "LEFT JOIN tags t1 ON bp.id1 = t1.tag " +
            "LEFT JOIN tags t2 ON bp.id2 = t2.tag " +
            "LEFT JOIN tags t3 ON bp.id3 = t3.tag " +
            "WHERE bp.id BETWEEN #{startId} AND #{endId} " +  // 替换无效条件
            "ORDER BY bp.id ASC")  // 按ID倒序保证分页连续性
    List<PostCard> getByPage(int startId,int endId);
}
