package family.entities;

public class Member extends Family{
    private String name;
    private String dob;
    private String job;

    public Member(String houseNumber, String name, String dob, String job) {
        super(houseNumber);
        this.name = name;
        this.dob = dob;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Member{" +
                ", id='" +  '\'' +
                ", dob='" + dob + '\'' +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
