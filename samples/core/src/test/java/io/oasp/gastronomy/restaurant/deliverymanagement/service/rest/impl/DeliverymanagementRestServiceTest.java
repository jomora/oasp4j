package io.oasp.gastronomy.restaurant.deliverymanagement.service.rest.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliverySearchCriteriaTo;
import io.oasp.gastronomy.restaurant.deliverymanagement.service.api.rest.DeliverymanagementRestService;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@TestPropertySource(properties = { "flyway.locations=filesystem:src/test/resources/db/tablemanagement" })
public class DeliverymanagementRestServiceTest extends AbstractRestServiceTest {

  private DeliverymanagementRestService service;

  @Override
  protected void doSetUp() {

    super.doSetUp();
    this.service = getRestTestClientBuilder().build(DeliverymanagementRestService.class, "waiter");
    getDbTestHelper().resetDatabase();
  }

  @Test
  public void write() {

    DeliveryEto eto = new DeliveryEto();
    eto.setAddress("Bikini Bottom");
    eto.setPrice(new Money(1.2));
    assertThat(eto.getId()).isNull();
    eto = this.service.saveDelivery(eto);
    assertThat(eto.getId()).isNotNull();
  }

  @Test
  public void readAll() {

    PaginatedListTo<DeliveryEto> findDeliverysByPost = this.service.findDeliverysByPost(new DeliverySearchCriteriaTo());
    assertThat(findDeliverysByPost.getResult()).isEmpty();
  }
}
