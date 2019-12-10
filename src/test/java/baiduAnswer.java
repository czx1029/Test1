import java.util.Arrays;

/**
 * 从TIJ中第4章的练习10看到“吸血鬼数字”,以下几种方法实现以及执行时间对比
 * 找出四位数的所有吸血鬼数字
 * 吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字，
 * 其中从最初的数字中选取的数字可以任意排序.
 * 以两个0结尾的数字是不允许的。
 * 例如下列数字都是吸血鬼数字
 *     1260=21*60
 *     1827=21*87
 *     2187=27*81
 */
public class baiduAnswer {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fun1();
        long end = System.currentTimeMillis();
        System.out.println("方法1所用时间：" + (end - start)+"ms"+"\n");

        start = System.currentTimeMillis();
        fun2();
        end = System.currentTimeMillis();
        System.out.println("方法2所用时间：" + (end - start)+"ms"+"\n");

        start = System.currentTimeMillis();
        fun3();
        end = System.currentTimeMillis();
        System.out.println("方法3所用时间：" + (end - start)+"ms"+"\n");

        start = System.currentTimeMillis();
        fun4();
        end = System.currentTimeMillis();
        System.out.println("方法4所用时间：" + (end - start)+"ms"+"\n");
    }

    private static void fun1() {
        //参考答案
        int sum = 0;
        int[] startDigit = new int[4];
        int[] productDigit = new int[4];
        for (int num1 = 10; num1 <= 99; num1++)
            for (int num2 = num1; num2 <= 99; num2++) {
                // Pete Hartley's theoretical result:
                // If x·y is a vampire number then
                // x·y == x+y (mod 9)
                if ((num1 * num2) % 9 != (num1 + num2) % 9)
                    continue;
                int product = num1 * num2;
                startDigit[0] = num1 / 10;
                startDigit[1] = num1 % 10;
                startDigit[2] = num2 / 10;
                startDigit[3] = num2 % 10;
                productDigit[0] = product / 1000;
                productDigit[1] = (product % 1000) / 100;
                productDigit[2] = product % 1000 % 100 / 10;
                productDigit[3] = product % 1000 % 100 % 10;
                int count = 0;
                for (int x = 0; x < 4; x++)
                    for (int y = 0; y < 4; y++) {
                        if (productDigit[x] == startDigit[y]) {
                            count++;
                            productDigit[x] = -1;
                            startDigit[y] = -2;
                            if (count == 4) {
                                System.out.println("第" + sum + "组: " + num1 + " * " + num2 + " : " + product);
                                sum++;
                            }
                        }
                    }
            }
        System.out.println("方法1共找到" + sum + "组吸血鬼数");
    }

    private static void fun2() {
        String[] ar_str1, ar_str2;
        int sum = 0;
        int from;
        int to;
        int i_val;
        for (int i = 10; i < 100; i++) {
            from = Math.max(1000 / i, i + 1);
            to = Math.min(10000 / i, 100);
            // 2个数的乘积是4位数(大于等于1000,小于10000),i确定时,另一个数范围随之确定
            for (int j = from; j < to; j++) {
                i_val = i * j;
                if (i_val % 100 == 0 || (i_val - i - j) % 9 != 0) {
                    // (i_val - i - j) % 9 != 0 的理解:
                    // 假设val = 1000a + 100b + 10c + d, 因为满足val = x * y, 则有x =
                    // 10a + b, y = 10c + d
                    // 可得val - x - y = 990a + 99b + 9c = 9 * (110a + 11b + c),
                    // 所以val - x - y能被9整除。
                    // 满足该条件的数字必定能被9整除,可以直接过滤其他数字。
                    continue;
                }
                ar_str1 = String.valueOf(i_val).split("");
                ar_str2 = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(ar_str1);
                Arrays.sort(ar_str2);
                if (Arrays.equals(ar_str1, ar_str2)) {
                    sum++;
                    System.out.println("第" + sum + "组: " + i + "*" + j + "=" + i_val);
                }
            }
        }
        System.out.println("方法2共找到" + sum + "组吸血鬼数");
    }

    private static void fun3() {
        int sum = 0;
        for (int i = 11; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int k = i * j;
                // 有另一种变为字符串来操作,比较发现下面的这种方法耗时更少
                int[] a = { k / 1000, k / 100 % 10, k / 10 % 100 % 10, k % 1000 % 100 % 10 };
                int[] b = { i % 10, i / 10, j % 10, j / 10 };
                Arrays.sort(a);
                Arrays.sort(b);
                if (Arrays.equals(a, b)) {
                    sum++;
                    System.out.println("第" + sum + "组: " + i + " * " + j + " = " + k);
                }
            }
        }
        System.out.println("方法3共找到" + sum + "组吸血鬼数");
    }

    private static void fun4() {
        //逆向思维
        String[] targetNum = null;
        String[] gunNum = null;
        int sum = 0;
        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                // 没有哪个两位数满足ab*ab=abab,所以这里j从i+1开始就可以了
                int i_target = i * j;
                if (i_target < 1000 || i_target > 9999)
                    continue; // 积不是4位数则跳过
                targetNum = String.valueOf(i_target).split("");
                gunNum = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(targetNum);
                Arrays.sort(gunNum);
                if (Arrays.equals(targetNum, gunNum)) {
                    sum++;
                    System.out.println("第" + sum + "组: " + i_target + "=" + i + "*" + j);
                }
            }
        }
        System.out.println("方法4找到" + sum + "个吸血鬼数字。");
    }
}