package my_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class SingletonAnnotationConfigurer implements ObjectConfigurer{
    @Override
    @SneakyThrows
    public void configure(Object t) {
        if(t.getClass().isAnnotationPresent(Singleton.class)){
            ObjectFactory.getInstance().addSingletonToCache(t.getClass(), t);
        }
    }
}
