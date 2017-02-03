package io.oasp.gastronomy.restaurant.deliverymanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.gastronomy.restaurant.general.logic.base.AbstractUc;

/**
 * Abstract use case for Deliverys, which provides access to the commonly necessary data access objects.
 */
public class AbstractDeliveryUc extends AbstractUc {

  /** @see #getDeliveryDao() */
  @Inject
  private DeliveryDao deliveryDao;

  /**
   * Returns the field 'deliveryDao'.
   * 
   * @return the {@link DeliveryDao} instance.
   */
  public DeliveryDao getDeliveryDao() {

    return this.deliveryDao;
  }

}
