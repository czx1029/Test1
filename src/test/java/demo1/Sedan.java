package demo1;

public class Sedan extends Car {
    public Sedan(String name, String color) {
        super(name, color);
    }

    @Override
    public String seatNum() {
        return "4座";
    }
}
