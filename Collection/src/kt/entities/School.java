package kt.entities;

import java.util.List;

public class School {
    private List<Classroom> classrooms;
    private String major;
    private String semester;

    public School(List<Classroom> classrooms, String major, String semester) {
        this.classrooms = classrooms;
        this.major = major;
        this.semester = semester;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
