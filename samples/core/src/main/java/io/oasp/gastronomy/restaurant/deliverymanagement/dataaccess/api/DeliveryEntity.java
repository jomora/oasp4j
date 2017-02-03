package io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.gastronomy.restaurant.deliverymanagement.common.api.Delivery;
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

  private Double price;

  private static final long serialVersionUID = 1L;

  @Override
  public String getAddress() {

    return this.address;
  }

  @Override
  public Double getPrice() {

    return this.price;
  }

}
