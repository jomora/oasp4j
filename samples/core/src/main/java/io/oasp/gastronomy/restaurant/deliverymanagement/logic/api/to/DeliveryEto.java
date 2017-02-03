package io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.deliverymanagement.common.api.Delivery;
import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Delivery
 */
public class DeliveryEto extends AbstractEto implements Delivery {

  private static final long serialVersionUID = 1L;

  private String address;

  private Double price;

  @Override
  public String getAddress() {

    return address;
  }

  @Override
  public void setAddress(String address) {

    this.address = address;
  }

  @Override
  public Double getPrice() {

    return price;
  }

  @Override
  public void setPrice(Double price) {

    this.price = price;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.address == null) ? 0 : this.address.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    DeliveryEto other = (DeliveryEto) obj;
    if (this.address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!this.address.equals(other.address)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    return true;
  }
}
