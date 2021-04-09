package scope;

import java.util.Scanner;

import scope.more.StoreDirectory;


public class Driver {
	private Scanner sc = new Scanner(System.in);
	private String userID;
	private StoreDirectory directory;

	final String CONTINUE = "Review more options? (Y/N)";
	final String line = System.getProperty("line.separator");

	public static void main(String[] args){
		new Driver();
	}
	public Driver(){
		System.out.println("What is your Id? (An Id is a 3-digit code, like 009.)");
		String userId = sc.nextLine();
		this.userID = userId;
		directory = new StoreDirectory(this.userID);
		String inputString = "Y";
		String outputString = null;
		displayOptions();
		while(!inputString.equalsIgnoreCase("N")){
			inputString = sc.nextLine();

			if(inputString.equalsIgnoreCase("A")){
				displayNumberOfBooks();
			}
			else if(inputString.equalsIgnoreCase("B")){
				displayNumberOfEmployees();
			}
			else if(inputString.equalsIgnoreCase("C")){
				outputString = "In Input Area, type in the employee number using this format:"+line+
							   "   add employee xxx"+line+
							   "where 'xxx' is the 3-digit code for the employee number.";
				//...
				System.out.println(outputString);

			}
			else if(inputString.equalsIgnoreCase("D")){

				outputString = "In Input Area, type in the book id number using this format:"+line+
				   "   book xxx"+line+
				   "where 'xxx' is the 3-digit code for the employee number.";
				System.out.println(outputString);

			}
			else if(inputString.equalsIgnoreCase("E")){

				outputString = "In Input Area, type in the book number using this format:"+line+
				   "   add book xxx"+line+
				   "where 'xxx' is the 3-digit code for the book number.";
				System.out.println(outputString);
			}

			else if(inputString.equalsIgnoreCase("H")){
				outputString = "In Input Area, type in the name of the food item using this format:"+line+
				   "   food nn..."+line+
				   "where 'nn...' represents the name of the food item (like bananas or cherries).";
				System.out.println(outputString);
			}
			else if(inputString.trim().startsWith("add employee")){  //add employee

				int len = "add employee".length();
				addEmployee(inputString.substring(len).trim());
			}
			else if(inputString.trim().startsWith("add book")){  //add book
				int len = "add book".length();
				addBook(inputString.substring(len).trim());
			}
			else if(inputString.trim().startsWith("book")){
				int len = "book".length();
				checkIfBookIsInStock(inputString.substring(len).trim());
			}
			else if(inputString.trim().startsWith("food")){
				int len = "food".length();
				checkWhetherFoodItemInMarket(inputString.substring(len).trim());
			}
			else if(inputString.trim().equalsIgnoreCase("Y")){
				displayOptions();
			}
			else if(inputString.trim().equalsIgnoreCase("N")){
				System.out.println("Have a nice day! Bye!");
				System.exit(0);
			}
			else {
				System.out.println(line+"I did not understand your response."+line);
				displayOptions();
			}
		}

	}

	//this implementation has been done for you
	void displayNumberOfBooks() {
		int numbooks = directory.getNumberOfBooks();
		if(numbooks > -1){
			System.out.println("Number of books is: "+ numbooks + "." );
		}

	}
	void displayNumberOfEmployees() {
		int bookStoreEmployees = directory.getNumberOfBookstoreEmployees();
		System.out.println("Number of employees is: " + bookStoreEmployees + ".");
	}

	void addEmployee(String employeeId){
		boolean employeeAdded = directory.addNewEmployee(employeeId);
		if (employeeAdded) {
			System.out.println("The employee has been added.");
		} 
		else {
			System.out.println("The employee could not be added");
		}
		
	}
	void addBook(String bookId){
		boolean addBook = directory.addNewBook(bookId);
		if (addBook == true) {
			System.out.println("The book has been added.");
		} 
		else System.out.println("The book could not be added");
		
	}
	void checkIfBookIsInStock(String bookId){
		boolean bookInstock = directory.bookIsInStock(bookId);
		if (bookInstock) {
			System.out.println("This book is instock.");
		} 
		else {
			System.out.println("This book is not instock");
		}
	}

	void checkWhetherFoodItemInMarket(String foodItem){
		boolean foodItemInstock = directory.marketCarriesFoodItem(foodItem);
		if (foodItemInstock) {
			System.out.println("This item is instock.");
		} 
		else {
			System.out.println("This item is not instock");
		}
	}

	void displayOptions(){
		String display = "TYPE A LETTER IN INPUT AREA TO MAKE A SELECTION"+line+line+
						 "A. Learn how many books are in bookstore."+line+
						 "B. Learn how many employees are in bookstore."+line+
						 "C. Add an employee to the bookstore."+line+
						 "D. See if a book is in stock in the bookstore."+line+
						 "E. Add a book to the bookstore."+line+
						 "H. See if the market carries a particular food item."+line+
						 "N. Exit the system.";
		System.out.println(display);
	}

}