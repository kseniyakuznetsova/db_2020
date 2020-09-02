package homework.hero_game.heroes;

import homework.hero_game.Helper;

public class Knight extends Hero {

    private HumanKick humanKick = new HumanKick();

    public Knight(){
        power = Helper.getRandomNumberInRange(2, 12);
        hp = Helper.getRandomNumberInRange(2, 12);
    }

    @Override
    public void kick(Hero rival) {
        humanKick.kick(rival, power);
    }
}
