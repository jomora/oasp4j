package io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Delivery
 */
public class DeliveryCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private DeliveryEto delivery;

  public DeliveryEto getDelivery() {

    return delivery;
  }

  public void setDelivery(DeliveryEto delivery) {

    this.delivery = delivery;
  }

}
