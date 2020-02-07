package proxy;

public class Test {
    public static void main(String[] args) {
     Cal cal=new CalImpl();
     //获取动态代理对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Cal proxy = (Cal) myInvocationHandler.bind(cal);
        System.out.println(proxy.add(10, 1));
        System.out.println(proxy.sub(20, 2));
        System.out.println(proxy.mul(30, 3));
        System.out.println(proxy.div(40, 4));
    }
}
