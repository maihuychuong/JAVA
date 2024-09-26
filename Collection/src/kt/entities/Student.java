package kt.entities;

public class Student {
    private String name;
    private String dateOfBrith;
    private String address;

    public Student(String name, String dateOfBrith, String address) {
        this.name = name;
        this.dateOfBrith = dateOfBrith;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
