package io.oasp.gastronomy.restaurant.deliverymanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.DeliveryEntity;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase.UcFindDelivery;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.base.usecase.AbstractDeliveryUc;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Deliverys
 */
@Named
@UseCase
@Validated
public class UcFindDeliveryImpl extends AbstractDeliveryUc implements UcFindDelivery {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindDeliveryImpl.class);

  @Override
  public DeliveryEto findDelivery(Long id) {

    LOG.debug("Get Delivery with id {} from database.", id);
    return getBeanMapper().map(getDeliveryDao().findOne(id), DeliveryEto.class);
  }

  @Override
  public PaginatedListTo<DeliveryEto> findDeliveryEtos(DeliverySearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<DeliveryEntity> deliverys = getDeliveryDao().findDeliverys(criteria);
    return mapPaginatedEntityList(deliverys, DeliveryEto.class);
  }

}
