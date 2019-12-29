package test;

import org.testng.annotations.Test;

public class IfelseTest{
    @Test
    public void ageTest(){
//        | 年龄····范围 | 描述 |
//        | ------------ | ---- |
//        | ·0 ~ 6岁     | 儿童 |
//        | 7 ~ 17岁     | 少年 |
//        | 18 ~ 40岁    | 青年 |
//        | 41 ~ 59岁    | 中年 |
//        | 60及以上     | 老年 |

        int age=90;
        if (age<7){
            System.out.print(age+"岁，属于儿童");
        }else if (age<18){
            System.out.print(age+"岁，属于少年");
        }else if (age<41){
            System.out.print(age+"岁，属于青年");
        }else if (age<60){
            System.out.print(age+"岁，属于中年");
        }else{
            System.out.print(age+"岁，属于老年");
        }
    }
    
}
