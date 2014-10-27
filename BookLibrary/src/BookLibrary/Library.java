package BookLibrary;

import java.util.*;

public class Library {
	
	private static String openingHours = "Libraries are open daily from 9am to 5pm.";
	
	private List<Book> books;
	private String adress;
	
	public Library(String libraryAdress) {
		this.adress = libraryAdress;
		this.books = new ArrayList<Book>();
	}	

	public void addBook(Book newBook) {
		Book existingBook = findBookbyTitle( newBook.getTitle() );
		
		// It is not allowed to add duplicate Books
		if( existingBook == null )
			this.books.add( newBook );
		else
			System.out.println("Book " + newBook.getTitle() + " already exists in Library");
	}
	
	public void borrowBook(String bookTitle) {
		
		Book searchedBook = findBookbyTitle( bookTitle );
		
		if( searchedBook != null ) {			
			if( searchedBook.isBorrowed() )
				System.out.println("Sorry, this book is already borrowed");
			else {
				searchedBook.borrowed();
				System.out.println("You successfully borrowed " + bookTitle);
			}			
		}	
		else
			System.out.println("Sorry, this book is not in our catalog");
	}
	
	public void returnBook(String bookTitle) {
		
		Book searchedBook = findBookbyTitle( bookTitle );
		
		if( searchedBook != null ) {
			if( searchedBook.isBorrowed() ) {
				searchedBook.returned();
				System.out.println("You successfully returned " + bookTitle);
			}
			else {
				System.out.println("Sorry, this book is not borrowed");
			}			
		}
		else
			System.out.println("Sorry, this book is not in our catalog");
	}
	
	private Book findBookbyTitle(String bookTitle) {
		for (Book book : this.books) {
			if( book.getTitle().equals( bookTitle ) ) {
				return book;
			}
		}
		return null;
	}
	
	public void printAvailableBooks() {
		if( this.books.size() > 0 ) {
			for (Book book : this.books) {
				if( !book.isBorrowed() )
					System.out.println( book.getTitle() );
			}
		}
		else
			System.out.println("No book in catalog");
	}
	
	public void printAddress() {
		System.out.println( this.adress );
	}	
	
	public static void printOpeningHours() {
		System.out.println( openingHours );
	}

	 // Add missing implementation to this class
	 public static void main(String[] args) {
		 // Create two libraries
		 Library firstLibrary = new Library("10 Main St.");
		 Library secondLibrary = new Library("228 Liberty St.");
		 
		 // Add four books to the first library
		 firstLibrary.addBook(new Book("The Da Vinci Code"));
		 firstLibrary.addBook(new Book("Le Petit Prince"));
		 firstLibrary.addBook(new Book("A Tale of Two Cities"));
		 firstLibrary.addBook(new Book("The Lord of the Rings"));
		 		 
		 // Print opening hours and the addresses
		 System.out.println("Library hours:");
		 printOpeningHours();
		 System.out.println();
		 System.out.println("Library addresses:");
		 firstLibrary.printAddress();
		 secondLibrary.printAddress();
		 System.out.println();		 
		 
		 // Try to borrow The Lord of the Rings from both libraries
		 System.out.println("Borrowing The Lord of the Rings:");
		 firstLibrary.borrowBook("The Lord of the Rings");
		 firstLibrary.borrowBook("The Lord of the Rings");
		 secondLibrary.borrowBook("The Lord of the Rings");
		 System.out.println();
		 
		 // Print the title of all books available from both libraries
		 System.out.println("Books available in the first library:");
		 firstLibrary.printAvailableBooks();
		 System.out.println();
		 System.out.println("Books available in the second library:");
		 secondLibrary.printAvailableBooks();
		 System.out.println();
		 
		 // Return The Lord of the Rings to the first library
		 System.out.println("Returning The Lord of the Rings");
		 firstLibrary.returnBook("The Lord of the Rings");		 
		 System.out.println();
		 
		 // Print the titles of all books available from the first library
		 System.out.println("Books available in the first library:");
		 firstLibrary.printAvailableBooks();
		 
	 }

}
