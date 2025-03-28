import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    String fileName = "students.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      int lineNumber = 1;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(" ");
        if (parts.length == 4) {
          Student student = new Student(parts[0], parts[1], parts[2], parts[3]);
          students.add(student);
        }
        else {
          System.out.println("student information missing at line: " + lineNumber);
        }
        lineNumber++;
      }
    } catch (IOException e) {
        System.out.println("Error reading files: " + e.getMessage());
    }

    int count = 1;
    for (Student student : students) {
      System.out.println(count + ". student first name: " + student.getFirstName() +
                                    ", last name: " + student.getLastName() +
                                    ", ID: " + student.getID() +
                                    ", email: " + student.getEmail());
      count++;
    }
  }
}
