package com.sayi.blog.service;

import com.sayi.blog.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    public List<BlogPost> getRecentPosts() {
        return List.of(
                new BlogPost(1L, "最新文章1", "内容...", "作者", List.of("最新")),
                new BlogPost(2L, "最新文章2", "内容...", "作者", List.of("推荐"))
        );
    }

    // 其他模拟数据方法...
}