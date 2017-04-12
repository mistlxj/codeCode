package thinkingJava.dynamicProxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lixiaojian on 2017/4/12.
 */
public class CglibProxy implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before invoke real method");
        // 执行目标类add方法
        proxy.invokeSuper(o, args);
        System.out.println("after invoke real method");
        return null;
    }
}
