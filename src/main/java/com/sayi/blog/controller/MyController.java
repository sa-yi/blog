package com.sayi.blog.controller;

import com.sayi.blog.model.BlogPost;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/posts")
    public List<BlogPost> getPosts() {
        return List.of(
                new BlogPost(1L, "Vue 3入门指南", "本文介绍Vue 3的基础用法...", "张三", List.of("前端", "Vue")),
                new BlogPost(2L, "Spring Boot实践", "Spring Boot开发技巧分享...", "李四", List.of("后端", "Java")),
                new BlogPost(3L, "aaaa", "Spring Boot开发技巧分享...", "李四", List.of("后端", "Java"))
        );
    }

    @GetMapping("/posts/{id}")
    public BlogPost getPostById(@PathVariable Long id) {
        return new BlogPost(id, "示例文章", "这里是文章内容...", "管理员", List.of("示例"));
    }

    @GetMapping("/categories")
    public Map<String, Integer> getCategories() {
        return Map.of(
                "技术文章", 15,
                "生活随笔", 8,
                "读书笔记", 5
        );
    }
}