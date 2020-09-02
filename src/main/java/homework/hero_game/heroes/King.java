package homework.hero_game.heroes;

import homework.hero_game.Helper;

public class King extends Hero {

    private HumanKick humanKick = new HumanKick();

    public King(){
        power = Helper.getRandomNumberInRange(5, 15);
        hp = Helper.getRandomNumberInRange(5, 15);
    }

    @Override
    public void kick(Hero rival) {
        humanKick.kick(rival, power);
    }
}
