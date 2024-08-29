package tiktok.entities;

public class Song extends BaseEntity{
    private static int autoId;
    private String singer;

    public Song(String name, String singer) {
        super(name, ++autoId);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + getName() + '\'' +
                "id='" + getId() + '\'' +
                "singer='" + singer + '\'' +
                '}';
    }
}
