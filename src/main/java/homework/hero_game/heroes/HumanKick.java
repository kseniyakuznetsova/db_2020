package homework.hero_game.heroes;

import homework.hero_game.Helper;

public class HumanKick {

    public void kick(Hero rival, int maxPower) {
        rival.setHp(rival.getHp() - Helper.getRandomNumberInRange(0, maxPower));
    }
}
