package scope.more;
import scope.more.Employee;
import scope.more.Market;
public class StoreDirectory {
	private Bookstore bookstore;
	private Market market;
	public StoreDirectory(String custId){
		bookstore = new Bookstore(custId);
		market = new Market();
	}





	public int getNumberOfBooks() {
		return bookstore.getNumBooks();
	}
	public int getNumberOfBookstoreEmployees() {
		return bookstore.getNumEmployees();
	}
	public boolean addNewEmployee(String employeeId){
		return bookstore.addNewEmployee(employeeId);
	}
	public boolean bookIsInStock(String bookId){
		return bookstore.bookIsInStock(bookId);
	}
	public boolean addNewBook(String bookId){
		return bookstore.addNewBook(bookId);
	}
	public boolean marketCarriesFoodItem(String foodItem){
		return market.carriesFoodItem(foodItem);
	}
}
