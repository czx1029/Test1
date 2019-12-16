package com.Exercise.array;

import org.testng.annotations.Test;

import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    @Test
    public void testArrayDeclare() {
        int[] arr1;
        String[] arr2;
        int arr3[];
        String arr4[];
    }

    @Test
    public void testFuzhi() {
        int[] arr0 = new int[0];
        System.out.println(Arrays.toString(arr0));

        int[] arr1 = new int[5];
        System.out.println(Arrays.toString(arr1));

        boolean[] arr2 = new boolean[3];
        System.out.println(Arrays.toString(arr2));

        String[] arr3 = new String[3];
        System.out.println(Arrays.toString(arr3));

        Object[] arr4 = new Object[5];
        System.out.println(Arrays.toString(arr4));

        int[] arr5;
        System.out.println();
        arr5 = new int[2];
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = new int[] {3, 2, 3};
        System.out.println("arr6 = " + Arrays.toString(arr6));

        int[] arr7 = {3, 2, 3};
        System.out.println("arr7 = " + Arrays.toString(arr7));

        String[] arr8 = {"字符串1", null, "字符串2", ""};
        System.out.println("arr8 = " + Arrays.toString(arr8));

        Integer[] arr9 = {2, 9, 7, null, 0, 5};
        System.out.println("arr9 = " + Arrays.toString(arr9));
    }

    @Test
    public void testBianLi() {
//        Java 种对数组的遍历主要有以下三种方式：
//
//        1. for 循环使用数组下标
//        2. for each 循环
//        3. Java 8 中新增的 Lambda 表达式
//        // 示例：分别使用上述三种方式遍历数组 Integer[] arr = {1, 2, 3, 4, 5};
        Integer[] arr = {1, 2, 3, 4, 5};

        for (int index = 0; index < arr.length; index++) {
            // System.out.println("下标：" + index + ", 存放的值是：" + arr[index]);
            System.out.println(String.format("下标：%d, 存放的值是：%d", index, arr[index]));
        }

        int index = 0;
        for (int val : arr) {
            System.out.println("第" + index + "次取到" + val);
            index++;
        }

        Arrays.asList(arr).forEach(val -> {
            System.out.println("值是：" + val);
            if (val % 2 == 0) {
                System.out.println("  它是一个偶数");
            } else {
                System.out.println("  它是一个奇数");
            }
        });
    }

    @Test
    public void testCopy() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] arr2 = {6, 7, 8, 9, 10};
        // 拷贝数组 arr1 的前 3 个元素生成一个新的数组
        Integer[] arr11 = new Integer[3];
        arr11[0] = arr1[0];
        arr11[1] = arr1[1];
        arr11[2] = arr1[2];
        System.out.println("arr11 = " + Arrays.toString(arr11));

        Integer arr12[] = Arrays.copyOf(arr1, 3);
        System.out.println("arr12 = " + Arrays.toString(arr12));

        // 拷贝数组 arr1 的后 3 位的元素到一个新的数组
        Integer arr13[] = Arrays.copyOfRange(arr1, arr1.length - 3, arr1.length);
        System.out.println("arr13 = " + Arrays.toString(arr13));

        // 拷贝数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
        Integer arr14[] = Arrays.copyOfRange(arr1, 0, 2);
        System.out.println("arr14 = " + Arrays.toString(arr14));

        // 拷贝数组 arr2 的后 3 位到 arr1 到后 3 位
        System.arraycopy(arr2, arr2.length - 3, arr1, arr1.length - 3, 3);
        System.out.println("arr1 = " + Arrays.toString(arr1));
    }

    @Test
    public void testFill(){
//        使用工具类提供的方法 `Arrays.fill` 可以对数组全部或指定范围内的元素赋值为指定的值。
//        示例：定义一个大小为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；然后将数组后 3 为赋值为 3，再次打印数组。
        int arr[]=new int [10];
        Arrays.fill(arr,5);
        System.out.println(Arrays.toString(arr));

        Arrays.fill(arr,arr.length-3,arr.length,3);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSort(){
//        可以使用 Arrays.sort 方法对数组进行排序。
//        示例：定义一个大小为 100 的 int 数组，随机给每一位赋值一个 `0 ~ 100` 之间的数值，然后对该数组进行排序并打印排序结果。
        int arr[]=new int [100];
        for (int i=0;i<100;i++){
            arr[i]=new Random().nextInt(100);
        }
        System.out.println("排序前 "+Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后 "+Arrays.toString(arr));
    }

    @Test
    public void testDuoWeiShuZu(){
//        前边介绍出现的数组，都是一维数组，Java 实际上没有多维数组，只有一维数组。多维数组可以被理解为“数组的数组”。多维数组的同一个维可以有不同的长度，因此也可以称为不规则数组。声明时使用多个 [] 标识来声明。
//        示例：定义一个二维数组，第一维表示用户，第二维表示用户的具体信息（1. 编码, 2. 姓名, 3.性别, 4.年龄）。定义赋值并打印。
        String[][] users = new String[2][];
        users[0] = new String[4];
        users[0][0] = "001";
        users[0][1] = "张三";
        users[0][2] = "女";
        users[0][3] = "25";

        users[1] = new String[4];
        users[1][0] = "002";
        users[1][1] = "李四";
        users[1][2] = "男";
        users[1][3] = "30";

        System.out.println(Arrays.toString(users));

        for (String[] user : users) {
            System.out.println(Arrays.toString(user));
        }

        Arrays.asList(users).forEach(user -> System.out.println(Arrays.toString(user)));
    }



//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//    示例:
//    给定 nums = [2, 7, 11, 15], target = 9
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]

    public int[] twoSum(int[] nums, int target) {
        int times=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                times++;
                if (nums[i] + nums[j] == target) {
                    System.out.println("循环了"+times+"次");
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        System.out.println("传入数组"+Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序数组"+Arrays.toString(nums));
        int times=0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]>=target){
                System.out.println("第一个数"+nums[i]+"已经大于"+target);
                System.out.println("循环了"+times+"次");
                return null;
            }
            for (int j = i + 1; j < nums.length; j++) {
                times++;
                if (nums[j]>target){
                    System.out.println("循环了"+times+"次");
                    break;
                }
                if (nums[i] + nums[j] == target) {
                    System.out.println("循环了"+times+"次");
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }



    @Test
    public void tsetTwoSum(){
        int[] intArray = {20,2,3, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(intArray,target)));
        System.out.println("===================================");
        System.out.println(Arrays.toString(twoSum2(intArray,target)));
    }
}
