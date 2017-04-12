package thinkingJava.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by lixiaojian on 2017/4/12.
 */
public class Factory {

    /**
     * 工厂类，生成增强过的目标类（已加入切入逻辑）
     */
    public static Base getInstance(CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        // 此刻，base不是单纯的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        return base;
    }
}