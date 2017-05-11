package io.oasp.gastronomy.restaurant.bookmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.Bookmanagement;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookEto;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.bookmanagement.service.api.rest.BookmanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Bookmanagement}.
 */
@Named("BookmanagementRestService")
public class BookmanagementRestServiceImpl implements BookmanagementRestService {

  @Inject
  private Bookmanagement bookmanagement;

  @Override
  public BookEto getBook(long id) {

    return this.bookmanagement.findBook(id);
  }

  @Override
  public BookEto saveBook(BookEto book) {

    return this.bookmanagement.saveBook(book);
  }

  @Override
  public void deleteBook(long id) {

    this.bookmanagement.deleteBook(id);
  }

  @Override
  public PaginatedListTo<BookEto> findBooksByPost(BookSearchCriteriaTo searchCriteriaTo) {

    return this.bookmanagement.findBookEtos(searchCriteriaTo);
  }

}