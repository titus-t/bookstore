package fi.haagahelia.bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

import org.slf4j.Logger;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");

			repository.save(new Book(
    "And Then There Were None",
    "Agatha Christie",
	1939,
    "9780062073488"
	
    
));

repository.save(new Book(
    "The Lord of the Rings",
    "J. R. R. Tolkien",
	1954,
    "9780618640157"
    
));

repository.save(new Book(
    "Harry Potter and the Philosopher's Stone",
    "J. K. Rowling",
	1997,
    "9780747532699"
    
));

			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
