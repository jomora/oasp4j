package io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.usecase;

import javax.transaction.Transactional;

import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;

/**
 * Interface of UcManageDelivery to centralize documentation and signatures of methods.
 */
@Transactional
public interface UcManageDelivery {

  /**
   * Deletes a delivery from the database by its id 'deliveryId'.
   *
   * @param deliveryId Id of the delivery to delete
   * @return boolean <code>true</code> if the delivery can be deleted, <code>false</code> otherwise
   */
  boolean deleteDelivery(Long deliveryId);

  /**
   * Saves a delivery and store it in the database.
   *
   * @param delivery the {@link DeliveryEto} to create.
   * @return the new {@link DeliveryEto} that has been saved with ID and version.
   */
  DeliveryEto saveDelivery(DeliveryEto delivery);

}
