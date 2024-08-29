package tiktok.entities;

public class Follower extends BaseEntity{
    private static int autoId;
    private String email;
    private int numberOfLike;

    public Follower(String name, String email, int numberOfLike) {
        super(name, ++autoId);
        this.email = email;
        this.numberOfLike = numberOfLike;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "name='" + getName() + '\'' +
                "id='" + getId() + '\'' +
                "email='" + email + '\'' +
                ", numberOfLike=" + numberOfLike +
                '}';
    }
}
