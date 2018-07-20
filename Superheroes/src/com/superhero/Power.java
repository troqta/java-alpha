package com.superhero;

public class Power {
    private String name;
    private PowerTypes powerTypes;

    public Power(String name, PowerTypes powerTypes) {
        setName(name);
        this.powerTypes = powerTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 3 && name.length() < 20) {
            this.name = name;
        } else {
            System.out.println("Power name should be between 3 and 20 symbols long");
            return;
        }
    }

    public PowerTypes getPowerTypes() {
        return powerTypes;
    }

    public void setPowerTypes(PowerTypes powerTypes) {
        this.powerTypes = powerTypes;
    }
}
