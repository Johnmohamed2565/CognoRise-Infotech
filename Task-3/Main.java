import java.util.Scanner;

public class Main {
    private static CourseDatabase courseDatabase = new CourseDatabase();
    private static StudentDatabase studentDatabase = new StudentDatabase();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adding sample courses
        courseDatabase.addCourse(new Course("CS101", "Introduction to Computer Science", "Learn the basics of computer science", 30, "MWF 10-11 AM"));
        courseDatabase.addCourse(new Course("MATH200", "Calculus I", "Introduction to calculus", 25, "TTh 9-10:30 AM"));

        while (true) {
            System.out.println("\n1. List Courses\n2. Register for Course\n3. Drop Course\n4. List Students\n5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    courseDatabase.listCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();

                    Student student = studentDatabase.getStudent(studentID);
                    if (student == null) {
                        student = new Student(studentID, name);
                        studentDatabase.addStudent(student);
                    }

                    Course course = courseDatabase.getCourse(courseCode);
                    if (course != null && course.getCapacity() > 0) {
                        student.registerCourse(course);
                        course.setCapacity(course.getCapacity() - 1);
                        System.out.println(name + " registered for " + course.getTitle());
                    } else {
                        System.out.println("Course not found or full.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();

                    student = studentDatabase.getStudent(studentID);
                    if (student != null) {
                        course = courseDatabase.getCourse(courseCode);
                        if (course != null && student.getRegisteredCourses().contains(course)) {
                            student.dropCourse(course);
                            course.setCapacity(course.getCapacity() + 1);
                            System.out.println(student.getName() + " dropped " + course.getTitle());
                        } else {
                            System.out.println("Course not registered or not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    studentDatabase.listStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
