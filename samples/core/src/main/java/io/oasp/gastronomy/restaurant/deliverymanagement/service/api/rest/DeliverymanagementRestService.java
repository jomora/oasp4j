package io.oasp.gastronomy.restaurant.deliverymanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.Deliverymanagement;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Deliverymanagement}.
 */
@Path("/deliverymanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DeliverymanagementRestService {

  /**
   * Delegates to {@link Deliverymanagement#findDelivery}.
   *
   * @param id the ID of the {@link DeliveryEto}
   * @return the {@link DeliveryEto}
   */
  @GET
  @Path("/delivery/{id}/")
  public DeliveryEto getDelivery(@PathParam("id") long id);

  /**
   * Delegates to {@link Deliverymanagement#saveDelivery}.
   *
   * @param delivery the {@link DeliveryEto} to be saved
   * @return the recently created {@link DeliveryEto}
   */
  @POST
  @Path("/delivery/")
  public DeliveryEto saveDelivery(DeliveryEto delivery);

  /**
   * Delegates to {@link Deliverymanagement#deleteDelivery}.
   *
   * @param id ID of the {@link DeliveryEto} to be deleted
   */
  @DELETE
  @Path("/delivery/{id}/")
  public void deleteDelivery(@PathParam("id") long id);

  /**
   * Delegates to {@link Deliverymanagement#findDeliveryEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding deliverys.
   * @return the {@link PaginatedListTo list} of matching {@link DeliveryEto}s.
   */
  @Path("/delivery/search")
  @POST
  public PaginatedListTo<DeliveryEto> findDeliverysByPost(DeliverySearchCriteriaTo searchCriteriaTo);

}