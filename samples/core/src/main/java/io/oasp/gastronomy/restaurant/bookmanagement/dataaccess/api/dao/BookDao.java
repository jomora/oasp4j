package io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.BookEntity;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Book entities
 */
public interface BookDao extends ApplicationDao<BookEntity> {

  /**
   * Finds the {@link BookEntity books} matching the given {@link BookSearchCriteriaTo}.
   *
   * @param criteria is the {@link BookSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link BookEntity} objects.
   */
  PaginatedListTo<BookEntity> findBooks(BookSearchCriteriaTo criteria);
}
