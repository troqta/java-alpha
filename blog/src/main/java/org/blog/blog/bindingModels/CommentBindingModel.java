package org.blog.blog.bindingModels;

import org.blog.blog.repositories.ArticleRepository;
import org.blog.blog.repositories.CommentRepository;
import org.blog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

public class CommentBindingModel {
    @NotNull
    private String content;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
