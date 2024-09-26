package library.entities;

public class Reader {
    private static int autoId;
    private int id;
    private String name;
    private int phoneNumber;
    private String adress;

    public Reader(String name, int phoneNumber, String adress) {
        this.id = ++autoId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Reader.autoId = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", adress='" + adress + '\'' +
                '}';
    }
}
