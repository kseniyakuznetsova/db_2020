package my_spring;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {


        Map<Class<?>, Class<?>> map = Map.of(
                Speaker.class, ConsoleSpeaker.class
                );


        //ObjectFactory.getInstance().setConfig(new JavaConfig(map,"my_spring"));

        Context context = new Context(new JavaConfig(map,"my_spring"));
        IRobot iRobot = context.create(IRobot.class);
        iRobot.cleanRoom();
    }
}
