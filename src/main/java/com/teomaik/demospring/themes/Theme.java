package com.teomaik.demospring.themes;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teomaik.demospring.authors.Author;
import com.teomaik.demospring.books.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "themes")
public class Theme {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Or GenerationType.AUTO
    @JsonIgnore
    @Column(name = "theme_id", nullable = true)
    private Integer id;

    @Column(name = "name", nullable = true)
	private String name;

    @Column(name = "description", nullable = true)
	private String description;

    @ManyToMany(mappedBy = "themes") // Reference to the 'themes' field in Book
    @JsonIgnore
    private Set<Book> books;
    
    // Default constructor for JPA
    public Theme() {}
    
    public Theme (String name, String description) {
		this.name = name;
		this.description = description;
	}
    
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Theme(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
