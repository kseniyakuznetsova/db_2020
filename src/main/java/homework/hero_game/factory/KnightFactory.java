package homework.hero_game.factory;

import homework.hero_game.heroes.Hero;
import homework.hero_game.heroes.Knight;

public class KnightFactory implements HeroFactory {
    @Override
    public Hero createHero() {
        return new Knight();
    }
}
