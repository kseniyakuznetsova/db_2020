package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory objectFactory = new ObjectFactory();
    private ObjectFactoryConfig config = new ObjectFactoryConfig();
    private Reflections reflections = new Reflections("my_spring");

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        //todo finish this
        // if type is concrete class, just create and return it's instance
        //if type is and interface, you should find appropriative impl.

        if (type.isInterface()) {
            Class<T> implClass = config.getImplementationClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
                if(classes.size() > 0){
                    type = (Class<T>) classes.stream().findFirst().get();
                }else{
                    throw new RuntimeException("No implementation of " + type + " found");
                }
            }else {
                type = implClass;
            }
        }
        return type.getConstructor().newInstance();
    }
}
