package com.telerik;

public class Text extends Message implements Likeable {
    private String content;
    private int likes;

    public Text(String author, String content) {
        super(author);
        likes = 0;
        this.content = content;
    }

    @Override
    public void like() {
        likes++;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {

        return likes;
    }

    @Override
    public String toString() {
        return "Author: " + getAuthor() + "Content: " + content;
    }

    @Override
    public void showMessage() {
        System.out.println("Timestamp" + getTimestamp().toString() + "Author: " + getAuthor() + "Content: " + content);
    }
}
