package intermediateproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\intermediateproblems\\filtercsv.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[3].trim());
                if (marks > 80) {
                    System.out.println("ID: " + columns[0] + ", Name- " + columns[1]+"Age: " + columns[2] + ", Marks- " + columns[3] );

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
