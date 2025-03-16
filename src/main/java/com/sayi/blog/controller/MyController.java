package com.sayi.blog.controller;

import com.sayi.blog.model.BlogPost;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyController {
    static List<BlogPost> posts=new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            posts.add(new BlogPost((long) i, "title" + i, "content" + i, "author" + i, List.of("aa", "?")));
        }
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/posts")
    public List<BlogPost> getPosts() {
        return posts;
    }

    @GetMapping("/posts/{id}")
    public BlogPost getPostById(@PathVariable Long id) {
        return posts.get(id.intValue());
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