package com.telerik;

import java.io.File;

public class Image extends Message implements Likeable, Downloadable {
    private File image;
    private int likes;

    public Image(String author, String imagePath){
        super(author);
        likes =0;
        image=new File(imagePath);
    }
    @Override
    public File download() {
        return image;
    }

    @Override
    public void like() {
        likes++;
    }

    @Override
    public String toString() {
        return "This is an image with path: "+ image.getPath();
    }
    public void showMessage(){
        System.out.println("This is an image with path: "+ image.getPath());
    }
}
