package io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.BookEntity;
import io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.dao.BookDao;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link BookDao}.
 */
@Named
public class BookDaoImpl extends ApplicationDaoImpl<BookEntity> implements BookDao {

  /**
   * The constructor.
   */
  public BookDaoImpl() {

    super();
  }

  @Override
  public Class<BookEntity> getEntityClass() {

    return BookEntity.class;
  }

  @Override
  public PaginatedListTo<BookEntity> findBooks(BookSearchCriteriaTo criteria) {

    BookEntity book = Alias.alias(BookEntity.class);
    EntityPathBase<BookEntity> alias = Alias.$(book);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String authors = criteria.getAuthors();
    if (authors != null) {
      query.where(Alias.$(book.getAuthors()).eq(authors));
    }
    String title = criteria.getTitle();
    if (title != null) {
      query.where(Alias.$(book.getTitle()).eq(title));
    }
    return findPaginated(criteria, query, alias);
  }

}