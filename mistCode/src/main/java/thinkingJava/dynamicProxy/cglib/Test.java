package thinkingJava.dynamicProxy.cglib;

/**
 * Created by lixiaojian on 2017/4/12.
 */
public class Test {
    // http://blog.csdn.net/dreamrealised/article/details/12885739
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        // base为生成的增强过的目标类
        Base base = Factory.getInstance(proxy);
        base.add();
    }
}
