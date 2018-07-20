package org.blog.blog.bindingModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.blog.blog.entity.Article;

public class SearchDTO {

    @JsonProperty("category")
    private String categoryName;

    @JsonProperty("article")
    private Article articles;

    public SearchDTO(String categoryName, Article articles) {
        this.categoryName = categoryName;
        this.articles = articles;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }
}
