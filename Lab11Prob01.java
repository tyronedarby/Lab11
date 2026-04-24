//package lab11;

import java.io.*;

public class Lab11Prob01 {
	
	public static void main(String[] args) {
		int age;
		String name;
		String address;
		int zip;
		double salary;
		try(
				//Input and output files
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));

				) {
			//infinite loop for writing until EOF
		while(true) {
			age = input.readInt();
			name = input.readUTF();
			address = input.readUTF();
			zip = input.readInt();
			salary = input.readDouble();
			
			System.out.printf("%d %s %s %d %.2f%n", age, name, address, zip, salary);

			output.writeInt(age);
			output.writeUTF(name);
			output.writeUTF(address);
			output.writeInt(zip);
			output.writeDouble(salary);
		}
		//EOF catch and any other catch
		}catch(EOFException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
