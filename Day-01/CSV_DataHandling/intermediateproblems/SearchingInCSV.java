package intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchingInCSV {
    public static void main(String[] args) throws IOException {
        String file="C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\intermediateproblems\\employee.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean found=false;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[1].trim().equalsIgnoreCase("Sandeep")) {
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + columns[2].trim());
                    System.out.println("Salary: " + columns[3].trim());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found!");
            }
            }
         catch (IOException e) {
            e.printStackTrace();
        }




    }
}
