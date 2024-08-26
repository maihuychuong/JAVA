package techmasterstudent;

public abstract class TechMasterStudent{
    public String fullName;
    public String fieldOfStudy;
    public abstract double getScore();
    public String classify(){
        if(getScore() < 5){
            return "Yếu";
        } else if (getScore() >= 5 && getScore() < 6.5) {
            return "Trung bình";
        } else if (getScore() >= 6.5 && getScore() < 7.5) {
            return "Khá";
        } else return "Giỏi";
    }

    public void print() {
        System.out.println("Tên: "+ this.fullName +"\n Ngành: "+ this.fieldOfStudy +"\n Điểm: "+getScore()+"\n Học lực: "+classify());
    }
}
