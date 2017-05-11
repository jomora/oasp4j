package io.oasp.gastronomy.restaurant.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.datatype.DayOfWeek;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;

/**
 * Test data builder for SpecialEntity generated with cobigen.
 */
public class SpecialEntityBuilder {

  private List<P<SpecialEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public SpecialEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
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

    name("Milano Happy Hour").activePeriod(new WeeklyPeriodEmbeddableBuilder().startingHour(17).endingHour(21)
        .startingDay(DayOfWeek.TUESDAY).endingDay(DayOfWeek.FRIDAY).createNew()).specialPrice(new Money(1.99));
  }

  /**
   * @param comment the comment to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder comment(final String comment) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setComment(comment);
      }
    });
    return this;
  }

  /**
   * @param name the name to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder name(final String name) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setName(name);
      }
    });
    return this;
  }

  /**
   * @param offer the offer to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder offer(final OfferEntity offer) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setOffer(offer);
      }
    });
    return this;
  }

  /**
   * @param activePeriod the activePeriod to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder activePeriod(final WeeklyPeriod activePeriod) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setActivePeriod(activePeriod);
      }
    });
    return this;
  }

  /**
   * @param specialPrice the specialPrice to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder specialPrice(final Money specialPrice) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setSpecialPrice(specialPrice);
      }
    });
    return this;
  }

  /**
   * @param revision the revision to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  /**
   * @param offerId the offerId to add.
   * @return the builder for fluent population of fields.
   */
  public SpecialEntityBuilder offerId(final Long offerId) {

    this.parameterToBeApplied.add(new P<SpecialEntity>() {
      @Override
      public void apply(SpecialEntity target) {

        target.setOfferId(offerId);
      }
    });
    return this;
  }

  /**
   * @return the populated SpecialEntity.
   */
  public SpecialEntity createNew() {

    SpecialEntity specialentity = new SpecialEntity();
    for (P<SpecialEntity> parameter : this.parameterToBeApplied) {
      parameter.apply(specialentity);
    }
    return specialentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @return the SpecialEntity
   */
  public SpecialEntity persist(EntityManager em) {

    SpecialEntity specialentity = createNew();
    em.persist(specialentity);
    return specialentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of SpecialEntity
   */
  public List<SpecialEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<SpecialEntity> specialentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      SpecialEntity specialentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(specialentity);
      specialentityList.add(specialentity);
    }

    return specialentityList;
  }

}
