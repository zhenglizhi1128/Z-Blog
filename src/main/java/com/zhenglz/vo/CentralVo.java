package com.zhenglz.vo;

import java.io.Serializable;
import java.util.List;

import com.zhenglz.entity.Blog;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 中控台vo
 * @author zlz
 */
@Data
@Accessors(chain = true)
public class CentralVo implements Serializable {

    private static final long serialVersionUID = -192900659608445205L;

    /**
     * 文章数
     */
    private long blogNum;

    /**
     * 用户数
     */
    private long userNum;

    /**
     * 留言数
     */
    private long messageNum;

    /**
     * 最新文章
     */
    private List<Blog> blogs;

}
