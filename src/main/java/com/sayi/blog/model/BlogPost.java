package com.sayi.blog.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogPost {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createTime;
    private List<String> tags;

    // 构造方法、getters 和 setters
    public BlogPost(Long id, String title, String content, String author, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createTime = LocalDateTime.now();
        this.tags = tags;
    }

    // 省略getter/setter方法
}