CREATE TABLE blog_posts (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '文章唯一标识',
    title VARCHAR(255) NOT NULL COMMENT '文章标题',
    content LONGTEXT NOT NULL COMMENT '文章内容',
    updatetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SELECT 
    bp.id, 
    bp.title, 
    bp.updatetime AS updateTime,
    -- 分别获取每个标签对应的颜色
    t1.color AS color1,  -- id1对应的颜色
    t2.color AS color2,  -- id2对应的颜色
    t3.color AS color3   -- id3对应的颜色
FROM 
    blog_posts bp
    -- 左连接tags表三次，分别对应id1/id2/id3
    LEFT JOIN tags t1 ON bp.id1 = t1.tag
    LEFT JOIN tags t2 ON bp.id2 = t2.tag
    LEFT JOIN tags t3 ON bp.id3 = t3.tag
WHERE 
    bp.id = ?;  -- 替换?为目标ID