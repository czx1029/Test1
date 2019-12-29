package demo1;

import java.util.Scanner;

public class Test {
    private static Scanner scanner;
    private static Bus bus;
    private static Sedan sedan;
    private static Truck truck;
    private static Car[] cars;
    static {
        scanner=new Scanner(System.in);
        sedan = new Sedan("小轿车","黑色");
        bus = new Bus("大巴车","绿色");
        truck = new Truck("卡车","蓝色",2);
        cars = new Car[3];
        cars[0] = sedan;
        cars[1] = bus;
        cars[2] = truck;
    }

    public void showCars(){
        System.out.println("车辆名称\t\t车辆颜色\t\t座位数\t\t载重量");
        Car car=null;
        for (int i=0;i<cars.length;i++){
            car=cars[i];
            if(car instanceof Sedan){
                Sedan sedan = (Sedan)car;
                System.out.println(sedan.getName()+"\t\t"+sedan.getColor()+"\t\t"+sedan.seatNum());
            }
            if(car instanceof Bus) {
                Bus bus = (Bus)car;
                System.out.println(bus.getName()+"\t\t"+bus.getColor()+"\t\t"+bus.seatNum());
            }
            if(car instanceof Truck) {
                Truck truck = (Truck)car;
                System.out.println(truck.getName()+"\t\t"+truck.getColor()+"\t\t"+truck.seatNum()+"\t\t"+truck.getweight()+"吨");
            }
        }
        System.out.println("1.小轿车\t2.大巴车\t3.卡车");
        System.out.print("请选择要修改的车辆：");
        int num = scanner.nextInt();
        switch(num) {
            case 1:
                update("sedan");
                break;
            case 2:
                update("bus");
                break;
            case 3:
                update("truck");
                break;
        }
    }
    public void update(String type) {
        String name = null;
        String color = null;
        System.out.print("请输入车辆名称：");
        name = scanner.next();
        System.out.print("请输入车辆颜色：");
        color = scanner.next();
        //小轿车
        if(type.equals("sedan")) {
            Sedan sedan = new Sedan(name,color);
            cars[0] = sedan;
        }
        if(type.equals("bus")) {
            Bus bus = new Bus(name,color);
            cars[1] = bus;
        }
        if(type.equals("truck")) {
            System.out.print("请输入载重量：");
            int weight = scanner.nextInt();
            if(weight > 20) {
                try {
                    throw new CarException("卡车载重量不能超过20吨");
                } catch (CarException e) {
                    e.printStackTrace();
                    return;
                }
            }
            Truck truck = new Truck(name,color,weight);
            cars[2] = truck;
        }
        showCars();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.showCars();
    }
}
