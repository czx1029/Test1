package demo1;

public class Bus extends Car {
    public Bus(String name, String color) {
        super(name, color);
    }

    @Override
    public String seatNum() {
        return "53座";
    }
}
