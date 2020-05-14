package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Tong
 * @date: 2020-05-14 20:13
 */
public class MyHandler implements InvocationHandler {
    public Object target;

    public MyHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start.....");
        return method.invoke(target);
    }
}
