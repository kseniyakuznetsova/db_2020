package my_spring;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class BenchmarkAnnotationProxyConfigurer implements ProxyConfigurer {
    @Override
    public <T> T configure(T t, Class type) {
        boolean hasMethodAnnotation = Arrays.stream(type.getMethods()).anyMatch(m -> m.isAnnotationPresent(Benchmark.class));
        if (type.isAnnotationPresent(Benchmark.class) || hasMethodAnnotation) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    System.out.println("************* BENCHMARK STARTED for method "+ method.getName()+" ****************");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end-start);
                    System.out.println("************* BENCHMARK ENDED for method "+ method.getName()+" ****************");
                    return retVal;
                }
            });
        }
        return t;
    }
}
