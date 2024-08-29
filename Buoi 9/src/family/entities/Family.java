package family.entities;

public class Family {
    private static int autoId;
    private int id;
    private String houseNumber;

    public Family(String houseNumber) {
        this.id = ++autoId;
        this.houseNumber = houseNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
