package io.oasp.gastronomy.restaurant.deliverymanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

/**
 * TODO jmolinar This type ...
 *
 * @since dev
 */
public interface Delivery extends ApplicationEntity {

  String getAddress();

  Money getPrice();

  public void setAddress(String address);

  public void setPrice(Money price);

}
