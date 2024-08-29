package tiktok.entities;

import java.util.List;

public class Idol {
    private static int autoIdolId;
    private String name;
    private int id;
    private String email;
    private List<Follower> followers;

    public Idol(String name, String email, List<Follower> followers) {
        this.name = name;
        this.id = ++autoIdolId;
        this.email = email;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
