package fi.haagahelia.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@Controller
public class BookRestController {


    private BookRepository bookRepository; 

		
		public BookRestController(BookRepository bookRepository) {
			this.bookRepository = bookRepository;
		}
		
	  
	    @GetMapping("/books")
	    public @ResponseBody List<Book> bookListRest() {	
	        return (List<Book>) bookRepository.findAll();
	    }    

	    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	
			return bookRepository.findById(bookId);
	    }       
	    
	    @RequestMapping(value="/books", method = RequestMethod.POST)
	    public @ResponseBody Book saveNewBookRest(@RequestBody Book book) {	
	    	return bookRepository.save(book);
	    }    

        @RequestMapping(value="/books/{id}", method = RequestMethod.DELETE)
        public void deleteBookRest(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        }


}

