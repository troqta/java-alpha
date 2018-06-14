package com.villian;

import java.util.ArrayList;

public class Hero extends Person {
    private String secretIdentity;
    private String backStory;
    private Boolean isGood;
    private ArrayList<Power> listOfPowers;

    public Hero(){

    }

    public Hero(String name, Gender gender, double weight, String secretIdentity, String backStory, Boolean isGood, ArrayList<Power> listOfPowers) {
        super(name, gender, weight);
        this.secretIdentity = secretIdentity;
        this.backStory = backStory;
        this.isGood = isGood;
        this.listOfPowers = listOfPowers;
    }
    public void addSuperPower(Power power){
        listOfPowers.add(power);
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getBackStory() {
        return backStory;
    }

    public void setBackStory(String backStory) {
        this.backStory = backStory;
    }

    public Boolean getGood() {
        return isGood;
    }

    public void setGood(Boolean good) {
        isGood = good;
    }

    public ArrayList<Power> getListOfPowers() {
        return listOfPowers;
    }

    public void setListOfPowers(ArrayList<Power> listOfPowers) {
        this.listOfPowers = listOfPowers;
    }
    public boolean canFly(){
        if(getListOfPowers().contains(Power.getFlight())){
            return true;
        }
        return false;
    }
}
