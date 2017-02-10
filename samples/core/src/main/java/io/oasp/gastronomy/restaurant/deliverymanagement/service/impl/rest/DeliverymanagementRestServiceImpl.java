package io.oasp.gastronomy.restaurant.deliverymanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.Deliverymanagement;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.deliverymanagement.service.api.rest.DeliverymanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Deliverymanagement}.
 */
@Named("DeliverymanagementRestService")
public class DeliverymanagementRestServiceImpl implements DeliverymanagementRestService {

  @Inject
  private Deliverymanagement deliverymanagement;

  @Override
  public DeliveryEto getDelivery(long id) {

    return this.deliverymanagement.findDelivery(id);
  }

  @Override
  public DeliveryEto saveDelivery(DeliveryEto delivery) {

    return this.deliverymanagement.saveDelivery(delivery);
  }

  @Override
  public void deleteDelivery(long id) {

    this.deliverymanagement.deleteDelivery(id);
  }

  @Override
  public PaginatedListTo<DeliveryEto> findDeliverysByPost(DeliverySearchCriteriaTo searchCriteriaTo) {

    return this.deliverymanagement.findDeliveryEtos(searchCriteriaTo);
  }

}