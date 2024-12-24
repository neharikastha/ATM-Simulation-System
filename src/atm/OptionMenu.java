package atm;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.IOException;
import java.text.DecimalFormat;
 
public class OptionMenu extends Account{
	Scanner menuInput= new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'Rs'###,###.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	/* Validate Login information customer number and pin number */
	// We declared that this method throws an exception
	public void getLogin() throws IOException{
		int x = 1;
		do {
			try {
				data.put(9876543, 9876);
				data.put(8989898, 1890);
				data.put(89878898, 1891);
				
				System.out.println("Welcome to the ATM Project!");
				
				System.out.println("Enter Your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN number: ");
				setPinNumber(menuInput.nextInt());
				
			} catch (Exception e)
			{
				System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
				x=2;
			} 
			
			// I do not understand
			for (Entry<Integer, Integer> entry : data.entrySet() ) {
				if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber())
					getAccountType();
				}
		
		System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
	}while(x == 1);
	}
	
	/* Display Account Type Menu with selection */
	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.println("Choice: ");
		
		 selection = menuInput.nextInt();
		
		switch (selection) {
		case 1 :
			getChecking();
			break;
		case 2 :
			getSaving();
			break;
		case 3 :
			System.out.println("Thank you for using this ATM, bye. ");
			break;
		
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getAccountType();			
		}
	}
	
	/* Display Checking Account Menu with selections */
	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		 selection= menuInput.nextInt();
		
		switch(selection) {
		case 1 :
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		
		case 2 :
			getCheckingWithdrawInput();
			getAccountType();
			break;
		
		case 3 :
			getCheckingDepositInput();
			getAccountType();
			break;
			
		case 4 :
			System.out.println("Thank you for using this ATM, bye. ");
		}	
	}
	

	/* Display Checking Account Menu with selections */
	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		 selection= menuInput.nextInt();
		
		switch(selection) {
		case 1 :
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		
		case 2 :
			getSavingWithdrawInput();
			getAccountType();
			break;
		
		case 3 :
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4 :
			System.out.println("Thank you for using this ATM, bye. ");
		}	
	}
	
int selection;
}
