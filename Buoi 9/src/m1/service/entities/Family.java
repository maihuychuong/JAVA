package m1.service.entities;

public class Family {
    private int id;
    private String name;
    private String dob;
    private String job;
    private static int autoid;

    public Family(String name, String dob, String job) {
        this.id = ++autoid;
        this.name = name;
        this.dob = dob;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}