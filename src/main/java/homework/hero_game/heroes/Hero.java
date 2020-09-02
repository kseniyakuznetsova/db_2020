package homework.hero_game.heroes;

import lombok.Data;

@Data
public abstract class Hero {
    protected int power;
    protected int hp;

    public abstract void kick(Hero rival);

    public boolean isAlive(){
        return hp > 0;
    }
}
