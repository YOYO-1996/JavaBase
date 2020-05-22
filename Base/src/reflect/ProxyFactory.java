package reflect;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Tong
 * @date: 2020-05-14 20:05
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),(proxyInstance,method,args)->{
            System.out.println("代理开始");
            Object reVal = method.invoke(target,args);
            return reVal;
        });
    }

    public static void main(String[] args) {
        Target target = new TargetImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);

        //工厂创建
        Target proxyTarget = (Target)proxyFactory.getProxyInstance();
        proxyTarget.sayHello();
    }
}
