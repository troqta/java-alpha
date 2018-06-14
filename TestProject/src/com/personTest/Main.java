package com.personTest;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Name1", 20, "0123451289" ));
        people.add(new Person("Name2", 22, "0123456789" ));
        people.add(new Person("Name3", 21, "0123454389" ));
        people.add(new Person("Name4", 24, "0123455789" ));
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getName().equals("Name1")){
                people.get(i).addFriend(people.get(3));
                people.get(i).addInterest("Gaming");
            }
        }
        for(Person person : people){
            person.printPerson();

        }
    }

}
