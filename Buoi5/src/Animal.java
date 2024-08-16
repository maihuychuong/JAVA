public class Animal {
    private String name;
    private boolean gender;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    //Hàm khởi tạo k có tham số
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
