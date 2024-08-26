package vehicle;

public class Train extends Publicvehicle{
    private static final double SPEED_TRAIN = 40;
    private double distance;

    @Override
    public double time() {
        return distance/SPEED_TRAIN;
    }

    public Train(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Train{" +
                "time=" + time() +
                '}';
    }
}
