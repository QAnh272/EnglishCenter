package EnglishCenter;

import java.util.ArrayList;

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
