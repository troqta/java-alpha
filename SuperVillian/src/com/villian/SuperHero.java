package com.villian;

import java.util.ArrayList;

public class SuperHero extends Hero {
    public SuperHero(){

    }

    public SuperHero(String name, Gender gender, double weight, String secretIdentity, String backStory, Boolean isGood, ArrayList<Power> listOfPowers) {
        super(name, gender, weight, secretIdentity, backStory, isGood, listOfPowers);
    }
    public void saveWorld(){
        System.out.println(getName()+" just saved the world!");
    }
    public void isUseless(){
        System.out.println(getName()+" was a useless cheerleader.");
    }
    @Override
    public void addSuperPower(Power power){
        if(power.isGood()) {
            getListOfPowers().add(power);
        }
        else{
            System.out.println("Superheroes cant get evil powers!");
        }
    }
    @Override
    public boolean canFly(){
        if(getListOfPowers().contains(Power.getFlight())){
            System.out.println("This hero can fly!");
            return true;
        }
        else{
            System.out.println("This hero cant fly!");
            return false;
        }
    }
//    @Override
//    public boolean equals(Object object){
//        if(object == this){
//            return true;
//
//        }
//        else{
//            return false;
//        }
//    }
}
