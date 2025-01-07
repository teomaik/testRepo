package com.teomaik.demospring.books;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teomaik.demospring.authors.Author;
import com.teomaik.demospring.themes.Theme;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookServices bookServices;
	
	@Autowired 
	BookRepository repository;


	@GetMapping("/hello")
	public String hello() {
		return "Hello from Book controller";
	}

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return bookServices.getAllBooks();
	}

	@PostMapping("/add")
	public List<Book> addBook(@RequestBody Book book) {
		return bookServices.addBook(book);
	}

	@DeleteMapping("/delete")
	public List<Book> deleteBook(@RequestParam Integer id) {
		return bookServices.removeBook(id);
	}
	
	@GetMapping("/{book_id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer book_id) {
		try {
	        Book book = bookServices.findBookById(book_id);
	        return ResponseEntity.ok(book);
	    } catch (Exception ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	@GetMapping("/test")
	public ResponseEntity<List<Book>> findByTitleTest(@RequestParam String title) {
		try {
			List<Book> book = repository.findByTitleTest(title);
	        return ResponseEntity.ok(book);
	    } catch (Exception ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestParam Integer id, @RequestParam(required = false) String title,
			@RequestParam(required = false) String publiser, @RequestParam(required = false) int publishYear,
			@RequestParam(required = false) String description, @RequestParam(required = false) Set<Theme> theme,
			@RequestParam(required = false) Author author) {
		return bookServices.updateBook(id, title, author, publiser, publishYear, description, theme);
	}

	@PutMapping("/addTheme")
	public Book addTheme(@RequestParam Integer id, @RequestParam Integer themeId) {
		return bookServices.addTheme(id, themeId);
	}

	@PutMapping("/updateAuthor")
	public Book updateAuthor(@RequestParam Integer id, @RequestParam Integer authorId) {
		return bookServices.changeAuthor(id, authorId);
	}
	
	@DeleteMapping("/deleteTheme")
	public Book deleteTheme(@RequestParam Integer id, @RequestParam Integer themeId) {
		return bookServices.deleteTheme(id, themeId);
	}

	@GetMapping("/findByPubAndYear")
	public List<Book> findByPubAndYear(@RequestParam String publiser, @RequestParam int publishYear) {
		return repository.findByPubliserAndPublishYearLessThanEqual(publiser, publishYear);
	}
}