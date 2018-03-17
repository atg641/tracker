

	public class Book {
		@Override
		public String toString() {
			return "Book [title=" + title + ", borrowed=" + borrowed + "]";
		}


		String title;
		private boolean borrowed;
		// Creates a new Book
		public Book(String bookTitle) {
		// Implement this method
			title=bookTitle;
		}
		// Marks the book as rented
		public void borrowed() {
		// Implement this method
			borrowed = true;
			
			}
			
		
		public void setTitle(String title) {
			this.title = title;
		}
		// Marks the book as not rented
		public void returned() {
		// Implement this method
			borrowed = false;
		}
		// Returns true if the book is rented, false otherwise
		public boolean isBorrowed() {
		// Implement this method
//			if(borrowed == true) {
//				return true;
//			} else {
//				return false;
//			}
			
		return borrowed;
		}
		
		// Returns the title of the book
		public String getTitle() {
		
		return title;
		
		} 
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Small test of the Book class
		Book example = new Book("The Da Vinci Code");
		System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
		example.borrowed();
		System.out.println("Borrowed? (should be true): " + example.isBorrowed());
		example.returned();
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
	}

}
