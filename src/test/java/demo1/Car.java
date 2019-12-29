package demo1;

public abstract class Car {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public abstract String seatNum();

    public Car(String name, String color) {
        super();
        this.name = name;
        this.color = color;
    }
}
