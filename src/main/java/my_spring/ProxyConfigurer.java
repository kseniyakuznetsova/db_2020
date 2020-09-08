package my_spring;

public interface ProxyConfigurer {
   <T> T configure(T t, Class type);
}
