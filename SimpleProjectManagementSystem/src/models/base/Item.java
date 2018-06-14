package models.base;

import base.ValidationException;

public class Item {
    private String title;
    private String description;

    public Item(String title, String description) throws ValidationException {
        setTitle(title);
        setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) throws ValidationException {
        if(title.length()<2 || title.length()>10) {
            throw new ValidationException("Title should be between 2 and 10 symbols long");

        }
        this.title = title;

    }

    public void setDescription(String description) throws ValidationException {
        if(description.length()<2 || description.length()>100) {
            throw new ValidationException("Description should be between 2 and 100 symbols long");

        }
        this.description = description;
    }
    public  void view(){
        System.out.println("---------------");
        System.out.println("Title: "+getTitle());
        System.out.println("Description: "+getDescription());
    }


}
