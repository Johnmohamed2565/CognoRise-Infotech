import java.util.HashMap;
import java.util.Map;

public class StudentDatabase {
    private Map<String, Student> students;

    public StudentDatabase() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getStudentID(), student);
    }

    public Student getStudent(String studentID) {
        return students.get(studentID);
    }

    public void listStudents() {
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}
