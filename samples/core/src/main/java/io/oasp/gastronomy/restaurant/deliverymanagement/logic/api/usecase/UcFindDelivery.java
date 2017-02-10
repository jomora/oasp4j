package io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase;

import java.util.List;

import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindDelivery {

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

}
