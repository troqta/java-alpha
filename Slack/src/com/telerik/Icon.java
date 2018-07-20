package com.telerik;

import java.io.File;

public class Icon extends Message {
    private Icons icon;

    public Icon(String author, Icons icon) {
        super(author);
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "This is an icon with path: " + icon;
    }

    @Override
    public void showMessage() {
        System.out.println("Author: " + getAuthor() + "Content: " + icon);
    }

    public Icons getIcon() {
        return icon;
    }
}
