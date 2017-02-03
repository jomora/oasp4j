package io.oasp.gastronomy.restaurant.deliverymanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.Deliverymanagement;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase.UcFindDelivery;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase.UcManageDelivery;
import io.oasp.gastronomy.restaurant.general.logic.base.AbstractComponentFacade;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of deliverymanagement
 */
@Named
public class DeliverymanagementImpl extends AbstractComponentFacade implements Deliverymanagement {

  @Inject
  private UcFindDelivery ucFindDelivery;

  @Inject
  private UcManageDelivery ucManageDelivery;

  /**
   * The constructor.
   */
  public DeliverymanagementImpl() {

    super();
  }

  @Override
  public DeliveryEto findDelivery(Long id) {

    return this.ucFindDelivery.findDelivery(id);
  }

  @Override
  public PaginatedListTo<DeliveryEto> findDeliveryEtos(DeliverySearchCriteriaTo criteria) {

    return this.ucFindDelivery.findDeliveryEtos(criteria);
  }

  @Override
  public DeliveryEto saveDelivery(DeliveryEto delivery) {

    return this.ucManageDelivery.saveDelivery(delivery);
  }

  @Override
  public boolean deleteDelivery(Long id) {

    return this.ucManageDelivery.deleteDelivery(id);
  }

}
