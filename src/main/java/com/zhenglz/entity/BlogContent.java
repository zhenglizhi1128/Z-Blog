package com.zhenglz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: zlz
 * @Date: 2021/03/19/16:16
 * @Description: 博客内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BlogContent implements Serializable {

    private static final long serialVersionUID = 4293084691846979425L;

    /**
    * 主键
    */
    private Long id;

    /**
    * 内容
    */
    private String content;

    /**
    * 对应文章ID
    */
    private Long blogId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}