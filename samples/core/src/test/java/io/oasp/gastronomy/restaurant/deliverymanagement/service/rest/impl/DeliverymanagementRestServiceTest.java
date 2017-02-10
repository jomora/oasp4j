package io.oasp.gastronomy.restaurant.deliverymanagement.service.rest.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.deliverymanagement.logic.api.to.DeliveryEto;
import io.oasp.gastronomy.restaurant.deliverymanagement.service.api.rest.DeliverymanagementRestService;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@TestPropertySource(properties = { "flyway.locations=filesystem:src/test/resources/db/tablemanagement" })
public class DeliverymanagementRestServiceTest extends AbstractRestServiceTest {

  @Test
  public void test() {

    DeliveryEto eto = new DeliveryEto();
    eto.setAddress("Bikini Bottom");
    eto.setPrice(new Money(1.2));
    DeliverymanagementRestService service =
        getRestTestClientBuilder().build(DeliverymanagementRestService.class, "waiter");
    eto = service.saveDelivery(eto);
    assertThat(eto.getId()).isNotNull();
  }
}
