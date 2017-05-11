package io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.gastronomy.restaurant.bookmanagement.common.api.Book}s.
 *
 */
public class BookSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String authors;

  private String title;

  /**
   * The constructor.
   */
  public BookSearchCriteriaTo() {

    super();
  }

  public String getAuthors() {

    return authors;
  }

  public void setAuthors(String authors) {

    this.authors = authors;
  }

  public String getTitle() {

    return title;
  }

  public void setTitle(String title) {

    this.title = title;
  }

}
