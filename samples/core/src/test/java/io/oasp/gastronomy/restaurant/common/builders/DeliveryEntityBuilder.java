package io.oasp.gastronomy.restaurant.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.DeliveryEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

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
   * @param em the {@link EntityManager}
   * @return the DeliveryEntity
   */
  public DeliveryEntity persist(EntityManager em) {

    DeliveryEntity deliveryentity = createNew();
    em.persist(deliveryentity);
    return deliveryentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of DeliveryEntity
   */
  public List<DeliveryEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<DeliveryEntity> deliveryentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      DeliveryEntity deliveryentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(deliveryentity);
      deliveryentityList.add(deliveryentity);
    }

    return deliveryentityList;
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

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
  public DeliveryEntityBuilder price(final Money price) {

    this.parameterToBeApplied.add(new P<DeliveryEntity>() {
      @Override
      public void apply(DeliveryEntity target) {

        target.setPrice(price);
      }
    });
    return this;
  }

  /**
   * @param revision the revision to add.
   * @return the builder for fluent population of fields.
   */
  public DeliveryEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<DeliveryEntity>() {
      @Override
      public void apply(DeliveryEntity target) {

        target.setRevision(revision);
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
