package summonrift.entities;

import java.util.List;

public class SummonRift {
    private List<Team> skt;
    private List<Team> g2;

    public SummonRift(List<Team> skt, List<Team> g2) {
        this.skt = skt;
        this.g2 = g2;
    }

    public List<Team> getSkt() {
        return skt;
    }

    public void setSkt(List<Team> skt) {
        this.skt = skt;
    }

    public List<Team> getG2() {
        return g2;
    }

    public void setG2(List<Team> g2) {
        this.g2 = g2;
    }

    @Override
    public String toString() {
        return "SummonRift{" +
                "skt=" + skt +
                ", g2=" + g2 +
                '}';
    }
}
