# Java Lesson

## 2019-12-05

### 公告

1. 想让大家平时练习时就把 git 和 maven 用上，今晚讲一下它们的简单用法
   - 在 github 上创建项目
   - 创建 maven 项目，常见的配置，如何在 pom.xml 加入依赖项目
   - maven 编译
   - git 提交代码到 github 你创建的项目上
2. ：条件、循环、循环嵌套等
3. 使用 LeetCode 上的一些和当前所学内容相关的算法题来作为课堂练习

### git + maven 的安装和使用

- maven 安装
    - 下载 maven 最新版本，https://maven.apache.org/download.cgi
    - 解压下载的安装包（例如：apache-maven-3.6.3-bin.zip）到某个目录
    - windows 环境下将目录 `maven解压目录\bin` 添加到环境变量 Path 上
    - mac 环境，在 `~/.bash_profile` 文件中加入一行，然后执行一下 `source ~/.bash_profile` 使之生效
        ```
        export PATH=/maven解压目录/bin:$PATH
        ```
    - 命令行下执行 `mvn --version`，如果能正确显示版本号，说明安装正确，比如显示内容如下：
        ```
        ➜  java-les mvn --version
        Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-05T03:00:29+08:00)
        Maven home: /Users/sh/bin/mvn
        Java version: 1.8.0_212, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_212.jdk/Contents/Home/jre
        Default locale: zh_CN, platform encoding: UTF-8
        OS name: "mac os x", version: "10.15", arch: "x86_64", family: "mac"
        ```
- 注册 github 账号
- 新建一个项目
    - 登录成功后，点击右上角【+】，在下拉菜单中选择【New repository】
    - 填写项目名（Repository name）和描述（Description）
    - 选择公共库（Public）、不使用 README.md 初始化
    - 点击【Create repository】进行创建
- 将自己项目上传 github
    - 下载 git，https://www.git-scm.com/download/
    - 安装后，进入命令行执行 `git --version`，如果能正常显示版本号说明安装正确，比如显示内容如下：
        ```
        ➜  java-les git --version
        git version 2.21.0
        ```
    - 设置 git 用户名、邮箱
        ```
        git config user.name
        git config user.email
        git config --global user.name "你的名字，显示在git提交历史记录里的名字"
        git config --global user.email "你的邮箱，显示在git提交历史记录里的邮箱"
        ```
    - 将示例空项目，按 maven 项目导入
    - 使用 git 命令初始化仓库，并将第一个版本上传
        ```
        git init
        git add .
        git commit -m "first commit"
        git remote add origin 你创建的github项目地址
        git push -u origin master
        ```
    - 提交成功后，到 github 上刷新，看一下效果
    - 如果使用 http 的 git 地址，如果嫌每次输入用户名密码麻烦的化，使用如果命令可以记住密码
        ```
        git config --global credential.helper store
        ```
    - 修改一下 README.md，然后提交一下
        ```
        git status
        git add .
        git commit -m "本修改说明"
        git push
        ```
        `git add .` 是添加所以的变更，如果单独添加某个文件可以使用 `git add 单个文件路径名称`
    - 到 github 项目页面上刷新一下，看一下效果

### 程序控制执行流程
#### 条件语句 if-else

条件语句：当某个条件成立时，执行一条或多条语句；如果条件不成立则执行另一条语句或另几条语句。主要有以下两种形式来使用：

```
// 单条语句
if (Boolean-Exception) 
    statement

// 单条或多条语句
if (Boolean-Exception) {
    statement1;
    statement2;
    ......
}
```

或者

```
// 单条语句
if (Boolean-Exception) 
    statement
else
    statement

// 单条或多条语句
if (Boolean-Exception) {
    statement1;
    statement2;
    ......
} else {
    statement1;
    statement2;
    ......
}
```

说明：statement 如果为单条语句可以不使用大括号括起来；如果是多条语句必须用大括号括起来，形成一个语法块。

下面我们来做一个示例：给定一个年龄，然后判断该年龄属于儿童、青年、中年还是老年；年龄使用 int 类型，只支持整数。年龄段的划分规则如下：

| 年龄····范围 | 描述 |
| ------------ | ---- |
| ·0 ~ 6岁     | 儿童 |
| 7 ~ 17岁     | 少年 |
| 18 ~ 40岁    | 青年 |
| 41 ~ 59岁    | 中年 |
| 60及以上     | 老年 |

#### 循环

循环语句，有时我们也叫迭代语句。语句会重复执行，直到起控制作用当布尔表达式（BooleanException）为假（false）。

