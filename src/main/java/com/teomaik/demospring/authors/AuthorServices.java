package com.teomaik.demospring.authors;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServices {

	@Autowired AuthorRepository repository;

	//TODO add method getWithID
	
	public List<Author> getAllAuthors() {
		return repository.findAll();
	}

	public List<Author> addAuthor(Author author) {
		repository.save(author);
		return repository.findAll();
	}

	public List<Author> removeAuthor(Integer id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	public Author updateAuthor(int id, String firstName, String lastName, String dateOfBirth) {
        Optional<Author> optionalAuthor = repository.findById(id);
        
        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            
            // Update fields if new values are provided
            if (firstName != null && !firstName.isEmpty()) {
                existingAuthor.setFirstName(firstName);
            }
            if (lastName != null && !lastName.isEmpty()) {
                existingAuthor.setLastName(lastName);
            }
            if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
                existingAuthor.setDateOfBirth(dateOfBirth);
            }

            // Save and return the updated author
            return repository.save(existingAuthor);
        } else {
            throw new RuntimeException("Author with ID " + id + " not found");
        }
	}
}
