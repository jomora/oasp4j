package io.oasp.gastronomy.restaurant.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.gastronomy.restaurant.bookmanagement.dataaccess.api.BookEntity;

/**
 * Test data builder for BookEntity generated with cobigen.
 */
public class BookEntityBuilder {

  private List<P<BookEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public BookEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * @param authors the authors to add.
   * @return the builder for fluent population of fields.
   */
  public BookEntityBuilder authors(final String authors) {

    this.parameterToBeApplied.add(new P<BookEntity>() {
      @Override
      public void apply(BookEntity target) {

        target.setAuthors(authors);
      }
    });
    return this;
  }

  /**
   * @param title the title to add.
   * @return the builder for fluent population of fields.
   */
  public BookEntityBuilder title(final String title) {

    this.parameterToBeApplied.add(new P<BookEntity>() {
      @Override
      public void apply(BookEntity target) {

        target.setTitle(title);
      }
    });
    return this;
  }

  /**
   * @param revision the revision to add.
   * @return the builder for fluent population of fields.
   */
  public BookEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<BookEntity>() {
      @Override
      public void apply(BookEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  /**
   * @return the populated BookEntity.
   */
  public BookEntity createNew() {

    BookEntity bookentity = new BookEntity();
    for (P<BookEntity> parameter : parameterToBeApplied) {
      parameter.apply(bookentity);
    }
    return bookentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @return the BookEntity
   */
  public BookEntity persist(EntityManager em) {

    BookEntity bookentity = createNew();
    em.persist(bookentity);
    return bookentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of BookEntity
   */
  public List<BookEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<BookEntity> bookentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      BookEntity bookentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(bookentity);
      bookentityList.add(bookentity);
    }

    return bookentityList;
  }

}
