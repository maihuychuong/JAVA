package summonrift.entities;

import java.util.List;

public class Team {
    private List<Figure> figures;
    private String matchStartTime;

    public Team(List<Figure> figures, String matchStartTime) {
        this.figures = figures;
        this.matchStartTime = matchStartTime;
    }


    public List<Figure> getFigures() {
        return figures;
    }

    public void setFigures(List<Figure> figures) {
        this.figures = figures;
    }

    public String getMatchStartTime() {
        return matchStartTime;
    }

    public void setMatchStartTime(String matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    @Override
    public String toString() {
        return "Team{" +
                ", figures=" + figures +
                ", matchStartTime='" + matchStartTime + '\'' +
                '}';
    }
}