Java 中有 while、do-while 和 for 三类循环控制。

- while

  ```
  while (Boolean-Exception)
      statement
  ```

  当 `Boolean-Exception` 的结果为真（true）时，一直执行 `statement`，直到 `Boolean-Exception` 的结果为假（false）。

  练习：随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。生成 `0 ~ 1000` 范围的整数使用语句 `int r = new Random().nextInt(1000)`。

  ```
  boolean notContinue = true;
  while (notContinue) {
      int r = new Random().nextInt(1000);
      if (r % 30 == 0) {
          System.out.println("随机数：" + r + "能被30整除，不在执行循环");
          notContinue = false;
      } else {
          System.out.println("随机数：" + r);
      }
  }
  ```

- do-while

  ```
  do 
      statement
  while (Boolean-Exception)
  ```

  do-while 和 while 的区别是 do-while 语句至少会执行一次，当表达式 `Boolean-Exception` 为假（false）时，退出循环，不在执行下一次。

  练习：和 `while` 部分的练习一样，随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。

  ```
  boolean notContinue = true;
  do {
      int r = new Random().nextInt(1000);
      if (r % 30 == 0) {
          System.out.println("随机数：" + r + "能被30整除，不在执行循环");
          notContinue = false;
      } else {
          System.out.println("随机数：" + r);
      }
  } while (notContinue);
  ```

- for

  for 循环应该是一种总常用的循环，它的语法结构如下：

  ```
  for (initialization; Boolean-Exception; step)
      statement
  ```

  *执行过程*

  1. 执行初始化表达式 `initialization`。
  2. 执行布尔表达式 `Boolean-Exception`，如果结果为 false，退出循环；如果为 true，执行语法块 `statement`。
  3. `Boolean-Exception` = true 时，执行语法块 `statement`。
  4. 执行步进 `step` 运算。
     5。 跳转第 ii 步继续执行。

  *注意：* 初始化 `initialization`、布尔表达式 `Boolean-Exception` 和步进 `step` 都可以为空。

  练习：打印 `0 ~ 100` 范围内的单数并计算范围内单数的总个数。

  ```
  int total = 0;
  for (int i = 0; i <= 100; i++) {
      if (i % 2 != 0) {
          System.out.println("单数：" + i);
          total++;
      }
  }
  System.out.println("0 ~ 100之间的单数总个数是：" + total  + "个");
  ```

#### 多重选择 switch

当有多个选项时，如果使用 if-else 语法程序就会显得冗长笨拙，这时我们可以使用 switch 语句：

```
switch (integral-selector) {
    case integral-value1: statement; break;
    case integral-value2: statement; break;
    case integral-value3: statement; break;
    ......
    default: statement;
}
```

`Integral-selector`（整数选择因子）是一个能产生整数值的表达式。当产生的结果，和 case 后的值相等时，执行 case 后边的语句，直到 break 结束。

从 Java 5 开始，switch 可以使用枚举（Enum）；从 Java 7 开始，switch 可以使用字符串（String）这个放到后边相关章节来讲，这里只提一下。

练习：假如你有一个机器人，你通过输入数字指令来指挥机器人，比如输入 `1` 让机器人扫地，输入 `2` 让机器人打开灯。具体指令如下：

|数字指令    |执行命令
|----------|--------|
|1  |扫地
|2  |开灯
|3  |关灯
|4  |播放音乐
|5  |关闭音乐
|其他数字  |不能识别的指令

```
int cmdN = 1;
switch (cmdN) {
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
```

#### 中断流程控制语句

当一个循环执行中，如果想要退出循环或者不再执行后边的语句直接进行下一次循环。我们就需要用到中断流程控制语句，包括：`return`、`break`、`continue`。

- return 中断当前循环并直接返回
- break 跳出循环，继续执行该循环体后边的语句
- continue 不再执行本次循环后边还未执行的语句，跳转循环开始的地方进行下一次循环的执行

练习1：还是前边的练习，我们来改写一下。随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。

```
while (true) {
    int r = new Random().nextInt(1000);
    if (r % 30 == 0) {
        System.out.println("随机数：" + r + "能被30整除，不在执行循环");
        break;
    } else {
        System.out.println("随机数：" + r);
    }
}
```

练习2：编写一个方法 `int getMaxNumRem7(int n1, int n2)` 找出 `0 ~ n2` 范围内除以 n1 余 7 的最大的数，找到则返回该数，如果找不到则返回 -1。

