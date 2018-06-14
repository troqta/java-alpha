package org.blog.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {
    private Integer Id;
    private String title;
    private String content;
    @JsonBackReference
    private User author;
    @JsonBackReference
    private Category category;
    @JsonBackReference
    private Set<Tag> tags;
    @JsonBackReference
    private String summary;
    @JsonBackReference
    private String imagePath;
    @JsonBackReference
    private String date;
    @JsonBackReference
    private List<Comment> comments;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(columnDefinition = "text", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @ManyToOne
    @JoinColumn(nullable = false, name ="authorId")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Article(String title, String content, User author, Category category, HashSet<Tag> tags, String imagePath, String date){
        this.title= title;
        this.content=content;
        this.author=author;
        this.category=category;
        this.tags=tags;
        this.imagePath=imagePath;
        this.date=date;
    }

    public Article(){}

    @Transient
    public String getSummary(){
            if(this.getContent().length()>200){
            return this.getContent().substring(0, this.getContent().length() / 2)+ "...";}
            else if(this.getContent().length()>300){
                return this.getContent().substring(0, this.getContent().length() / 3)+"...";
            }
            return this.getContent();
    }

    @ManyToOne
    @JoinColumn(nullable = false,name = "categoryId")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany()
    @JoinColumn(table = "articles_tags")
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Column(name="imagePath")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "article")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
