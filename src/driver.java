// -----------------------------------------------------
// Assignment 1
// Question: Part 2 
// Written by: Reuven Ostrofsky
// Due Date: October 3rd 2021
// -----------------------------------------------------

//Welcome to the driver
//This program has been crated by Reuven Ostrofsky
/* 
This program stores a company consumers, while keeping track of their name, age, gender, address, education and marital status. It also gives the
user the option to change any of the previous mentioned attributes.
*/
/**
 * Imports Scanner to prompt user
 */
import java.util.Scanner; //Import Scanner to prompt user
/**
 * 
 * @author reuvenostrofsky
 * @version 1.0
 */
public class driver {
	/**
	 * The driver class is the program itself. This program allows the user to create consumers of a company and input 
	 * the information needed. The user can also edit that information. These require the user to input the correct password before doing so.
	 * After multiple consumers have been added, the user also has access to search for any consumer with given inputted parameters 
	 * @param args No description - main method
	 */
	public static void main(String[] args) {
	//Display welcome message 
	System.out.println("--------------------------------\n\nWelcome to the consumer program\n\n\nMade by Reuven Ostrofsky\n\n--------------------------------\n");
	
	//-----Variables-----//
	int maxNumConsumers; //Holds number of consumers
	Scanner input = new Scanner(System.in); //Create Scanner object to prompt user
	final String correctPass = "password"; //Correct password to input
	String inputPass; //User's inputed password
	int choice; //User's inputed choice
	int passAttempts = 0; //Number of user's password attempts
	boolean programExit = false; //boolean checking if program should be running or to be terminated
	int consumerSpace; //number of space left for new consumers
	int amountEntered; //number of consumers user would like to add in option 1
	final int maxAttemptsO1 = 12; //Maximum password attempts for option 1
	final int maxAttemptsO2 = 3;
	int consumerIndex; //Index in consumer array
	String ans = null; //Yes or no input answer
	Consumer c = new Consumer(); //For option 3
	
	
	//Prompt user for maximum number of consumers
	System.out.print("What is the maximum number of consumers for the company?: ");
	maxNumConsumers = input.nextInt();
	consumerSpace = maxNumConsumers; //Initialize the amount left of new consumers to be created by maximum number of consumers
	//Set array with the size of maximum consumers
	Consumer consumerDatabase[] = new Consumer[maxNumConsumers];
	do {
		
		do {
			//Prompt user for his choice
			System.out.println("\nWhat do you want to do?");	
			System.out.println("\t1. Enter a new consumer(Password required)\n\t2. Change information of a Consumer (password required)\n\t3. Display all Consumers similar to a given consumer");
			System.out.println("\t4. Display all Consumers with given age and location\n\t5. Quit");
			System.out.print("Please enter your choice -> ");
			choice = input.nextInt();
			input.nextLine();
			}while(choice > 5 || choice < 0);//Re-do task as choice is invalid
		
			//Present cases//
			switch(choice) {
			case 1: // User wants to enter a new customer
			
			do {
				//Prompt User for password
				System.out.print("\nTo enter a new customer, please enter password: ");
	
				inputPass = input.nextLine();//Prompt user for password
	
				if (!correctPass.equalsIgnoreCase(inputPass) && passAttempts < maxAttemptsO1) {
					System.out.println("You entered \"" + inputPass + "\"");
					System.out.println("\nPassword incorrect...Try again.\n");//Display incorrect password message
					passAttempts++;//Increase password attempt by 1
					System.out.print("\nAttempts: " + passAttempts);//Display number of password attempts
					
				}
				 if (passAttempts == maxAttemptsO1){
					System.out.println("\nPassword incorrect."); //Do not ask user to enter password again
					programExit = true;//Terminate program
					System.out.println("\n\nProgram has detected suspicious activity and will terminate immediately!\n"); //Display that program has been terminated
					break;//End switch case after 12th password attempt
				}
			
			}while(!correctPass.equalsIgnoreCase(inputPass) && passAttempts%3 != 0);//Every number of attempt remainder 3 being 0, the program must retry or check if to be terminated

			//Display message when there is no more space for consumers to be added
			if (consumerSpace <= 0){
				System.out.println("Ther is no more space to add more consumers");
				
			}

			//Execute choice if password is correct
			if (inputPass.equalsIgnoreCase(correctPass) && consumerSpace > 0) {
	
				passAttempts = 0; //Reset consecutive attempts as password is correct

				
				
					
				do {
						//Prompt user to enter amount of new consumer
						System.out.print("\nHow many consumers would you like to enter: ");

						amountEntered = input.nextInt();
						input.nextLine();
						if (amountEntered > consumerSpace){//Display amount allowed to be inputed
							System.out.println("Not enough space for " + amountEntered + " consumers" );
							System.out.println("Maximum amount: " + maxNumConsumers + "\nSpace left: " + consumerSpace);
						}
						}while(amountEntered > consumerSpace);//Re-do task if input is invalid

							consumerSpace -= amountEntered;
				
						
							for(int i = 0; i < amountEntered;i++) {
								
									consumerDatabase[Consumer.getNumberOfConsumers()] = new Consumer(); //Create new consumer in array
									System.out.println("\nFor consumer #" + (Consumer.getNumberOfConsumers()+1)); //Display # of consumer
									System.out.print("Please enter the following: \nName:"); //Prompt for name
									String name = input.nextLine();
									consumerDatabase[Consumer.getNumberOfConsumers()].setName(name);
									System.out.print("Street number:"); //Prompt for steet number
									int streetNum = input.nextInt();
									input.nextLine();
									System.out.print("Street name:"); //Prompt for street name
									String streetName = input.nextLine();
									System.out.print("City:"); //Prompt for city
									String city = input.nextLine();
									System.out.print("Postal code:"); //Prompt for postal code
									String postalCode = input.nextLine();
									System.out.print("Age:"); //Prompt for age
									int age = input.nextInt();
									input.nextLine();
									System.out.print("Gender:"); //Prompt for gender
									String gender = input.nextLine();
									System.out.println("What is consumer's marital status?"); //Prompt for marital statud
									consumerDatabase[Consumer.getNumberOfConsumers()].inputMaritalStatus(); //Call method
									System.out.println("What is consumer's current education?");//Prompt user for education type
									consumerDatabase[Consumer.getNumberOfConsumers()].inputEduType(); //Call method

									//Create constructor using all variables as parameters
									consumerDatabase[Consumer.getNumberOfConsumers()] = new Consumer(name, streetNum,streetName,city,postalCode,age, gender,consumerDatabase[i].getCurrentStatus() , consumerDatabase[i].getEduType());
									
									
							}
						
							
						
					
					
			}
			
			break; //End switch case

			case 2://User wants to change consumer information
			passAttempts = 0; //Reset password attempts to 0
			do {

				System.out.print("\nTo changer consumer information, please enter password:");
				inputPass = input.nextLine();
				if (!correctPass.equalsIgnoreCase(inputPass) && passAttempts < maxAttemptsO2) {
					System.out.println("You entered \"" + inputPass + "\"");
					System.out.println("\nPassword incorrect...Try again.\n");//Display incorrect password message
					passAttempts++;//Increase password attempt by 1
					System.out.print("\nAttempts: " + passAttempts);//Display number of password attempts
				
				}
				if (passAttempts == 3){
					//Display terminate message
					System.out.println("\nProgram terminated due to safety reasons");
					programExit = true; //Exit program
					break;//Exit switch statement
				}
			}while(!inputPass.equalsIgnoreCase(correctPass)); //Keep rpompting user as password is incorrect

			//Execute if password is correct
			if(inputPass.equalsIgnoreCase(correctPass)){
				passAttempts = 0;
				do{
					System.out.println("\nWhich conusmer would you like to update?");
					consumerIndex = input.nextInt();
					input.nextLine();
					if (consumerDatabase[consumerIndex-1] == null){ //Checks if consumer object has been created
						System.out.println("There has not been a consumer created at index " + consumerIndex);
					}else {

						do {

							do {


								System.out.println("\nConsumer #" + consumerIndex); //Display consuer index
								System.out.println(consumerDatabase[consumerIndex -1]);//Display consumer content
								//Display choices
								System.out.println("\nWhat information would you like to change\n\t1. Consumer name\n\t2. Location\n\t3. Age\n\t4. Gender\n\t5. Marital Status\n\t6. Quit");
								//Prompt user for choice
								System.out.println("\nPlease enter your choice -> ");
								choice = input.nextInt();
								input.nextLine();
							}while(choice < 1 || choice > 6);//Keeep prompting user as choice is invalid
						

							switch(choice){

								case 1:
								//Prompt for name
								System.out.println("What is consumer's name");
								String name = input.nextLine();
								consumerDatabase[consumerIndex - 1].setName(name); //Call method
								break;
								case 2:
								System.out.print("Street number:"); //Prompt for steet number
								int streetNum = input.nextInt();
								input.nextLine();
								consumerDatabase[consumerIndex -1 ].setStreetNum(streetNum);
								System.out.print("Street name:"); //Prompt for street name
								String streetName = input.nextLine();
								consumerDatabase[consumerIndex -1].setStreetName(streetName);
								System.out.print("City:"); //Prompt for city
								String city = input.nextLine();
								consumerDatabase[consumerIndex-1].setCity(city);
								System.out.print("Postal code:"); //Prompt for postal code
								String postalCode = input.nextLine();
								consumerDatabase[consumerIndex-1].setPostalCode(postalCode);
								break;
								case 3: 
								System.out.print("What is consumer's age?: ");
								int age = input.nextInt();
								consumerDatabase[consumerIndex-1].setAge(age);
								break;
								case 4:
								System.out.print("\nWhat is consumer's gender?: ");
								String gender = input.nextLine();
								consumerDatabase[consumerIndex-1].setGender(gender);
								break;
								case 5:
								System.out.println("\nWhat is consumer's marital status");
								consumerDatabase[consumerIndex-1].inputMaritalStatus();
								break;
								case 6:
								//Quit
								break;
							}
					}while(choice != 6); //Keep prompting user as user does not quit

					}
					//Prompt user if he would like to stay on choice
					System.out.println("\nWould you like to enter a new consumer?(answer yes or no)");
					ans = input.nextLine();
					
				}while(ans.equalsIgnoreCase("yes")); //Keep prompting as user wants to stay on choice
				
			}
			break;
			case 3: //Find all consumers with prompted parameter
			//Prompt user to enter parameters
			System.out.println("Please enter the following to find given consumer:");
			//Prompt age
			System.out.print("Age: ");
			int age = input.nextInt();
			input.nextLine();
			//Prompt gender
			System.out.print("Gender: ");
			String gender = input.nextLine();
			//Prompt education
			System.out.println("Education: ");
			c.inputEduType();
			//Search for all consumers with the prompted parameters
			Consumer.findConsumerBy(consumerDatabase, age, gender, c.getEduType()); 
				
			

			break;
			case 4: ////Find all consumers with prompted parameter
			System.out.println("Please enter the following to find given consumer:");
			//Prompt age
			System.out.print("Age: ");
			age = input.nextInt();
			input.nextLine();
			//Prompt gender
			System.out.print("Postal code: ");
			String postalCode = input.nextLine();
			//Search for all consumers with the prompted parameters
			Consumer.findConsumerByAgeNPostalCode(consumerDatabase, age, postalCode);
			break;
			//Quit program
			case 5: programExit = true;
			//Display exit message
			System.out.println("\nProgram is now exiting....\n");
			System.out.println("\nThank you for using the consumer program!");
			break;

		}//end of switch statements
			
	}while(!programExit);//Keep prompting user as program is still running
	//Close scanner
	input.close();
	}

	//End of program
	
}


