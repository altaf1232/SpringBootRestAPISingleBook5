package com.springbootrestapi.entites;

public class BookEntites {
	private int book_id;
	private String title;
	private String author;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookEntites(int book_id, String title, String author) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
	}
	public BookEntites() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookEntites [book_id=" + book_id + ", title=" + title + ", author=" + author + "]";
	}
	

}
