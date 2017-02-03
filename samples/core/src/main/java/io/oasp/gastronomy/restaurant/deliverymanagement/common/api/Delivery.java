package io.oasp.gastronomy.restaurant.deliverymanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;

/**
 * TODO jmolinar This type ...
 *
 * @since dev
 */
public interface Delivery extends ApplicationEntity {

  String getAddress();

  Double getPrice();

  public void setAddress(String address);

  public void setPrice(Double price);

}
