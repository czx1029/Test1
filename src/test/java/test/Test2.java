package test;

import org.testng.annotations.Test;

public class Test2 {
    @Test
    public  void Test2() {
//        下边赋值语句超过 short 的最大值 32767，程序在编译时就会报错
//        short s1 = 32768;
//        数值计算时如果计算结果超长了，程序不会报任何错误，会给你一个错误的结果
//        Integer n1=2*Integer.MAX_VALUE;
//        System.out.print(n1);
            long n2 = 1000L;
            System.out.println(n2);

            int n3 = 0x0F;
            System.out.println(n3);

            int n4 = 010;
            System.out.println(n4);

            int n5 = 0b1_0001;
            System.out.println(n5);


    }
}
