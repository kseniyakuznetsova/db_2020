package my_spring;

import java.util.Map;

public class ObjectFactoryConfig {
    private Map<Class, Class> ifc2ImplClass;

    public ObjectFactoryConfig(){
        ifc2ImplClass = Map.of(
                Speaker.class, ConsoleSpeaker.class,
                Cleaner.class, CleanerImpl.class
        );
    }

    public <T> Class<T> getImplementationClass(Class<T> type){
        return ifc2ImplClass.get(type);
    }
}
