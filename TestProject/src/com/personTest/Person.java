package com.personTest;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    ArrayList<String> interests;
    ArrayList<Person> friends;

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.interests = new ArrayList<String>();
        this.friends = new ArrayList<Person>();
    }

    public Person(String name, int age, String phoneNumber, ArrayList<String> interests, ArrayList<Person> friends) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.interests = interests;
        this.friends = friends;
    }

    public void addInterest(String interest) {
        this.interests.add(interest);
    }

    public void addFriend(Person friend) {
        this.friends.add(friend);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public ArrayList<Person> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Person> friends) {
        this.friends = friends;
    }

    public void printPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone number: " + phoneNumber);
        printInterests();
        printFriends();

        System.out.println("- - - - - - - - -");

    }

    public void printInterests() {
        System.out.print("Interests: ");
        for (String interest :
                interests) {
            System.out.print(interest + ", ");

        }
        System.out.println();
    }

    public void printFriends() {
        System.out.print("Friends: ");
        for (Person friend :
                friends) {
            System.out.print(friend.getName() + ", ");

        }
        System.out.println();
    }

}
