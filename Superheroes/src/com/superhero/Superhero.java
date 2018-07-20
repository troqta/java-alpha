package com.superhero;

import java.util.ArrayList;
import java.util.List;

public class Superhero {
    private String name;
    private String secretIdentity;
    private Alignment Alignment;
    private int lifePoints;
    private ArrayList<PowerTypes> immunities;
    private ArrayList<Power> powers;

    public Superhero(String name, String secretIdentity, Alignment alignment, ArrayList<PowerTypes> immunities, ArrayList<Power> powers) {
        setName(name);
        setSecretIdentity(secretIdentity);
        this.lifePoints = 100;
        this.Alignment = alignment;
        this.immunities = immunities;
        this.powers = powers;
    }

    public Superhero(String name, String secretIdentity, Alignment alignment) {
        setName(name);
        setSecretIdentity(secretIdentity);
        this.lifePoints = 100;
        this.Alignment = alignment;
        this.immunities = new ArrayList<PowerTypes>();
        this.powers = new ArrayList<Power>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 3 && name.length() < 60) {
            this.name = name;
        } else {
            //throw new MyException("Test Message");
            System.out.println("Name should be between 3 and 60 symbols long");
            return;
        }
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        if (secretIdentity.length() > 3 && secretIdentity.length() < 60) {
            this.secretIdentity = secretIdentity;
        } else {
            System.out.println("Secret identity should be between 3 and 60 symbols long");
            return;
        }
    }

    public com.superhero.Alignment getAlignment() {
        return Alignment;
    }

    public void setAlignment(com.superhero.Alignment alignment) {
        Alignment = alignment;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void takeDamage() {
        if (lifePoints > 0) {


            lifePoints -= 10;
        } else {
            System.out.println(name + " is already dead! Stop beating on him");
        }
    }

    public List<PowerTypes> getImmunities() {
        return immunities;
    }

    public void setImmunities(ArrayList<PowerTypes> immunities) {
        this.immunities = immunities;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<Power> powers) {
        this.powers = powers;
    }

    public void addPower(Power power) {
        powers.add(power);
        System.out.println("Succesfully added " + power.getName() + " to " + name);
    }

    public void addImmunity(PowerTypes powerType) {
        immunities.add(powerType);

    }

    public void attack(Superhero superhero, Power power) {
        if (superhero.getImmunities().contains(power.getPowerTypes())) {
            superhero.takeDamage();
            System.out.println(name + " dealth 10 damage to " + superhero.getName() + " with " + power.getName());
        } else {
            System.out.println("Target is immune to " + power.getName());
        }

    }

    public void listPowers() {
        System.out.println(name + "'s Powers:");
        for (int i = 0; i < powers.size(); i++) {
            System.out.println(powers.get(i).getName());

        }
    }
}
