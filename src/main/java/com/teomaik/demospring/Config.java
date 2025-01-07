package com.teomaik.demospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teomaik.demospring.authors.AuthorServices;
import com.teomaik.demospring.books.BookServices;
import com.teomaik.demospring.themes.ThemeServices;


@Configuration
public class Config {

    @Bean
    public CommandLineRunner commandLineRunner
            (AuthorServices authorServices,
            		ThemeServices themeServices,
            		BookServices bookServices){
        return args -> {
//        	Author tolkien = new Author(1, "John Ronald Reuel", "Tolkien", "1/1/1910");
//        	authorServices.addAuthor(tolkien);
//        	authorServices.addAuthor(new Author(2, "George", "Orwell", "1/1/1925"));
//
//        	themeServices.addTheme(new Theme(1, "Fantasy", "Fantasy description"));
//        	themeServices.addTheme(new Theme(2, "Political", "Political description"));
//        	themeServices.addTheme(new Theme(3, "Science Fiction", "Science Fiction description"));
//        	
//        	bookServices.addBook(new Book(1, "The Hobbit", tolkien, "a publiser", 1954, "There and Back Again",
//			new ArrayList<Theme>()));
        };
    }
    
}
