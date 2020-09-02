package homework.hero_game.heroes;

public class Elf extends Hero {

    public Elf(){
        power = 10;
        hp = 10;
    }

    @Override
    public void kick(Hero rival) {
        if(this.power > rival.getPower()){
            rival.setHp(0);
        }else{
            rival.setPower(rival.getPower()-1);
        }
    }
}
