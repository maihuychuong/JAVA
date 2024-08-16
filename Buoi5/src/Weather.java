public class Weather {
    private Season season;

    public Weather(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "season=" + season +
                '}';
    }
}
