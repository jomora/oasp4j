package io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.gastronomy.restaurant.deliverymanagement.common.api.Delivery;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * TODO jmolinar This type ...
 *
 * @since dev
 */
@Entity
@Table(name = "Delivery")
public class DeliveryEntity extends ApplicationPersistenceEntity implements Delivery {

  private String address;

  private Money price;

  private static final long serialVersionUID = 1L;

  /**
   * @return address
   */
  @Override
  public String getAddress() {

    return this.address;
  }

  /**
   * @param address new value of {@link #getaddress}.
   */
  @Override
  public void setAddress(String address) {

    this.address = address;
  }

  /**
   * @return price
   */
  @Override
  public Money getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getprice}.
   */
  public void setPrice(Money price) {

    this.price = price;
  }

}
