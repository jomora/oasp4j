package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Offer;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;

/**
 * The {@link ApplicationPersistenceEntity persistent entity} for a special.
 *
 * @author mbrunnli
 */
@Entity(name = "Special")
@Table(name = "Special")
public class SpecialEntity extends ApplicationPersistenceEntity implements Special {

  private String name;

  private String comment;

  private OfferEntity offer;

  private WeeklyPeriodEmbeddable activePeriod;

  private Money specialPrice;

  private static final long serialVersionUID = 1L;

  /**
   * @return comment
   */
  public String getComment() {

    return this.comment;
  }

  /**
   * @param comment new value of {@link #getcomment}.
   */
  public void setComment(String comment) {

    this.comment = comment;
  }

  /**
   * Returns the name of the {@link Special}.
   *
   * @return name the name of the {@link Special}.
   */
  @Column(unique = true)
  public String getName() {

    return this.name;
  }

  /**
   * Sets the name of the special.
   *
   * @param name the name of the special.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * Returns the {@link Offer} this special applies for.
   *
   * @return offer {@link Offer} this special applies for.
   */
  @ManyToOne
  public OfferEntity getOffer() {

    return this.offer;
  }

  /**
   * Sets the {@link Offer} this special applies for.
   *
   * @param offer the {@link Offer} this special applies for.
   */
  public void setOffer(OfferEntity offer) {

    this.offer = offer;
  }

  /**
   * Returns the {@link WeeklyPeriodEmbeddable active period} this special applies for.
   *
   * @return activePeriod the {@link WeeklyPeriodEmbeddable active period} this special applies for.
   */
  @Embedded
  public WeeklyPeriodEmbeddable getActivePeriod() {

    return this.activePeriod;
  }

  /**
   * Sets the {@link WeeklyPeriodEmbeddable active period} this special applies for.
   *
   * @param activePeriod the {@link WeeklyPeriodEmbeddable active period} this special applies for.
   */
  public void setActivePeriod(WeeklyPeriod activePeriod) {

    this.activePeriod = (WeeklyPeriodEmbeddable) activePeriod;
  }

  /**
   * Returns the new {@link Money special price} for the {@link Offer}.
   *
   * @return specialPrice the new {@link Money special price} for the {@link Offer}.
   */
  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  /**
   * Sets the new {@link Money special price} for the {@link Offer}.
   *
   * @param specialPrice the new {@link Money special price} for the {@link Offer}.
   */
  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

  /**
   * {@inheritDoc}
   */
  @Transient
  public Long getOfferId() {

    if (this.offer == null) {
      return null;
    }
    return this.offer.getId();
  }

  /**
   * {@inheritDoc}
   */
  public void setOfferId(Long offerId) {

    if (offerId == null) {
      this.offer = null;
    } else {
      OfferEntity offerEntity = new OfferEntity();
      offerEntity.setId(offerId);
      this.offer = offerEntity;
    }
  }

}
