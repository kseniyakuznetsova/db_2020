package homework.hero_game;

import homework.hero_game.heroes.Hero;

public class GameManager {
    public void fight(Hero hero1, Hero hero2){
        while (hero1.isAlive() && hero2.isAlive()){
            hero1.kick(hero2);
            hero2.kick(hero1);
            System.out.println("First hero: " + hero1.toString());
            System.out.println("Second hero: " +hero2.toString());
            System.out.println("----------------");
        }
    }

}
