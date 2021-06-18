package reflect;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Tong
 * @date: 2020-05-14 20:15
 */
public class Test {
    public static void main(String[] args) {
        //被代理类需要实现接口
        Target target = new TargetImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);

        //工厂创建
        Target proxyTarget = (Target)proxyFactory.getProxyInstance();
        proxyTarget.sayHello();
        //手动创建
        Target proxyTarget2 = (Target)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new MyHandler(target));
        proxyTarget2.sayHello();
    }
}
