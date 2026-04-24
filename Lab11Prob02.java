//package lab11;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public abstract class Lab11Prob02 implements Comparable<E>{

	class Person{
		private int age;
		private String name;
		private String address;
		private int zip;
		private double salary;
		
		
		
		public Person(int age, String name, String address, int zip, double salary) {
			setAge(age);
			setName(name);
			setAddress(address);
			setZip(zip);
			setSalary(salary);
		
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getZip() {
			return zip;
		}
		public void setZip(int zip) {
			this.zip = zip;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		@Override
		public String toString(){
			String tostr = String.format("%d %s %s %d .2,%f%n", getAge(), getName(), getAddress(), getZip(), getSalary());
			return tostr;
		}
		
	}
	
	
	
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
	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
