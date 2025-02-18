package advancedproblems;

import java.io.*;
import java.util.regex.*;

public class CSVValidation {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\advancedproblems\\employees.csv";
        validateCSV(inputFile);
    }

    public static void validateCSV(String inputFile) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isHeader = true;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;

                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Invalid data format at line " + lineNum + ": " + line);
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();
                String department = data[3].trim();

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email at line " + lineNum + ": " + email);
                }
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number at line " + lineNum + ": " + phone);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
