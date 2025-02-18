package basicproblems;


import java.io.*;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\basicproblems\\writecsv.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Sandeep,Finance,62000\n");
            writer.write("105,Sanket,Sales,58000\n");
            writer.write("104,Sachin,Finance,42000\n");
            writer.write("105,Sany,Sales,50000\n");
            System.out.println("CSV file written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

