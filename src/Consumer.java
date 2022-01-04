
// -----------------------------------------------------
// Assignment 1
// Question: Part 1 
//Written by: Reuven Ostrofsky - 40188881
//Due Date: October 3rd, 2021
// -----------------------------------------------------

//JavaDoc

/**
 * Name/ID: Reuven Ostrofsky - 40188881
 * COMP249
 * Assignment #1
 * Due Date: 02/10/2021
 *
 */

 /**
  * Import scanner class to prompt user
  */
import java.util.Scanner;

/** 
 * The consumer class holds all attributes and information a consumer of a company has. 
 * @author Reuven Ostrofsky
 * @version 1.0
 */

public class Consumer { 
	/**
	 * Holds the variable for which the user can input.
	 */
	static Scanner input = new Scanner(System.in);
	/**
	 * String that holds consumer's name.
	 */
	private String name; 
	/**
	 *
	 * integer that holds consumer's street number.
	 */
	private int streetNum; 
	/**
	 * String that holds consumer's street name.
	 */
	private String streetName; 
	/**
	 * String that holds consumer's city name.
	 */
	private String city; //Consumer's city
	/**
	 * String that holds consumer's postal code.
	 */
	private String postalCode; //Consumer's postal code
	/**
	 * Integer that holds consumer's age.
	 */
	private int age; //Consumer's age
	/**
	 * String that holds consumer's gender.
	 */
	private String gender; //Consumer's gender
	
	
	/**
	 * 
	 * @author reuvenostrofsky
	 * enumerated object of type marital status holding all its constants.
	 */
	private enum maritalStatus{
		/**
		 * Not in a relationship at the moment
		 */
		SINGLE,
		/**
		 * Currently in a relationship with another
		 */
		RELASHIONSHIP,
		/**
		 * Legally married with another
		 */
		MARRIED,
		/**
		 * Lost a married one from death
		 */
		WIDOWED; 
		};
		/**
		 * Variable of type maritalStatus that holds consumer's current marital status.
		 */
		private maritalStatus currentStatus; 
		
		/**
		 * 
		 * @author reuvenostrofsky
		 * enumerated object of type education holding all its constants.
		 */
	public enum education{
		/**
		 * Currently aiming to receive high school diploma
		 */
		HIGHSCHOOL,
		/**
		 * Currently aiming to receive DEC
		 */
		CEGEP,
		/**
		 * Currently aiming to receive a bachelor or a masters
		 */
		UNIVERSITY;
		
		};
		/**
		 * Variable of type education that holds consumers current education status.
		 */
		public education eduType; //Consumer's education status
		
		/**
		 * Integer that keeps count of all created consumers
		 */
	private static int numConsumers; //Keeps count of consumer amount
	
	//Constructors
	/**
	 * 
	 * @param name Holds the consumer's name.
	 * @param streetNum Holds the consumer's street number.
	 * @param streetName Holds the consumer's street Name.
	 * @param city Holds the consumer's city name.
	 * @param postalCode Holds the consumer's postal code.
	 * @param age Holds the consumer's age.
	 * @param gender Holds the consumer's gender.
	 * @param status Holds the consumer's marital status.
	 * @param eduType Holds the consumr's current education type.
	 */
	Consumer(String name, int streetNum, String streetName, String city, String postalCode,int age, String gender, maritalStatus status, education eduType){
		this.name = name;
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.age = age;
		this.gender = gender;
		this.currentStatus = status;
		this.eduType = eduType;
		numConsumers++;
	}
	
	/**
	 * 
	 * @param age Holds the consumer's age.
	 * @param gender  Holds the consumer's gender.
	 * @param eduType  Holds the consumr's current education type.
	 */
	
	Consumer(int age, String gender, education eduType) {
		this.age =age;
		this.gender = gender;
		this.eduType = eduType;
	}
	
	/**
	 * Default Constructor
	 */

	Consumer() {

	}

	/**
	 * Copy construcotr made to create a new consumer object with the same attributes as another consumer.
	 * @param c Object of type Consumer of which the constructor created will take all atrributes.
	 */
	
	Consumer(Consumer c){
		this.name = c.name;
		this.streetNum = c.streetNum;
		this.streetName = c.streetName;
		this.city = c.city;
		this.postalCode = c.postalCode;
		this.age = c.age;
		this.gender = c.gender;
		this.currentStatus = c.currentStatus;
		this.eduType = c.eduType;
		numConsumers++;
	}
	
