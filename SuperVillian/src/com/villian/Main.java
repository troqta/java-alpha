package com.villian;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SuperHero superMan = new SuperHero("SuperMan",
                Gender.MALE,
                100,
                "Clark Kent",
                "Random tragic backstory",
                true,
                new ArrayList<>());
        SuperHero wonderWoman = new SuperHero("Wonder Woman",
                Gender.FEMALE,
                50,
                "some name",
                "Random tragic backstory",
                true,
                new ArrayList<>());
        SuperVillian darkseid = new SuperVillian("Darkseid",
                Gender.MALE,
                200,
                "WHY WOULD A VILLIAN NEED A SECRET IDENTITY ??",
                "Random tragic backstory",
                false,
                new ArrayList<>());

        Power kryptonianBullshit = new Power("Kryptonian Bullshit", true);
        Power godBullshit = new Power("God Bullshit", false);
        Power theForce = new Power("randomPower", false);

        superMan.addSuperPower(kryptonianBullshit);
        superMan.addSuperPower(Power.getFlight());
        wonderWoman.addSuperPower(godBullshit);
        darkseid.addSuperPower(theForce);

        superMan.canFly();

        darkseid.destroy();
        superMan.saveWorld();
        wonderWoman.isUseless();
    }
}