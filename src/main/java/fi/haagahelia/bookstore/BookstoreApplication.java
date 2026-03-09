package fi.haagahelia.bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.AppUser;
import fi.haagahelia.bookstore.domain.AppUserRepository;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;



import org.slf4j.Logger;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookDemo(
		BookRepository repository,
		CategoryRepository crepository, 
		AppUserRepository urepository) {
			
		return (args) -> {
			log.info("save a couple of books");

			Category Category1 = new Category("Fantasy");
			Category Category2 = new Category("Romance");
			Category Category3 = new Category("Scifi");
			
			
			crepository.save(Category1);
			crepository.save(Category2);
			crepository.save(Category3);
			

			repository.save(new Book(
    "And Then There Were None",
    "Agatha Christie",
	1939,
    "9780062073488",
	Category1
	
    
));

repository.save(new Book(
	
    "The Lord of the Rings",
    "J. R. R. Tolkien",
	1954,
    "9780618640157",
	Category2
    
));

repository.save(new Book(
    "Harry Potter and the Philosopher's Stone",
    "J. K. Rowling",
	1997,
    "9780747532699",
	Category3

    
));

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","user@bookstore.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@bookstore.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
