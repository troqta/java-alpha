package org.blog.blog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments")
public class Comment {
    private int id;
    private User author;
    private String content;
    private String date;
    private Article article;
    private String authorName;

    public Comment(User author, String content, Article article, String authorName){
        this.author=author;
        this.content=content;
        this.article=article;
        this.authorName=authorName;

    }


    public Comment(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(nullable = false, name="authorID")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User commenter) {
        this.author = author;
    }

    @Column(name="content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Column(name= "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(nullable = false, name= "articleId")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Column(name= "authorName")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
