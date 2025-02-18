package advancedproblems;

import java.io.*;
import java.util.*;

class Student {
    private String name;
    private int age;
    private String email;
    private String department;

    // Constructor
    public Student(String name, int age, String email, String department) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
    }

    // Override toString() for printing
    @Override
    public String toString() {
        return "Student{Name='" + name + "', Age=" + age + ", Email='" + email + "', Department='" + department + "'}";
    }
}

 class CSVToStudent {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\advancedproblems\\student.csv";
        List<Student> students = readCSV(inputFile);

        // Print all students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String inputFile) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                String name = data[0].trim();
                int age = Integer.parseInt(data[1].trim());
                String email = data[2].trim();
                String department = data[3].trim();

                // Create Student object and add to list
                students.add(new Student(name, age, email, department));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println( e.getMessage());
        }

        return students;
    }
}
