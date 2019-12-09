import org.testng.annotations.Test;

import java.util.Random;

public class WhileTest {
    @Test
    public void  whileTest(){
//        练习：随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。
//        生成 `0 ~ 1000` 范围的整数使用语句 `int r = new Random().nextInt(1000)`。
        boolean isContinue=true;
        int times=0;
        while (isContinue){
            int r=new Random().nextInt(10);
            if(r%30==0){
                System.out.println("随机数：" + r + "能被30整除，不在执行循环");
                isContinue=false;
            }else {
                System.out.println("随机数：" + r + "不能被30整除，继续");
                times++;
//                times=times+1;
//                ++times;
//                times+=1;
            }
        }
        System.out.println("产生了" + times + "个不能被30整除的数");
    }
    @Test
    public void doWhileTest(){
//        练习：和 `while` 部分的练习一样，随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，
//        如果能被30整除则退出循环。
        boolean isContinue=true;
        int times=0;
        do{
            int r=new Random().nextInt(1000);
            if(r%30==0){
                System.out.println("随机数：" + r + "能被30整除，不在执行循环");
                isContinue=false;
            }else {
                System.out.println("随机数：" + r + "不能被30整除，继续");
                times++;
//                times=times+1;
//                ++times;
//                times+=1;
            }
        }while (isContinue);
        System.out.println("产生了" + times + "个不能被30整除的数");
    }
    @Test
    public void forTest(){
//        练习：打印 `0 ~ 100` 范围内的单数并计算范围内单数的总个数。
        int total=0;
        for (int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println("单数"+i);
                total++;
            }
        }
        System.out.println("0 ~ 100之间的单数总个数是：" + total  + "个");
    }
    @Test
    public void switchTest(){
//        |数字指令    |执行命令
//        |----------|--------|
//        |1         |扫地
//        |2         |开灯
//        |3         |关灯
//        |4         |播放音乐
//        |5         |关闭音乐
//        |其他数字   |不能识别的指令
        int sw=3;
        switch (sw){
            case 1:
                System.out.println("扫地");
                break;
            case 2:
                System.out.println("开灯");
                break;
            case 3:
                System.out.println("关灯");
                break;
            case 4:
                System.out.println("播放音乐");
                break;
            case 5:
                System.out.println("关闭音乐");
                break;
            default:
                System.out.println("不能识别的指令");
        }

    }

    @Test
    public void breakTest(){
//        练习1：还是前边的练习，我们来改写一下。随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。
        int i=0;
        while (true) {
            int r = new Random().nextInt(1000);
            if (r % 30 == 0) {
                System.out.println("随机数：" + r + "能被30整除，不在执行循环");
                break;
            } else {
                System.out.println("随机数：" + r);
                i++;
            }
        }
        System.out.println("产生了" + i + "个不能被30整除的数");
    }

//        练习2：编写一个方法 `int getMaxNumRem7(int n1, int n2)` 找出 `0 ~ n2` 范围内除以 n1 余 7 的最大的数，找到则返回该数，如果找不到则返回 -1。

    int getMaxNumRem7(int n1, int n2) {
        for (int n = n2; n >= 0; n--) {
            if (n % n1 == 7) {
                return n;
            }
        }
        return -1;
    }


    @Test
    public void returnTest(){
        int i=getMaxNumRem7(34,214352);
        System.out.println(i);
    }


        @Test
    public void totalTest(){
//            练习3：找出 `0 ~ 100` 范围内能被7整除的数，并计算它们累计相加的结果。
        int total=0;
            for (int n = 0; n < 100; n++) {
                if (n % 7 != 0) {
                    continue;
                }
                total += n;
                System.out.println(n + "能被7整除，累计结果：" + total);
            }
            System.out.println("0 ~ 100范围内能被7整除的数累计相加结果：" + total);
    }
}
