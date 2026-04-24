import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * File: Person.java
 * Class: CSCI 1302
 * Author:
 * Created on: April 24, 2026
 * Description: Model class for Person data with sorting by salary.
 */
public class Person implements Comparable<Person>, Serializable {
    private int age;
    private String name;
    private String address;
    private int zipCode;
    private double salary;

    public Person() {}

    public Person(int age, String name, String address, int zipCode, double salary) {
    	setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
	
    }

    // Accessors and Mutators
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public int getZipCode() { return zipCode; }
    public void setZipCode(int zipCode) { this.zipCode = zipCode; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public int compareTo(Person other) {
        // Sort by salary in descending order [cite: 69]
        return Double.compare(other.salary, this.salary);
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return String.format("Age: %d\nName: %s\nAddress: %s\nZip Code: %d\nSalary: %s\n",
                age, name, address, zipCode, currencyFormat.format(salary));
    }
}