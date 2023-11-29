package com.springbootrestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springbootrestapi.entites.BookEntites;


@Component
public class BookService {
	 //here create ArrayList
	 private static  List<BookEntites> list=new ArrayList<>();
	 
	 //here create block
	static 
	 {
	     list.add(new BookEntites(12,"java developer","xyz"));
		 list.add(new BookEntites(13,"Paythen developer","xyb"));
		 list.add(new BookEntites(14,"Dot.net developer","xyc"));
	}
	 //here create method
	 //get all books 
	 //this method return all books 
	 //here is create Multiple books  
	 public  List<BookEntites> getAllBooks()
	 {
		 return list;
	 }
	 //here is create Single books
	 //get single book by id
	 public BookEntites getAllBookById(int id)
	 {
		 //here i am using StreemAPI
		 BookEntites books=null;
		 try
		 {
			 
	      books= list.stream().filter(e->e.getBook_id()==id ).findFirst().get();
		 }
		 catch(Exception e) 
		 {
			 e.printStackTrace();
		 }
		 return books;
	 }
	 //create method /adding the BookEntits
	 public BookEntites addTestBook(BookEntites booksTest) {
		 
		 list.add(booksTest);
		 return booksTest;
	 }
	 // Delete Book handler 
   public  void deleteBook_b(int bId) {
  	list.stream().filter(book ->book.getBook_id()!=bId).collect(Collectors.toList());
   }
    public BookEntites getBookById(int book_id) {
	// TODO Auto-generated method stub
	return null;
}


}
