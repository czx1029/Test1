package test;

import org.testng.annotations.Test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        //初始化用户名
        String[] nameArray = {"张三","李四","王五","小明"};
        //初始化用户年龄
        int[] ageArray = {22,23,20,22};
        //初始化用户状态
        String[] stateArray = {"正常","正常","正常","正常"};
        Scanner scanner = new Scanner(System.in);
        int num;
        String name;
        int age;
        int index = 0;
        boolean flag;
        do {
            System.out.println("欢迎使用用户管理系统");
            System.out.println("1.查询用户");
            System.out.println("2.添加用户");
            System.out.println("3.删除用户");
            System.out.println("4.账号冻结");
            System.out.println("5.账号解封");
            System.out.println("6.退出系统");
            System.out.print("请选择：");
            num = scanner.nextInt();
            switch(num) {
                case 1:
                    System.out.println("------ 查询用户 ------");
                    System.out.println("编号\t\t姓名\t\t年龄\t\t状态\t\t");
                    for(int i=0;i<nameArray.length;i++) {
                        System.out.println((i+1)+"\t\t"+nameArray[i]+"\t\t"+ageArray[1]+"\t\t"+stateArray[i]);
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("------ 添加用户 ------");
                    System.out.print("请输入用户姓名：");
                    name = scanner.next();
                    flag = isNameExist(name, nameArray);
                    if(flag == true) {
                        System.out.println(name+"已存在！");
                    }else {
                        System.out.print("请输入用户年龄：");
                        age = scanner.nextInt();
                        nameArray = Arrays.copyOf(nameArray, nameArray.length+1);
                        nameArray[nameArray.length-1] = name;
                        ageArray = Arrays.copyOf(ageArray, ageArray.length+1);
                        ageArray[ageArray.length-1] = age;
                        stateArray = Arrays.copyOf(stateArray, stateArray.length+1);
                        stateArray[stateArray.length-1] = "正常";
                        System.out.println("添加成功！");
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("------ 删除用户 ------");
                    System.out.print("请输入要删除的用户名：");
                    name = scanner.next();
                    flag = isNameExist(name, nameArray);
                    if(flag != true) {
                        System.out.println(name+"不存在，请重新输入！");
                    }else {
                        index = getIndex(name, nameArray);
                        String[] newNameArray = new String[nameArray.length-1];
                        int[] newAgeArray = new int[ageArray.length-1];
                        String[] newStateArray = new String[stateArray.length-1];
                        for(int i=0;i<index;i++) {
                            newNameArray[i] = nameArray[i];
                            newAgeArray[i] = ageArray[i];
                            newStateArray[i] = stateArray[i];
                        }
                        for(int i=index;i<newNameArray.length;i++) {
                            newNameArray[i] = nameArray[i+1];
                            newAgeArray[i] = ageArray[i+1];
                            newStateArray[i] = stateArray[i+1];
                        }
                        nameArray = newNameArray;
                        ageArray = newAgeArray;
                        stateArray = newStateArray;
                        System.out.println(name+"删除成功！");
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("------ 账号冻结 ------");
                    System.out.print("请输入要冻结的用户名：");
                    name = scanner.next();
                    flag = isNameExist(name, nameArray);
                    if(!flag) {
                        System.out.println(name+"不存在，请重新输入！");
                    }else {
                        index = getIndex(name, nameArray);
                        if(stateArray[index].equals("冻结")) {
                            System.out.println(name+"已冻结！");
                        }else {
                            stateArray[index] = "冻结";
                            System.out.println(name+"冻结成功！");
                        }
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("------ 账号解封 ------");
                    System.out.print("请输入要解封的用户名：");
                    name = scanner.next();
                    //判断name是否存在
                    flag = isNameExist(name, nameArray);
                    if(!flag) {
                        System.out.println(name+"不存在，请重新输入！");
                    }else {
                        index = getIndex(name, nameArray);
                        if(stateArray[index].equals("正常")) {
                            System.out.println(name+"状态正常！");
                        }else {
                            stateArray[index] = "正常";
                            System.out.println(name+"解封成功！");
                        }
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("感谢使用用户管理系统！");
                    break;
            }
        }while(num == 0);
    }

    //检测用户输入的名称是否存在
    public static boolean isNameExist(String name,String[] nameArray) {
        boolean flag = false;
        for(int i = 0; i < nameArray.length;i++) {
            if(name.equals(nameArray[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    //如果用户名存在，获取其下标
    public static int getIndex(String name,String[] nameArray) {
        int index = 0;
        for(int i = 0; i < nameArray.length;i++) {
            if(name.equals(nameArray[i])) {
                index = i;
                break;
            }
        }
        return index;
    }
}
