package org.java.obj;

public class Book {

	private String title;
	private int pageCount;
	private String author;
	private String editor;
	
	public Book(String title, int pageCount, 
				String author, String editor) 
						throws Exception {
		
		setTitle(title);
		setPageCount(pageCount);
		setAuthor(author);
		setEditor(editor);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws Exception {
		
		if (title.isEmpty()) {
			
			throw new Exception("title couldn't be empty");
		}
		
		this.title = title;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) throws Exception {
		
		if (pageCount <= 0) {
			
			throw new Exception("pageCount has to be greater then 0");
		}
		
		this.pageCount = pageCount;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception {
		
		if (author.isEmpty()) {
			
			throw new Exception("author couldn't be empty");
		}
		
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	@Override
	public String toString() {
		
		return "(B) " + getTitle() + " - " + getAuthor()
			+ "\npage count: " + getPageCount()
			+ "\neditor: " + getEditor();
	}
}
