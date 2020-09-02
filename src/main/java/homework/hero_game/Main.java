package homework.hero_game;

import homework.hero_game.factory.HeroFactory;
import homework.hero_game.heroes.Hero;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Hero hero1 = getRandomHeroFactory().createHero();
        Hero hero2 = getRandomHeroFactory().createHero();
        new GameManager().fight(hero1, hero2);
    }

    private static HeroFactory getRandomHeroFactory() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ConfigurationBuilder config = new ConfigurationBuilder()
                .setScanners(new ResourcesScanner(), new SubTypesScanner(false))
                .setUrls(ClasspathHelper.forPackage("homework.hero_game"));
        Reflections reflect = new Reflections(config);
        Set<Class<? extends HeroFactory>> factoriesClasses = reflect.getSubTypesOf(HeroFactory.class);
        Class<? extends HeroFactory> randomFactoryClass = factoriesClasses.stream().skip(Helper.getRandomNumberInRange(0, factoriesClasses.size()-1 )).findFirst().get();
        return randomFactoryClass.getConstructor().newInstance();
    }
}
