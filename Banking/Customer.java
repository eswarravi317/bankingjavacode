package Banking;

public class Customer {
	
	static int id = 0;
	int customerId;
	String accountNo;
	String name;
	String dob;
	int age;
	double accountBalance;
	
	Customer(){
		id = id+1;
		customerId = id;
		accountNo = "296310101"+id;
		name = null;
		dob = null;
		age = 0;
		accountBalance = 0.0;
	}
	
	Customer setDetails(String name, String dob, double initialBalance, int age){
		this.name = name;
		this.dob = dob;
		accountBalance = initialBalance;
		this.age = age;
		System.out.println("Account created successfully\nYour Account No - "+accountNo+"\nKeep note for future use!");
		return Customer.this;
	}
	
	public void getAccountDetails() {
		System.out.println("Account No - "+ accountNo +"\n"
				+"Name - "+ name +"\n"
				+"DOB - "+ dob +"\n"
				+"Age - "+ age +"\n"
				+"Current Balance - "+ accountBalance);
	}
	
}