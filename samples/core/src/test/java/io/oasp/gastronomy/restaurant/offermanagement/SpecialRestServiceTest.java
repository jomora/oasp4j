package io.oasp.gastronomy.restaurant.offermanagement;

import javax.inject.Inject;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;

import io.oasp.gastronomy.restaurant.Foo;
import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.datatype.DayOfWeek;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialEto;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.WeeklyPeriodEto;
import io.oasp.gastronomy.restaurant.offermanagement.service.api.rest.OffermanagementRestService;

/**
 * @author jmolinar
 *
 */
@SpringApplicationConfiguration(classes = { SpringBootApp.class })
@TestPropertySource(properties = { "flyway.locations=filesystem:src/test/resources/db/tablemanagement" })
public class SpecialRestServiceTest extends AbstractRestServiceTest {

  SoftAssertions softly = new SoftAssertions();

  @Inject
  Foo foo;

  @Test
  public void testName() throws Exception {

    OffermanagementRestService service = getRestTestClientBuilder().build(OffermanagementRestService.class, "waiter");
    SpecialEto special = new SpecialEto();
    special.setName("Jonas");
    special.setOfferId(1L);
    special.setSpecialPrice(new Money(1.99));

    WeeklyPeriod activePeriod = new WeeklyPeriodEto();
    activePeriod.setEndingDay(DayOfWeek.MONDAY);
    activePeriod.setStartingDay(DayOfWeek.SUNDAY);
    activePeriod.setEndingHour(21);
    activePeriod.setStartingHour(19);
    special.setActivePeriod(activePeriod);

    SpecialEto result = service.saveSpecial(special);
    this.softly.assertThat(result.getId()).isGreaterThan(100L);
    this.softly.assertThat(result).isNotNull();
    this.foo.bar();
  }

}
