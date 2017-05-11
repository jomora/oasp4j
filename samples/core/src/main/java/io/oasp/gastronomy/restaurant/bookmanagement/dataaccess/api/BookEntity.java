package io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.gastronomy.restaurant.bookmanagement.common.api.Book;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * @author jmolinar
 */
@Entity
@Table(name = "Book")
public class BookEntity extends ApplicationPersistenceEntity implements Book {

  private String authors;

  private String title;

  private static final long serialVersionUID = 1L;

  /**
   * @return authors
   */
  @Override
  public String getAuthors() {

    return this.authors;
  }

  /**
   * @param authors new value of {@link #getauthors}.
   */
  @Override
  public void setAuthors(String authors) {

    this.authors = authors;
  }

  /**
   * @return title
   */
  @Override
  public String getTitle() {

    return this.title;
  }

  /**
   * @param title new value of {@link #gettitle}.
   */
  @Override
  public void setTitle(String title) {

    this.title = title;
  }

}
