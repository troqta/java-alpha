package com.telerik;

import java.util.Date;

public abstract class Message {
    private static final String DEFAULT_AUTHOR = "default author";

    private String author;
    private Date timestamp;

    public Message(String author) {
        this.author = author;
        timestamp = new Date();
    }

    public Message() {
        this(DEFAULT_AUTHOR);
    }

    public String getAuthor() {
        return author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public abstract void showMessage();

}
