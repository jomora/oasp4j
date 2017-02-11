package io.oasp.gastronomy.restaurant.deliverymanagement.logic.api;

import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase.UcFindDelivery;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase.UcManageDelivery;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Deliverymanagement component.
 */
public interface Deliverymanagement extends UcFindDelivery, UcManageDelivery {

  /**
   * Returns a Delivery by its id 'id'.
   *
   * @param id The id 'id' of the Delivery.
   * @return The {@link DeliveryEto} with id 'id'
   */
  DeliveryEto findDelivery(Long id);

  /**
   * Returns a paginated list of Deliverys matching the search criteria.
   *
   * @param criteria the {@link DeliverySearchCriteriaTo}.
   * @return the {@link List} of matching {@link DeliveryEto}s.
   */
  PaginatedListTo<DeliveryEto> findDeliveryEtos(DeliverySearchCriteriaTo criteria);

  /**
   * Deletes a delivery from the database by its id 'deliveryId'.
   *
   * @param deliveryId Id of the delivery to delete
   * @return boolean <code>true</code> if the delivery can be deleted, <code>false</code> otherwise
   */
  boolean deleteDelivery(Long deliveryId);

  /**
   * Saves a delivery and store it in the database.
   *
   * @param delivery the {@link DeliveryEto} to create.
   * @return the new {@link DeliveryEto} that has been saved with ID and version.
   */
  DeliveryEto saveDelivery(DeliveryEto delivery);

}
