package vehicle;

public class Plane extends Publicvehicle{
    private static final double SPEED_PLANE = 80;
    private double distance;
    @Override
    public double time() {
        return distance/SPEED_PLANE;
    }

    public Plane(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "time=" + time() +
                '}';
    }
}
