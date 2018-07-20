package com.telerik;

import java.io.File;

public class FileMessage extends Message implements Downloadable {
    private File file;

    public FileMessage(String author, String filePath) {
        super(author);
        file = new File(filePath);

    }

    @Override
    public java.io.File download() {
        return null;
    }

    @Override
    public String toString() {
        return "This is a file with path: " + file.getPath();
    }

    @Override
    public void showMessage() {
        System.out.println("This is a file with path: " + file.getPath());
    }
}
