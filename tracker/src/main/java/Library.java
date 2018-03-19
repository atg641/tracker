import java.util.ArrayList;

class Library {

	private static final int MAX_NUMBER_OF_CHECKED_OUT_BOOKS = 3;
	ArrayList<Book> books = new ArrayList<Book>();
	ArrayList<User> users = new ArrayList<User>();

	private String address;
	static String hours = "Libraries are open daily from 9am to 5pm.";

	public Library(String address) {
		// TODO Auto-generated constructor stub
		this.address = address;

	}

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		Book book1 = new Book("The Da Vinci Code");
		Book book2 = new Book("The Da Vinci Code");
		
		if(book1 == book2) {
			
		}
		
		if(book1.equals (book2)) {
			
		}
			

		firstLibrary.addBook(book1);
		firstLibrary.addBook(book2);
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		firstLibrary.addUser(new User("Mitchell"));
		User u = new User();
		u.name = "RANDI";
		firstLibrary.addUser(u);

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		System.out.println("Library addresses:");

		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings", "Mitchell");
		firstLibrary.borrowBook("The Da Vinci Code", "Mitchell");
		firstLibrary.borrowBook("Le Petit Prince", "Mitchell");
		firstLibrary.borrowBook("The Da Vinci Code", "Mitchell");
		firstLibrary.borrowBook("A Tale of Two Cities", "Mitchell");
		
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();

		firstLibrary.printAllUsers();
	}

	private void returnBook(String title) {
		for (Book bk : books) {
			if (bk.title.equals(title) && bk.isBorrowed()) {
				bk.returned();
			}
		}
	}

	private void printAvailableBooks() {
		for (Book bk : books) {
			if (!bk.isBorrowed()) {
				System.out.println(bk.title);
			}
		}
	}

	private Book findBookWithTitle(String title) {
		for (Book bk : books) {
			if (bk.title.equals(title) && !bk.isBorrowed()) {
				return bk;
			}
		}
		return null;
	}
	private User findUserWithName(String name) {
		for (User us : users) {
			if (us.name.equals(name)) {
				return us;
			}
		}
		return null;
	}

	private boolean isUserValid(String name) {
		for (User us : users) {
			if (us.name.equals(name)) {
				return true;
			}
		}
		return false;
	}

//	private boolean isCountMax(int ct, String name) {
//		User us = findUserWithName(name);
//		if(ct >= 3) {
//			return true;
//		}
//		return false;
//	}

	private boolean borrowBook(String title, String name) {
		Book bk = findBookWithTitle(title);
		User us = findUserWithName(name);
		if (bk != null && this.isUserValid(name) && us.count < MAX_NUMBER_OF_CHECKED_OUT_BOOKS) {
			bk.borrowed();
			us.count++;
			return true;
		}
		return false;
	}

	private void printAddress() {
		System.out.print(address);
	}

	private static void printOpeningHours() {
		System.out.println(hours);
	}

	private void addBook(Book book) {
		books.add(book);

	}

	private void addUser(User libraryUser) {
		users.add(libraryUser);
	}

	private void printAllUsers() {
		for (User us : users) {
			System.out.println(us.name);
		}
	}

}

