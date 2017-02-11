package io.oasp.gastronomy.restaurant.deliverymanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.DeliveryEntity;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase.UcManageDelivery;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.base.usecase.AbstractDeliveryUc;
import io.oasp.gastronomy.restaurant.general.logic.api.UseCase;

/**
 * Use case implementation for modifying and deleting Deliverys
 */
@Named
@UseCase
@Validated
@Transactional
public class UcManageDeliveryImpl extends AbstractDeliveryUc implements UcManageDelivery {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageDeliveryImpl.class);

  @Override
  public boolean deleteDelivery(Long deliveryId) {

    DeliveryEntity delivery = getDeliveryDao().find(deliveryId);
    getDeliveryDao().delete(delivery);
    LOG.debug("The delivery with id '{}' has been deleted.", deliveryId);
    return true;
  }

  @Override
  public DeliveryEto saveDelivery(DeliveryEto delivery) {

    Objects.requireNonNull(delivery, "delivery");

    DeliveryEntity deliveryEntity = getBeanMapper().map(delivery, DeliveryEntity.class);

    // initialize, validate deliveryEntity here if necessary

    getDeliveryDao().save(deliveryEntity);
    LOG.debug("Delivery with id '{}' has been created.", deliveryEntity.getId());
    return getBeanMapper().map(deliveryEntity, DeliveryEto.class);
  }
}
