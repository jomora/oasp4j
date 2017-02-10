package io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.DeliveryEntity;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Delivery entities
 */
public interface DeliveryDao extends ApplicationDao<DeliveryEntity> {

  /**
   * Finds the {@link DeliveryEntity deliverys} matching the given {@link DeliverySearchCriteriaTo}.
   *
   * @param criteria is the {@link DeliverySearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link DeliveryEntity} objects.
   */
  PaginatedListTo<DeliveryEntity> findDeliverys(DeliverySearchCriteriaTo criteria);
}
