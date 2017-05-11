package io.oasp.gastronomy.restaurant.bookmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.Bookmanagement;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookEto;
import io.oasp.gastronomy.restaurant.bookmanagement.logic.api.to.BookSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.general.common.api.RestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Bookmanagement}.
 */
@Path("/bookmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BookmanagementRestService extends RestService {

  /**
   * Delegates to {@link Bookmanagement#findBook}.
   *
   * @param id the ID of the {@link BookEto}
   * @return the {@link BookEto}
   */
  @GET
  @Path("/book/{id}/")
  public BookEto getBook(@PathParam("id") long id);

  /**
   * Delegates to {@link Bookmanagement#saveBook}.
   *
   * @param book the {@link BookEto} to be saved
   * @return the recently created {@link BookEto}
   */
  @POST
  @Path("/book/")
  public BookEto saveBook(BookEto book);

  /**
   * Delegates to {@link Bookmanagement#deleteBook}.
   *
   * @param id ID of the {@link BookEto} to be deleted
   */
  @DELETE
  @Path("/book/{id}/")
  public void deleteBook(@PathParam("id") long id);

  /**
   * Delegates to {@link Bookmanagement#findBookEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding books.
   * @return the {@link PaginatedListTo list} of matching {@link BookEto}s.
   */
  @Path("/book/search")
  @POST
  public PaginatedListTo<BookEto> findBooksByPost(BookSearchCriteriaTo searchCriteriaTo);

}