```
int getMaxNumRem7(int n1, int n2) {
    for (int n = n2; n >= 0; n--) {
        if (n % n1 == 7) {
            return n;
        }
    }
    return -1;
}
```

练习3：找出 `0 ~ 100` 范围内能被7整除的数，并计算它们累计相加的结果。

```
int total = 0;
for (int n = 0; n < 100; n++) {
    if (n % 7 != 0) {
        continue;
    }
    total += n;
    System.out.println(n + "能被7整除，累计结果：" + total);
}
System.out.println("0 ~ 100范围内能被7整除的数累计相加结果：" + total);
```

### 扩展：使用 TDD 方式来写一下前边一个练习（尚未完成）

测试驱动开发（Test-Driven Development），简称 TDD。简单来说就是先写测试，再写实现。

题目：给定一个年龄，然后判断该年龄属于儿童、青年、中年还是老年；年龄使用 int 类型，只支持整数。
# 2019-12-12 课程

## 公告

今天我们学习 Java 开发中最常用的数组类型。

- 数组
  - 数组定义及声明
  - 数组初始化
  - 数组遍历
  - 数组拷贝
  - 数组填充
  - 数组排序
  - 多维数组和不规则数组
  - 应用练习
  - 常见面试问题
- 课后练习

## 数组

数组是一种数据结构，用来存放同一类型的值的集合。通过整数下标来访问数组中的值，数组下标从 `0` 开始；当下标越界，不在范围之内时，程序会报错 `java.lang.ArrayIndexOutOfBoundsException`。

数组是一种引用类型，只能用来存储固定大小的同类型数据。在 Java 中很多集合的内部都是使用数组来实现的，比如 ArrayList 和 HashMap 等。

数组的常用排序算法：冒泡算法、选择排序。

声明数组变量时，必须指明数组类型，类型后边紧跟 `[]` 或者将 `[]` 放在数组变量之后，数组类型可以是基本数据类型或者引用类型。例如：

```
int[] arr1;
int arr2[];
String[] arr3;
String arr4[];
```

### 数组初始化

数组有以下几种初始化方式：

1. `int[] arr1 = new int[3];` / `String[] arrS1 = new String[3];`

   使用 new 操作符创建的数组时，基本数据类型每个值会初始化为二进制的0；而引用类型会初始化为 null。

2. `int[] arr2 = new int[] {1, 2, 3};` / `String[] arrS2 = new String[]{"1", "2", "3"};`

   使用 new 操作符创建数组时，直接使用大括号方法赋值，数组的长度为大括号内元素的个数，不能在 [] 内指定长度，否则编译器会报错。

3. `int[] arr3 = { 1, 2, 3};` / `String[] arrS3 = {"1", "2", "3"};`

   使用第 2 种方式创建数组时，可以省略前边的 new 操作符而直接使用大括号。

### 数组遍历

Java 种对数组的遍历主要有以下三种方式：

1. for 循环使用数组下标
2. for each 循环
3. Java 8 中新增的 Lambda 表达式

示例：分别使用上述三种方式遍历数组 `Integer[] arr = {1, 2, 3, 4, 5};`

```
Integer[] arr = {1, 2, 3, 4, 5};

System.out.println("1. for循环使用数组下标");
for (int index = 0; index < arr.length; index++) {
    System.out.println(arr[index]);
}

System.out.println("2. for each循环");
for (int numb : arr) {
    System.out.println(numb);
}

System.out.println("3. Java 8新增的 Lambda 表达式");
Arrays.asList(arr).forEach(numb -> System.out.println(numb));
```

**特别说明：** 将 `Integer[] arr = {1, 2, 3, 4, 5};` 改为 `int[] arr = {1, 2, 3, 4, 5};`，然后再执行，看看使用 Java 8 新增的 Lambda 表达式方式时的输出结果有什么不一样。

### 数组拷贝

Java 中数组拷贝常用的两种方式：

1. 使用工具类 Arrays.copyOf 或 Arrays.copyOfRange
2. 使用底层方法 System.arraycopy

示例：

```
Integer[] arr1 = {1, 2, 3, 4, 5};
Integer[] arr2 = {6, 7, 8, 9, 10};

// 拷贝数组 arr1 的前 3 个元素
Integer[] arr3 = Arrays.copyOf(arr1, 3);
System.out.println(Arrays.toString(arr3));

// 拷贝数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
Integer[] arr4 = Arrays.copyOfRange(arr1, 1, 3);
System.out.println(Arrays.toString(arr4));

// 拷贝数组 arr2 的后 3 位到 arr1 到后 3 位
System.arraycopy(arr2, 2, arr1, 2, 3);
System.out.println(Arrays.toString(arr1));
```

