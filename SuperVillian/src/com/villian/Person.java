package com.villian;

public class Person {
    private String name;
    private Gender gender;
    private double weight;

    public Person(String name, Gender gender, double weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;

    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
