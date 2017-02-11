package io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.DeliveryEntity;
import io.oasp.gastronomy.restaurant.deliverymanagement.dataaccess.api.dao.DeliveryDao;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link DeliveryDao}.
 */
@Named
public class DeliveryDaoImpl extends ApplicationDaoImpl<DeliveryEntity> implements DeliveryDao {

  /**
   * The constructor.
   */
  public DeliveryDaoImpl() {

    super();
  }

  @Override
  public Class<DeliveryEntity> getEntityClass() {

    return DeliveryEntity.class;
  }

  @Override
  public PaginatedListTo<DeliveryEntity> findDeliverys(DeliverySearchCriteriaTo criteria) {

    DeliveryEntity delivery = Alias.alias(DeliveryEntity.class);
    EntityPathBase<DeliveryEntity> alias = Alias.$(delivery);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String address = criteria.getAddress();
    if (address != null) {
      query.where(Alias.$(delivery.getAddress()).eq(address));
    }
    Money price = criteria.getPrice();
    if (price != null) {
      query.where(Alias.$(delivery.getPrice()).eq(price));
    }
    return findPaginated(criteria, query, alias);
  }

}