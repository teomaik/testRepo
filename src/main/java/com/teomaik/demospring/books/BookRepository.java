package com.teomaik.demospring.books;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // 1. Find by title
    List<Book> findByTitle(String title);
    
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> findByTitleTest(@Param("keyword") String keyword);
//    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword% AND b.publishYear = :year")
//    List<Book> findBooksByTitleKeywordAndYear(@Param("keyword") String keyword, @Param("year") int year);


    // 2. Find by title containing a keyword (case insensitive)
    List<Book> findByTitleContainingIgnoreCase(String keyword);

    // 3. Find by author
    List<Book> findByAuthorFirstNameAndAuthorLastName(String firstName, String lastName);

    // 4. Find books by author's ID
    List<Book> findByAuthorId(Integer authorId);

    // 5. Find books published in a specific year
    List<Book> findByPublishYear(int publishYear);

    // 6. Find books published by a specific publisher
    List<Book> findByPubliser(String publiser);

    // 7. Find books where description contains a word or phrase
    List<Book> findByDescriptionContainingIgnoreCase(String keyword);

    // 8. Find the first book by title (optional)
    Optional<Book> findFirstByTitle(String title);

    // 9. Find books published in a range of years
    List<Book> findByPublishYearBetween(int startYear, int endYear);

    // 10. Find all books by multiple author IDs
    List<Book> findByAuthorIdIn(List<Integer> authorIds);

    // 11. Find books with themes matching a specific theme ID
    List<Book> findByThemesId(Integer themeId);

    // 12. Count the number of books published by a specific publisher
    long countByPubliser(String publiser);

    // 13. Delete books by a specific author
    void deleteByAuthorId(Integer authorId);
	
    // 14. Find books published earlier than a specific year 
	List<Book> findByPubliserAndPublishYearLessThanEqual(String publiser, int publishYear);

//	findByTitle
//	findByTitleStartingWith
//	findByTitleEndingWith
//	findByTitleContaining
//	findByPubliserAndPublishYearGreaterThanEqual
//	findByPubliserAndPublishYearGreaterThanEqual
	
//	findByPublishYearBetween(int start, int end)
//	findByPublisherIn(List<String> pubs)

}
