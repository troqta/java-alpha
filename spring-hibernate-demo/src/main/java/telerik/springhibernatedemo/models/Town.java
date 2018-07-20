package telerik.springhibernatedemo.models;


import org.hibernate.annotations.Table;

import javax.persistence.Entity;

@Entity
@Table(name= "")
public class Town {

    private int id;
    private String name;

    public Town(){

    }

    public Town(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
