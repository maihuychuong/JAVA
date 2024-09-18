package studentmanager.service;

import studentmanager.entities.Student;

public interface Iclassification {
    String classify(double marks);
    void display(Student student);
}
