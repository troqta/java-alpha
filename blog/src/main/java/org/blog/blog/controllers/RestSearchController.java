package org.blog.blog.controllers;

import org.blog.blog.bindingModels.SearchDTO;
import org.blog.blog.entity.Article;
import org.blog.blog.repositories.ArticleRepository;
import org.blog.blog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestSearchController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/test")
    public List<SearchDTO> getCategory(){
        List<SearchDTO> dtos = new ArrayList<>();
        List<Article> articles = this.articleRepository.findAll();

        for(Article article : articles){
            String categoryName = article.getCategory().getName();

            SearchDTO dto = new SearchDTO(categoryName, article);
            dtos.add(dto);
        }
        return dtos;

    }
}
