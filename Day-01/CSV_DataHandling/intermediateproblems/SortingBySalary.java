package intermediateproblems;

import java.io.*;
import java.util.*;

public class SortingBySalary {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\intermediateproblems\\employees.csv";
        sortAndPrintTopSalaries(inputFile);
    }

    public static void sortAndPrintTopSalaries(String inputFile) {
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;
            String header = br.readLine(); // Read the header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employeeData.add(data);
            }

            // Sort the list based on salary (index 2) in descending order
            employeeData.sort((a, b) -> Double.compare(Double.parseDouble(b[2].trim()), Double.parseDouble(a[2].trim())));

            // Print the top 5 highest-paid employees
            System.out.println(header);
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                System.out.println(String.join(",", employeeData.get(i)));
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

