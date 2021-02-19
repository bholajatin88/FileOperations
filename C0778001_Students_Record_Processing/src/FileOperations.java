import java.io.*;
import java.util.*;

public class FileOperations {
    public static void main(String args[]) {
        String fileName = System.getProperty("user.dir") + "\\students.txt";
        readFileAndPerformOperations(fileName);
    }

    public static void readFileAndPerformOperations(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scnr = new Scanner(file);
            PrintWriter female_writer = new PrintWriter("female_Students.txt");
            PrintWriter male_writer = new PrintWriter("male_Students.txt");
            PrintWriter email_writer = new PrintWriter("students_email.txt");
            scnr.nextLine();
            while(scnr.hasNextLine()) {
                String line = scnr.nextLine();
                email_writer.write(line.split("\t")[3]+ "\n");
                if(line.split("\t")[4].equals("Female")) {
                    female_writer.write(line+ "\n");
                }
                else if(line.split("\t")[4].equals("Male")) {
                    male_writer.write(line + "\n");
                }
            }
            female_writer.close();
            male_writer.close();
            email_writer.close();

            System.out.println("Files created successfully.");
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File does not exist. Message: " + ex.getMessage());
        }

    }
}
