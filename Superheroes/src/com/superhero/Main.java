package com.superhero;

public class Main {

    public static void main(String[] args) {

        Superhero batman = new Superhero("Batman", "Bruce Wayne", Alignment.Good);
        Superhero superman = new Superhero("Superman", "Clark Kent", Alignment.Good);
        Power kryptonite = new Power("Kryptonite", PowerTypes.Chemical);
        Power technology = new Power("Technology", PowerTypes.Tech);

        batman.addPower(kryptonite);
        batman.addPower(technology);
        superman.addImmunity(PowerTypes.Tech);

        System.out.println(superman.getName() + "'s Lifepoints: " + superman.getLifePoints());

        batman.attack(superman, technology);
        System.out.println(superman.getName() + "'s Lifepoints: " + superman.getLifePoints());

        batman.attack(superman, kryptonite);
        System.out.println(superman.getName() + "'s Lifepoints: " + superman.getLifePoints());
        batman.listPowers();

        Superhero testHero = new Superhero("Te", "randomIdentity", Alignment.Neutral);
        //System.out.println(testHero.getName());
        //System.out.println(testHero.getSecretIdentity());
    }
}
