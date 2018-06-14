package com.villian;

import java.util.ArrayList;

public class SuperVillian extends Hero {
    public SuperVillian(){

    }

    public SuperVillian(String name, Gender gender, double weight, String secretIdentity, String backStory, Boolean isGood, ArrayList<Power> listOfPowers) {
        super(name, gender, weight, secretIdentity, backStory, isGood, listOfPowers);
    }
    public void destroy(){
        System.out.println(getName()+" wants to destroy the world!");
    }
    @Override
    public void addSuperPower(Power power){
        if(!power.isGood()){
           getListOfPowers().add(power);
        }
        else{
            System.out.println("Villians cant learn righteous powers");
        }
    }
    @Override
    public boolean canFly(){
        if(getListOfPowers().contains(Power.getFlight())){
            System.out.println("This villian can fly!");
            return true;
        }
        else{
            System.out.println("This villian cant fly!");
            return false;
        }
    }
}
