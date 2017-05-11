package io.oasp.gastronomy.restaurant.bookmanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.BookEntity;
import io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.dao.BookDao;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.Bookmanagement;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookEto;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of bookmanagement
 */
@Named
@Transactional
public class BookmanagementImpl extends AbstractComponentFacade implements Bookmanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(BookmanagementImpl.class);

  /** @see #getBookDao() */
  @Inject
  private BookDao bookDao;

  /**
   * The constructor.
   */
  public BookmanagementImpl() {
    super();
  }

  @Override
  public BookEto findBook(Long id) {

    LOG.debug("Get Book with id {} from database.", id);
    return getBeanMapper().map(getBookDao().findOne(id), BookEto.class);
  }

  @Override
  public PaginatedListTo<BookEto> findBookEtos(BookSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<BookEntity> books = getBookDao().findBooks(criteria);
    return mapPaginatedEntityList(books, BookEto.class);
  }

  @Override
  public boolean deleteBook(Long bookId) {

    BookEntity book = getBookDao().find(bookId);
    getBookDao().delete(book);
    LOG.debug("The book with id '{}' has been deleted.", bookId);
    return true;
  }

  @Override
  public BookEto saveBook(BookEto book) {

    Objects.requireNonNull(book, "book");
    BookEntity bookEntity = getBeanMapper().map(book, BookEntity.class);

    // initialize, validate bookEntity here if necessary
    BookEntity result = getBookDao().save(bookEntity);
    LOG.debug("Book with id '{}' has been created.", result.getId());

    return getBeanMapper().map(result, BookEto.class);
  }

  /**
   * Returns the field 'bookDao'.
   *
   * @return the {@link BookDao} instance.
   */
  public BookDao getBookDao() {

    return this.bookDao;
  }

}