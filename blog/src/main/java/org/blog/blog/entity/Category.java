package org.blog.blog.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "categories")
public class Category {
    private Integer id;
    private String name;
    private List<Article> articles;


    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.articles = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
