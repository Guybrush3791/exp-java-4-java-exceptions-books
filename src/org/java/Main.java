package org.java;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.java.obj.Book;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("numero libri: ");
		int bookCount = sc.nextInt();
		
		sc.nextLine();
		
		Book[] books = new Book[bookCount];
		for (int x=0;x<bookCount;x++) {
			
			System.out.print("titolo: ");
			String title = sc.nextLine();
			
			System.out.print("numero pagine: ");
			int pageCount = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("autore: ");
			String author = sc.nextLine();
			
			System.out.print("editore: ");
			String editor = sc.nextLine();
			
			try {
				
				Book b = new Book(title, pageCount, author, editor);
				books[x] = b;
			} catch (Exception e) {
				
				x--;
				
				System.err.println("Valori non compatibili, riprovare");
				System.err.println(e.getMessage());
			}
		}
		
		try {
			
			FileWriter myWriter = new FileWriter("/tmp/tmp/books.txt");
			
			for (int x=0;x<bookCount;x++) {
				
				Book b = books[x];
				myWriter.write(b.toString() + "\n");
			}

			myWriter.close();
		} catch (Exception e) {
			
			System.err.println("Errore writing file: " + e.getMessage());
		}
		
		try {
			
			File bookFile = new File("/tmp/tmp/books.txt");
			Scanner reader = new Scanner(bookFile);
			
			while (reader.hasNextLine()) {
				
			   String line = reader.nextLine();
			   System.out.println(line);
			}

			reader.close();
		} catch (Exception e) {
			
			System.err.println("Errore reading file: " + e.getMessage());
		}
	}
}