### 数组填充

使用工具类提供的方法 `Arrays.fill` 可以对数组全部或指定范围内的元素赋值为指定的值。

示例：定义一个大小为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；然后将数组后 3 为赋值为 3，再次打印数组。

```
int arr[] = new int[10];
Arrays.fill(arr, 5);
System.out.println(Arrays.toString(arr));

Arrays.fill(arr, arr.length - 3, arr.length, 3);
System.out.println(Arrays.toString(arr));
```

### 数组排序

可以使用 Arrays.sort 方法对数组进行排序。

示例：定义一个大小为 100 的 int 数组，随机给每一位赋值一个 `0 ~ 100` 之间的数值，然后对该数组进行排序并打印排序结果。

```
int arr[] = new int[100];
for (int index = 0; index < arr.length; index++) {
    arr[index] = new Random().nextInt(100);
}
System.out.println("排序前：" + Arrays.toString(arr));
Arrays.sort(arr);
System.out.println("排序后：" + Arrays.toString(arr));
```

### 多维数组和不规则数组

前边介绍出现的数组，都是一维数组，Java 实际上没有多维数组，只有一维数组。多维数组可以被理解为“数组的数组”。多维数组的同一个维可以有不同的长度，因此也可以称为不规则数组。声明时使用多个 [] 标识来声明。

示例：定义一个二维数组，第一维表示用户，第二维表示用户的具体信息（1. 编码, 2. 姓名, 3.性别, 4.年龄）。定义赋值并打印。

```
String[][] users = new String[3][];
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
```

### 应用练习

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

    给定 nums = [2, 7, 11, 15], target = 9
    
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

来源：<https://leetcode-cn.com/problems/two-sum/>

解答代码：

```
public int[] twoSum(int[] nums, int target) {
    for (int start = 0; start < nums.length - 1; start++) {
        for (int secondNumStart = start + 1; secondNumStart < nums.length; secondNumStart++) {
            if (nums[start] + nums[secondNumStart] == target) {
                return new int[] {start, secondNumStart};
            }
        }
    }
    return null;
}
```

这个解答代码仅仅实现了功能，算法不是最优的，尝试进行优化。

### 常见面试问题

#### 下列代码的执行结果

```
int[] n = new int[3] {1, 2, 3};
System.out.println(n[1]);
```

解答：编译时报错，数组声明时如果使用大括号赋值，不能在 [] 内指定数组的长度，数组的长度为大括号内元素的个数。

#### 下列代码的执行结果

```
private static void plus1ForEvenIndex(int[] arr) {
    for (int index = 0; index < arr.length; index++) {
        if ((index + 1) % 2 == 0) {
            arr[index] = arr[index] + 1;
        }
    }
}

public static void main(String[] args) {
    int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    plus1ForEvenIndex(n);
    System.out.println(Arrays.toString(n));
}
```

执行结果：[1, 3, 3, 5, 5, 7, 7, 9, 9, 11]。Java 方法参数是值传递，方法得到是参数的拷贝，所以方法内代码不会改变所传参数的值。但对于引用类型，虽然不能改变引用类型的引用，却可以修改引用类型指向的对象的值。

#### 下列代码的执行结果

```
int[] n = new int[3];
String[] s = new String[3];
System.out.println(n[1]);
System.out.println(s[1]);
```

执行结果：0 和 null。数组声明时未进行赋值时，对于基本数据类型，将每一个元素赋值为二进制0；而对于引用类型，则将每一个元素赋值为 null。

#### 数组的遍历方式有哪些

- for 循环使用数组下标
- for each 循环
- Java 8 新增的 Lambda 表达式

#### 举例说明 Arrays 工具类的常用方法

- copyOf
- copyOfRange
- fill
- sort
- toString
- equals
- asList
- binarySearch

每个方法的作用，以及用法大家自己来补充。

## 课后练习

1. 自己编写练习一下课程中的示例和练习。

2. 编写一个数组排序方法，具体要求如下：

   - 在项目 java-common-tools 中创建数组工具类 com.zeroten.common.util.ArrayUtils。（src/main/java目录下）

   - 为数组工具类编写如下排序方法（使用静态方法）：

     - public static int[] sort(int[] arr)

       对传入的 int 数组进行排序，从小到大，并返回排序后的结果。

   - 将作业提交 GitHub 并写清楚提交说明。

