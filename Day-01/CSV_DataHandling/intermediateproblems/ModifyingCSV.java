package intermediateproblems;

import java.io.*;
import java.io.*;

public class ModifyingCSV {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\intermediateproblems\\employee.csv";
        String outputFile = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\intermediateproblems\\outputFile.csv";

        modifyCSV(inputFile, outputFile);
    }

    public static void modifyCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isHeader) {
                    bw.write(line);
                    isHeader = false;
                } else {
                    String name = data[0].trim();
                    String department = data[1].trim();
                    double salary = Double.parseDouble(data[2].trim());
                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10;
                    }

                    bw.write( name + "," + department + "," + String.format("%.2f", salary));
                }
            }

            System.out.println("Updated CSV file : " + outputFile);

        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }
}