	//Mutators
	/**
	 * Getter method that accesses consumer's name
	 * @return A string that returns consumer's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter method that sets a name to the consumer.
	 * @param name String that sets name to consumer.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter method that accesses consumer's street number
	 * @return An integer that returns consumer's street number
	 */
	public int getStreetNum() {
		return streetNum;
	}
	/**
	 * Setter method that sets a street number to consumer
	 * @param streetNum Integer that sets a street number to consumer
	 */
	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}
	/**
	 * Getter method that accesses consumer's street name.
	 * @return A string that returns consumer's street name
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * Setter method that sets a street name to consumer
	 * @param streetName String thats sets the street name to consumer
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	/**
	 * Getter method that accesses consumer's city name
	 * @return a string that returns consumer's city name
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Setter method that sets city name to consumer
	 * @param city String that  sets the city name to consumer
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Getter method that accesses consumer's postal code
	 * @return a string that returns consumer's postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * Setter method that sets postal code to consumer
	 * @param postalCode String that sets the postal code to consumer
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * Getter method that accesses consumer's age
	 * @return An integer that returns consumer's age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Setter method that sets age to consumer
	 * @param age Integer that sets the age to consumer
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Getter method that accesses consumer's gender
	 * @return A string that returns consumer's gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Setter method that sets gender to consumer
	 * @param gender String that sets gender to consumer
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * Getter method that accesses consumer's marital status 
	 * @return A variable of type maritalStatus thats returns the current marital status of consumer
	 */
	public maritalStatus getCurrentStatus() {
		return currentStatus;
	}
	/**
	 * Setter method that sets marital status to consumer 
	 * @param status Predetermined string that sets marital status to consumer
	 * Uses .valueOf method to convert string to enumerated variable
	 */
	public void setMaritalStatus(String status) {
		this.currentStatus = maritalStatus.valueOf(status.toUpperCase());
	}
	/**
	 * Getter method that accesses consumer's current education
	 * @return A variable of type education thats returns the current education status of consumer
	 */
	public education getEduType() {
		return eduType;
	}
	/**
	 * Setter method that sets education status to consumer
	 * @param edu Predetermined string that sets education status to consumer
	 */
	public void setEduType(String edu) {
		this.eduType = education.valueOf(edu.toUpperCase());
	}
	
	
	//Methods
	
	/**
	 * Overloaded string method that prints out all details of the consumer
	 * @return String with all consumer's attributes
	 */
	public String toString() {
		return "Name:" + name + "\nLoaction: " + streetNum + " " + streetName + ", " + city + ", " + postalCode + "\nAge: " + age + "\nGender: " + gender + "\nMarital status: " + currentStatus +"\nEducation: " + eduType;
	}
	//Accessor method for static variable numConsumers
	/**
	 * Static getter method that returns the number of consumer created
	 * @return An integer that returns the total number of consumers created
	 */
	public static int getNumberOfConsumers() {
		return numConsumers;
	}
	
	/**
	 * Method that checks if a consumer has the same age, gender and education status as another consumer
	 * @param a Consumer type object
	 * @return	Boolean value returning if all attributes in the method are the same
	 */
	public boolean equals(Consumer a) {
		return age == a.age && gender == a.gender && eduType == a.eduType;
	}
	/**
	 * Static void method that displays all marital status options
	 */
	private static void displayMaritalOptions() {
		maritalStatus[] status = maritalStatus.values();
		for (int i = 0; i < status.length;i++) {
			System.out.println("\n\t" + (i+1) + ". " + status[i]);
		}
	}
	/**
	 * Static void method that displays all education status options
	 */
	public static void displayEducationOptions() {
		education eduType[] = education.values();
		for (int i = 0; i < eduType.length;i++) {
			System.out.println("\n\t" + (i+1) + ". " + eduType[i]);
		}
	}
	/**
	 * Void method that prompts user to input marital status.
	 * Implements displayMaritalOptions method
	 */
	public void inputMaritalStatus() {
		displayMaritalOptions();
		System.out.print("Enter choice here ->");
		int choice = input.nextInt();
		switch(choice) {
		case 1: setMaritalStatus("SINGLE");
		break;
		case 2: setMaritalStatus("RELASHIONSHIP");
		break;
		case 3: setMaritalStatus("MARRIED");
		break;
		case 4: setMaritalStatus("WIDOWED");
		break;
		}
		
	}
	
	
	
	
	/**
	 * Void method that prompts user to input consumer's current education status.
	 * Implements displayEducationOptions method.
	 */
	public void inputEduType() {
		displayEducationOptions();
		System.out.print("Enter choice here ->");
		int choice = input.nextInt();
		switch(choice) {
		case 1: setEduType("HIGHSCHOOL");
		break;
		case 2: setEduType("CEGEP");
		break;
		case 3: setEduType("UNIVERSITY");
		break;
		
	}
	}
	/**
	 * Static void method that searches consumers with the same following inputed parameters; age, gender, education type
	 * @param c Array of type consumer
	 * @param age inputed integer value holding the age wanted to be found in a consumers array
	 * @param gender inputed String value holding the gender wanted to be found in a consumers array
	 * @param e Variable of type education holding the education type wanted to be found in a consumers array
	 */
	public static void findConsumerBy(Consumer c[],int age, String gender, education e) {
		for (int i = 0; i < numConsumers ;i++) {
			if (c[i].getAge() == age && c[i].getGender().equalsIgnoreCase(gender) && c[i].getEduType() == e){
				System.out.println("Consumer #" + (i+1) + " has the given parameters:");
				System.out.println(c[i] + "\n");
			}
		}
	}
	/**
	 * Static void method that searches consumers with the same following inputed parameters; age, Postal code
	 * @param c Array of type consumer
	 * @param age inputed integer value holding the age wanted to be found in a consumers array
	 * @param postalCode inputed String value holding the age wanted to be found in a consumers array
	 */
	public static void findConsumerByAgeNPostalCode(Consumer c[],int age, String postalCode) {
		for (int i = 0; i < numConsumers ;i++) {
			if (c[i].getAge() == age && c[i].getPostalCode().equalsIgnoreCase(postalCode)){
				System.out.println("Consumer #" + (i+1) + " has the given parameters:");
				System.out.println(c[i] + "\n");
			}
		}
	}

	
		
	

	
	
}
	
	
	
	
	
