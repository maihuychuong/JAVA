public class Vehicle {
    private int speed;
    private String name;

    public Vehicle(int v, String name) {
        this.speed = v;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }
}
