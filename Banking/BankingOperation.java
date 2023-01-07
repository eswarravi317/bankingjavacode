package Banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingOperation {
	
	static List<Customer> customerList = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ER Bank Application");
		int choice;
		do {
			System.out.print("\n1.Existing Customer Login\n2.New Customer Registration\nEnter choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Enter AccountNo: ");
				String loginAccountno = sc.next();
				System.out.print("Enter DOB (dd-mm-yyyy): ");
				String loginDob = sc.next();
				for(Customer c: customerList) {
					if(loginAccountno.equals(c.accountNo)) {
						if(loginDob.equals(c.dob)) {
							System.out.println("Login success...\nWelcome "+c.name+"!");
							int validUserChoice;
							do {
								System.out.println("1.Get Account Details\n2.Withdraw\n3.Add Amount\n4.Logout\nEnter choice: ");
								validUserChoice = sc.nextInt();
								switch(validUserChoice) {
								case 1:
									System.out.println("---------------------------------");
									c.getAccountDetails();
									System.out.println();
									break;
								case 2:
									System.out.print("Enter amount: ");
									double wAmount = sc.nextDouble();
									if(wAmount > c.accountBalance) {
										System.out.println("Insufficient amount");
									}
									else {
										c.accountBalance -= wAmount;
										System.out.println("Withdrawn successfully\nClosing Balance - "+ c.accountBalance);
									}
									break;
								case 3:
									System.out.print("Enter amount to add: ");
									double aAmount = sc.nextDouble();
									if(aAmount<=0) {
										System.out.println("Invalid amount");
									}
									else {
										c.accountBalance += aAmount;
										System.out.println("Added successfully\nClosing Balance - "+ c.accountBalance);
									}
									break;
								case 4:
									System.out.println("Successfully Logged out!");
									return;
								}
							} while(validUserChoice>0 && validUserChoice<5);
						}
					}
				}
				break;
			case 2:
				System.out.println("Note: To create account must be age greater than 18 (including)!");
				System.out.print("Your age: ");
				int age = sc.nextInt();
				if(age<18) {
					System.out.println("You're not eligible to create account...Exiting...");
					return;
				}
				else {
					System.out.print("Enter Name: ");
					String registerName = sc.next();
					System.out.print("Enter DOB (dd-mm-yyyy): ");
					String registerDob = sc.next();
					System.out.print("Initial Amount: ");
					double registerBalance = sc.nextDouble();
					Customer customerObj = new Customer().setDetails(registerName, registerDob, registerBalance, age);
					customerList.add(customerObj);
					System.out.println("Login to access your account actions...");
				}
				break;
			}
		} while(choice>0 && choice<3);
	}
}