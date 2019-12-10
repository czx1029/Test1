import org.testng.annotations.Test;

import java.util.Arrays;

public class homeworkTest {
    @Test
    public void vampireTest(){
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 11; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int k = i * j;
                // 变为字符串来操作，比较字符串
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
        System.out.println("共找到" + sum + "组吸血鬼数");
        long end = System.currentTimeMillis();
        System.out.println("所用时间：" + (end - start)+"ms");
    }

}
