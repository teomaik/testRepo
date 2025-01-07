package com.teomaik.demospring.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.teomaik.demospring.authors.Author;
import com.teomaik.demospring.themes.Theme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = true)
	private Author author;

	@Column(name = "publiser", nullable = true)
	private String publiser;

	@Column(name = "publishYear", nullable = true)
	private int publishYear;

	@Column(name = "description", nullable = true)
	private String description;

	@ManyToMany
	@JoinTable(name = "book_themes_map", // Join table name
			joinColumns = @JoinColumn(name = "book_id"), // Foreign key for Book
			inverseJoinColumns = @JoinColumn(name = "theme_id") // Foreign key for Theme
	)
	private Set<Theme> themes;

	public Book() {
	}

	public Book(Integer id, String title, Author author, String publiser, int publishYear, String description,
			Set<Theme> theme) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publiser = publiser;
		this.publishYear = publishYear;
//		this.themes = theme;
		this.description = description;
	}

	public void deleteTheme(Theme theme) {
		themes.remove(theme);
	}

	public Set<Theme> getTheme() {
		return themes;
	}

	public void setTheme(Set<Theme> theme) {
		this.themes = theme;
	}

	public void addTheme(Theme theme) {
		this.themes.add(theme);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getPubliser() {
		return publiser;
	}

	public void setPubliser(String publiser) {
		this.publiser = publiser;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
