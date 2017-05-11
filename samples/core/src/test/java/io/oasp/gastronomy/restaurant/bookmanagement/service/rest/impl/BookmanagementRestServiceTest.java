package io.oasp.gastronomy.restaurant.bookmanagement.service.rest.impl;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookEto;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.bookmanagement.service.api.rest.BookmanagementRestService;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * @author jmolinar
 *
 */
@SpringApplicationConfiguration(classes = SpringBootApp.class)
// @TestPropertySource(properties = { "flyway.locations=filesystem:src/test/resources/db/tablemanagement" })
public class BookmanagementRestServiceTest extends AbstractRestServiceTest {

  private SoftAssertions softly = new SoftAssertions();

  private BookmanagementRestService service;

  /**
   * Provides initialization previous to the creation of the text fixture.
   */
  @Override
  public void doSetUp() {

    super.doSetUp();
    getDbTestHelper().resetDatabase();
    this.service = getRestTestClientBuilder().build(BookmanagementRestService.class, "waiter");

  }

  /**
   * Provides clean up after tests.
   */
  @Override
  public void doTearDown() {

    this.service = null;
    super.doTearDown();
  }

  @Test
  public void testName() throws Exception {

    BookEto data = new BookEto();
    data.setAuthors("Michael Ende");
    data.setTitle("Never Ending Story");
    BookEto actual = this.service.saveBook(data);
    this.softly.assertThat(actual.getTitle()).isEqualTo(data.getTitle());
    this.softly.assertThat(actual.getAuthors()).isEqualTo(data.getAuthors());
    this.softly.assertAll();
  }

  @Test
  public void testDb() {

    BookEto data = new BookEto();
    data.setAuthors("Michael Ende");
    data.setTitle("Never Ending Story");
    data.setId(123L);
    data.setModificationCounter(0);

    BookSearchCriteriaTo searchCriteriaTo = new BookSearchCriteriaTo();

    PaginatedListTo<BookEto> findBooksByPost = this.service.findBooksByPost(searchCriteriaTo);
    assertThat(findBooksByPost.getResult()).contains(data);

  }
}
