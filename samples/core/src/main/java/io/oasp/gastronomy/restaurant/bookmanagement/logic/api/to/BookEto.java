package io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.bookmanagement.common.api.Book;
import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Book
 */
public class BookEto extends AbstractEto implements Book {

  private static final long serialVersionUID = 1L;

  private String authors;

  private String title;

  @Override
  public String getAuthors() {

    return authors;
  }

  @Override
  public void setAuthors(String authors) {

    this.authors = authors;
  }

  @Override
  public String getTitle() {

    return title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.authors == null) ? 0 : this.authors.hashCode());
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    BookEto other = (BookEto) obj;
    if (this.authors == null) {
      if (other.authors != null) {
        return false;
      }
    } else if (!this.authors.equals(other.authors)) {
      return false;
    }
    if (this.title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!this.title.equals(other.title)) {
      return false;
    }
    return true;
  }
}
