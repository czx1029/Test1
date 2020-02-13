package iotest;

import java.io.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws IOException {
        int num;
        String path;
        Scanner scanner =new Scanner(System.in);

        do {
            System.out.println("欢迎使用文件管理系统");
            System.out.println("1.浏览目录");
            System.out.println("2.文件目录");
            System.out.println("3.查看文件");
            System.out.println("4.创建文件");
            System.out.println("5.删除文件");
            System.out.println("6.写入文件");
            System.out.println("7.退出系统");
            System.out.print("请选择：");
            num = scanner.nextInt();
            switch(num) {
                case 1:
                    System.out.println("请输入文件路径: ");
                    for(File f:Files(File(scanner.next()))){					//遍历File[]数组
                        if(!f.isFile())		                            //若非文件(即目录)，则打印
                            System.out.println(f);
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("请输入文件路径: ");
                    for(File f:Files(File(scanner.next()))){					//遍历File[]数组
                        if(!f.isDirectory())		                    //若非目录(即文件)，则打印
                            System.out.println(f);
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("请输入文件路径: ");
                    File f=File(scanner.next());
                    long len1 = f.length();//读文件大小（单位字节）

                    InputStream input = new FileInputStream(f);
                    int len2 = input.available();//获取可读数据的大小（单位字节）
                    //数组的创建，必然要指定长度，java中默认int
                    byte[] bs = new byte[len2];//用于保存，读取的文件数据
                    input.read(bs);//输入流将直接写入内存地址（太粗暴，一次性，把所有数据都读进来）
                    String str = new String(bs);
                    System.out.println(str);
                    input.close();//关闭流
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("请输入文件路径: ");
                    File f1 =new File("D://IO","3.txt");
                    if(!f1.exists()){
                        boolean b = f1.createNewFile();//创建文件
                        System.out.println(b);
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("请输入文件路径: ");
                    File f2 =new File(scanner.next());
                    if(!f2.exists()){
                        boolean b = f2.delete();//删除文件
                        System.out.println(b);
                    }
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("请输入文件路径: ");
                    String string = "这是标题\r\n啊水电费会玩废物你覅我和方\r\n我IUE好开口问哦if回家你看；if哦好的";
                    OutputStream out = new FileOutputStream(scanner.next());
                    //第一步。获取字节
                    byte[] bytes = string.getBytes();
                    for(byte b : bytes){
                        out.write(b);
                    }
                    out.flush();//把缓冲器的数据推送到输出流里(看数据量)
                    out.close();
                    System.out.print("输入0返回：");
                    num = scanner.nextInt();
                    break;
                case 7:
                    System.out.println("感谢使用文件管理系统！");
                    break;
            }
        }while(num == 0);
    }

    public static File File(String path){
        File file = new File(path);		//获取其file对象
        return file;
    }


    public static File[] Files(File file){
        File[] fs = file.listFiles();   //遍历path下的文件和目录，放在File数组中
        return fs;
    }

}
