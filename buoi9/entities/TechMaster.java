package extend_lesson.buoi9.entities;

public class TechMaster {
    private String manager;
    private String teacher;
    private Classroom classroom;

    public TechMaster(String manager, String teacher, Classroom classroom) {
        this.manager = manager;
        this.teacher = teacher;
        this.classroom = classroom;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "TechMaster{" +
                "manager='" + manager + '\'' +
                ", teacher='" + teacher + '\'' +
                ", classroom=" + classroom +
                '}';
    }
}
