package homework.hero_game.factory;

import homework.hero_game.heroes.Hero;
import homework.hero_game.heroes.King;

public class KingFactory implements HeroFactory {

    @Override
    public Hero createHero() {
        return new King();
    }
}
