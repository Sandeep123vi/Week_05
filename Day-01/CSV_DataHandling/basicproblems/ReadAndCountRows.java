package basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRows {
    public static void main(String[] args) {
        String file="C:\\Users\\HP\\Desktop\\Week_5\\Day-01\\CSV_DataHandling\\basicproblems\\countrows.txt";


            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                br.readLine();
                int count=0;
                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(",");
                    System.out.println("ID: " + columns[0] + ", Name- " + columns[1]+"Age: " + columns[2] + ", Marks- " + columns[3] );
                    count++;
                }
                System.out.println();
                System.out.println("Number of Records are:"+ count);
            }

        catch (IOException e) {
            e.printStackTrace();
        }    }

}
