package scope.more;
import scope.more.Book;
import scope.more.Employee;
class Bookstore {
	private static final int DEFAULT_NO_OF_EMPLOYEES = 20;
	private static final int DEFAULT_NO_OF_BOOKS = 100;
	private String id;
	private Book[] books;
	private Employee[] employees;

	Bookstore(String theId){
		id = theId;
		books = new Book[DEFAULT_NO_OF_BOOKS];
		employees = new Employee[DEFAULT_NO_OF_EMPLOYEES];
	}
	int getNumBooks() {
		int j = 0;
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				j = i;
				break;
			}
		}
		return j;
	}
	int getNumEmployees(){
		int j = 0;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				j = i;
				break;
			}
		}
		return j;
	}
	boolean addNewBook(String bookId) {
		Book book = new Book(bookId);
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = book;
				return true;
			}
		}
		return false;
	}
	boolean addNewEmployee(String employeeId){
		Employee employee = new Employee(employeeId);
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				employees[i] = employee;
				return true;
			}
		}
			return false;
	}
	boolean bookIsInStock(String bookId) {
		for (int i = 0; i < books.length; i++) {
			if (bookId.equals(books[i])) return true;
		}
		return false;
	}
}