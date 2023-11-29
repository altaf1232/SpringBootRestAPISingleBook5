package com.springbootrestapi.controler;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.entites.BookEntites;
import com.springbootrestapi.service.BookService;
@RestController
public class BookControler {
	  @Autowired
	    private BookService bookService;
	    
		@GetMapping("/books")
		//ya Single  book key liye hai 
		 public   ResponseEntity<BookEntites> getBooks(@PathVariable("id")int book_id)
		 {
			
			BookEntites book= bookService.getBookById(book_id);
			if(book==null) 
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			//yaha per object return kar rahe hai 
			return  ResponseEntity.of(Optional.of(book)) ;
		
		 }
		@PostMapping("/books")
		//aap key Request ma ju data aarah hai book key object data kon karega tu yaha per pass karna huga @RequestBody
		public ResponseEntity<BookEntites> addBooks(@RequestBody BookEntites  book)
		{
			BookEntites booksTest=null;	
			try 
			{
				booksTest	=this.bookService.addTestBook(book);
				System.out.println(book);
				ResponseEntity.ok(Optional.of(booksTest));
			}
			catch(Exception e) 
			{
				//here handle Exception
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			return null;
		    
		   
		}
		@DeleteMapping("/books/{BookId}")
		public ResponseEntity<void> deleteBook_a(@PathVariable("BookId")int book_id) {
			try 
			{
	
			this.bookService.deleteBook_b(book_id);
			  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		    }
		    catch(Exception e) 
			{
		    	//todo : handle exception 
		    	e.printStackTrace();
		    	//aager kuch processing ma dikat aaya tu iss key liye ya code likha hai
		    	  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		   }
			
			
		}

}
