package extend_lesson.buoi9.entities;

import java.util.List;

public class Classroom {
    private String subject;
    private List<Student> students;

    public Classroom(String subject, List<Student> students) {
        this.subject = subject;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "subject='" + subject + '\'' +
                ", students=" + students +
                '}';
    }
}
