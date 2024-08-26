package entities;

public abstract class TechmasterStudent {
    private String fullName;
    private String major;

    public TechmasterStudent(String fullName, String major) {
        this.fullName = fullName;
        this.major = major;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public abstract double getPoint();

    public String classify() {
        if (getPoint() < 5)
            return "Yếu";
        else if (5 <= getPoint() && getPoint() < 6.5) {
            return "TB";
        } else if (6.5 <= getPoint() && getPoint() < 8)
            return "Khá";
        else return "Giỏi";
    }

    public void print() {
        System.out.println("Name: " + fullName +
                ", Major: " + major +
                ", Point: " + getPoint() +
                ", Classify: " + classify());
    }
}
