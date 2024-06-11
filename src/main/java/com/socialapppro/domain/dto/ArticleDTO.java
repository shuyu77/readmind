package com.socialapppro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleDTO {
    //用户id
    private Integer userId;
    //用户名称
    private String username;
    //用户头像
    private String picture;
    //用户兴趣
    private String introduction;
    //文章id
    private Integer postId;
    //文章内容
    private String content;
//    //文章头图片
    private String images;
    //文章点赞数
    private Integer likesCount;
    //文章评论数
    private Integer commentsCount;
    //文章发表时间
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

}
