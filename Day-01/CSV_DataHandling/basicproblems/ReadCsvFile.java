package basicproblems;
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCsvFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\basicproblems\\csv.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name- " + columns[1]+"Age: " + columns[2] + ", Marks- " + columns[3] );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
