package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
    //委托对象
    private Object obj;

    //返回代理对象
    public Object bind(Object obj){
        this.obj=obj;
        return Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),this.obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"方法的参数是:"+ Arrays.toString(args));
        Object result=method.invoke(this.obj,args);
        System.out.println(method.getName()+"方法的执行结果是:"+ result);
        return result;
    }
}
