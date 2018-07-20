package org.blog.blog.bindingModels;

import org.blog.blog.entity.Article;
import org.blog.blog.entity.User;
import org.blog.blog.repositories.ArticleRepository;
import org.blog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotNull;

public class ArticleBindingModel {
    @NotNull
    private String title;

    @NotNull
    private String content;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public String getTitle() {
        return title;
    }

    private Integer categoryId;
    private String tagString;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTagString() {
        return tagString;
    }

    public void setTagString(String tagString) {
        this.tagString = tagString;
    }
}
