package io.oasp.gastronomy.restaurant.common.builders;

import java.util.LinkedList;
import java.util.List;

import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.DeliveryEntity;

/**
 * Test data builder for DeliveryEntity generated with cobigen.
 */
public class DeliveryEntityBuilder {

  private List<P<DeliveryEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public DeliveryEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * @param address the address to add.
   * @return the builder for fluent population of fields.
   */
  public DeliveryEntityBuilder address(final String address) {

    this.parameterToBeApplied.add(new P<DeliveryEntity>() {
      @Override
      public void apply(DeliveryEntity target) {

        target.setAddress(address);
      }
    });
    return this;
  }

  /**
   * @param price the price to add.
   * @return the builder for fluent population of fields.
   */
  public DeliveryEntityBuilder price(final Double price) {

    this.parameterToBeApplied.add(new P<DeliveryEntity>() {
      @Override
      public void apply(DeliveryEntity target) {

        target.setPrice(price);
      }
    });
    return this;
  }

  /**
   * @return the populated DeliveryEntity.
   */
  public DeliveryEntity createNew() {

    DeliveryEntity deliveryentity = new DeliveryEntity();
    for (P<DeliveryEntity> parameter : parameterToBeApplied) {
      parameter.apply(deliveryentity);
    }
    return deliveryentity;
  }

}
