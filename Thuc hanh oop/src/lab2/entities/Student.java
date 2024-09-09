package lab2.entities;

public class Student {
    private static int autoId;
    private int id;
    private String name;
    private double scoreMath;
    private double scorePhysic;
    private double scoreChemistry;

    public Student(String name, double scoreMath, double scorePhysic, double scoreChemistry) {
        this.id = ++autoId;
        this.name = name;
        this.scoreMath = scoreMath;
        this.scorePhysic = scorePhysic;
        this.scoreChemistry = scoreChemistry;
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

    public double getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(double scoreMath) {
        this.scoreMath = scoreMath;
    }

    public double getScorePhysic() {
        return scorePhysic;
    }

    public void setScorePhysic(double scorePhysic) {
        this.scorePhysic = scorePhysic;
    }

    public double getScoreChemistry() {
        return scoreChemistry;
    }

    public void setScoreChemistry(double scoreChemistry) {
        this.scoreChemistry = scoreChemistry;
    }

    public double avgScore(double scoreMath, double scorePhysic, double scoreChemistry){
        return (scoreMath + scoreChemistry + scorePhysic)/3;
    }
    public String classify(double scoreMath, double scorePhysic, double scoreChemistry){
        if(avgScore(scoreMath, scorePhysic, scoreChemistry) >=8){
            return "Xếp loại A";
        } else  if (avgScore(scoreMath, scorePhysic, scoreChemistry) < 8 && avgScore(scoreMath, scorePhysic, scoreChemistry) >= 6.5){
            return "Xếp loại B";
        } else if (avgScore(scoreMath, scorePhysic, scoreChemistry) < 6.5 ){
            return "Xếp loại C";
        }
        return null;
    }
    public int percentClassify(){
        return (0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scoreMath=" + scoreMath +
                ", scorePhysic=" + scorePhysic +
                ", scoreChemistry=" + scoreChemistry +
                ", avgScore=" + avgScore(scoreMath, scorePhysic, scoreChemistry) +
                ", classyfy=" + classify(scoreMath, scorePhysic, scoreChemistry) +
                '}';
    }
}
