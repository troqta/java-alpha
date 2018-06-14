package com.villian;

public class Power {
    private String name;
    private boolean good;
    public Power(String name){
        this.name=name;
    }
    public Power(String name, boolean good){
        this.name= name;
        this.good=good;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }
    private static Power flight = new Power("Flight", true);

    public static Power getFlight() {
        return flight;
    }
}
