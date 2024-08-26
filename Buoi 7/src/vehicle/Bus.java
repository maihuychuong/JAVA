package vehicle;

public class Bus extends Publicvehicle{

    private static final double SPEED_BUS = 20;
    private double distance;
    @Override
    public double time() {
        return distance/SPEED_BUS;
    }

    public Bus(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "time=" + time() +
                '}';
    }
}
