package my_spring;

public class Context {
    private ObjectFactory objectFactory = ObjectFactory.getInstance();

    public Context(Config config){
        objectFactory.setConfig(config);
    }

    public <T> T create(Class<T> cl) {
        return objectFactory.createObject(cl);
    }
}
