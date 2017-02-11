package io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.gastronomy.restaurant.deliverymanagement.common.api.Delivery}s.
 *
 */
public class DeliverySearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String address;

  private Money price;

  /**
   * The constructor.
   */
  public DeliverySearchCriteriaTo() {

    super();
  }

  public String getAddress() {

    return address;
  }

  public void setAddress(String address) {

    this.address = address;
  }

  public Money getPrice() {

    return price;
  }

  public void setPrice(Money price) {

    this.price = price;
  }

}
