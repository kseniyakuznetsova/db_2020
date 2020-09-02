package homework.hero_game.factory;

import homework.hero_game.heroes.Hero;
import homework.hero_game.heroes.Hobbit;

public class HobbitFactory implements HeroFactory {
    @Override
    public Hero createHero() {
        return new Hobbit();
    }
}
