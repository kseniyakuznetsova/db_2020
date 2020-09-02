package homework.hero_game.factory;

import homework.hero_game.heroes.Elf;
import homework.hero_game.heroes.Hero;

public class ElfFactory implements HeroFactory {
    @Override
    public Hero createHero() {
        return new Elf();
    }
}
