package homework.hero_game.heroes;

public class Hobbit extends Hero {

    public Hobbit(){
        power = 0;
        hp = 3;
    }

    @Override
    public void kick(Hero rival) {
        toCry();
    }

    private void toCry(){
        System.out.println("I'm cry");
    }
}
