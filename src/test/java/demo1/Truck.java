package demo1;

public class Truck extends Car implements Container{
    private int weight;
    public Truck(String name,String color,int weight){
        super(name,color);
        this.weight=weight;
    }
    @Override
    public String seatNum() {
        return "2座";
    }

    @Override
    public int getweight() {
        return this.weight;
    }
}
