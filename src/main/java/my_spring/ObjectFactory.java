package my_spring;

import heroes.RandomUtil;
import lombok.Setter;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private ApplicationContext context;

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();

    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    private Reflections scanner;

    @SneakyThrows
    ObjectFactory(ApplicationContext context, Reflections scanner) {
        this.scanner = scanner;
        this.context = context;

        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }

        Set<Class<? extends ProxyConfigurer>> proxyClasses = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> aClass : proxyClasses) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                proxyConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {


        T t = create(implClass);

        configure(t);

        invokeInitMethod(implClass, t);

        t = wrap(t);

        return t;
    }




    private <T> void invokeInitMethod(Class<? extends T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);

            }
        }
    }



    private <T> T wrap(T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = proxyConfigurer.configure(t);
        }
        return t;
    }


    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t,context));
    }

    private <T> T create(Class<? extends T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }


}








