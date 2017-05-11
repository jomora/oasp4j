package io.oasp.gastronomy.restaurant.bookmanagement.logic.api;

import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookEto;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Bookmanagement component.
 */
public interface Bookmanagement {

  /**
   * Returns a Book by its id 'id'.
   *
   * @param id The id 'id' of the Book.
   * @return The {@link BookEto} with id 'id'
   */
  BookEto findBook(Long id);

  /**
   * Returns a paginated list of Books matching the search criteria.
   *
   * @param criteria the {@link BookSearchCriteriaTo}.
   * @return the {@link List} of matching {@link BookEto}s.
   */
  PaginatedListTo<BookEto> findBookEtos(BookSearchCriteriaTo criteria);

  /**
   * Deletes a book from the database by its id 'bookId'.
   *
   * @param bookId Id of the book to delete
   * @return boolean <code>true</code> if the book can be deleted, <code>false</code> otherwise
   */
  boolean deleteBook(Long bookId);

  /**
   * Saves a book and store it in the database.
   *
   * @param book the {@link BookEto} to create.
   * @return the new {@link BookEto} that has been saved with ID and version.
   */
  BookEto saveBook(BookEto book);

}