package tiktok.entities;

import java.util.List;

public class Idol extends BaseEntity{
    private static int autoId;
    private String email;
    private List<Follower> followers;
    private String group;

    public Idol(String name, String email, List<Follower> followers, String group) {
        super(name, ++autoId);
        this.email = email;
        this.followers = followers;
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "name='" + getName() + '\'' +
                "id='" + getId() + '\'' +
                "email='" + email + '\'' +
                ", followers=" + followers +
                ", group='" + group + '\'' +
                '}';
    }
}
