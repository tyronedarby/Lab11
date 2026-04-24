import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * File: Lab11Prob03.java
 * Class: CSCI 1302
 * Author: Lawson Cahill & Tyrone Darby
 * Created on: April 24, 2026
 * Description: Reads binary data, populates an ArrayList of Person objects,
 * sorts them, and serializes the objects to people-salary-sorted-objects.dat.
 */
public class Lab11Prob03 {
    public static void main(String[] args) {
        // Requirements: No package, File objects at "src/filename"
        File inputFile = new File("src/people.dat");
        
        // New output file for Problem 3
        File outputFile = new File("src/people-salary-sorted-objects.dat"); // [cite: 94]
        
        ArrayList<Person> people = new ArrayList<>();

        // Phase 1: Read binary data and populate ArrayList (Same as Prob 2)
        try (DataInputStream input = new DataInputStream(new FileInputStream(inputFile))) {
            while (true) {
                int age = input.readInt();
                String name = input.readUTF();
                String address = input.readUTF();
                int zip = input.readInt();
                double salary = input.readDouble();

                people.add(new Person(age, name, address, zip, salary));
            }
        } catch (EOFException e) {
            // Reached end of file normally
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Phase 2: Sort the list
        Collections.sort(people);

        // Phase 3: Write the actual Person OBJECTS to the new file
        // Using ObjectOutputStream instead of DataOutputStream
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            
            // Iterate through the ArrayList and write each Person instance
            for (Person p : people) {
                output.writeObject(p); // [cite: 94]
            }
            
            System.out.println("Objects successfully serialized to " + outputFile.getName());
            
        } catch (IOException e) {
            System.err.println("Error writing object file: " + e.getMessage());
        }
    }
}