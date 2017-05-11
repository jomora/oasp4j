package io.oasp.gastronomy.restaurant.offermanagement.logic.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.common.builders.SpecialEntityBuilder;
import io.oasp.gastronomy.restaurant.common.builders.WeeklyPeriodEmbeddableBuilder;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.datatype.DayOfWeek;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialEto;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.WeeklyPeriodEto;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.usecase.UcFindSpecial;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.usecase.UcManageSpecial;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author jmolinar
 *
 */
@SpringApplicationConfiguration(classes = { SpringBootApp.class, UcManageSpecial.class })
@Transactional
public class SpecialTest extends ComponentTest {

  @PersistenceContext
  EntityManager em;

  @Inject
  @Qualifier("milano")
  private UcManageSpecial ucManageSpecial;

  @Inject
  @Qualifier("milano")
  private UcFindSpecial ucFindSpecial;

  @Test
  public void builderTest() throws Exception {

    SpecialEntityBuilder builder = new SpecialEntityBuilder();
    builder.name("Roma Happy Hour").specialPrice(new Money(7.50)).offerId(1L).persist(this.em);
    builder.name("Firenze Happy Hour").specialPrice(new Money(7.50)).offerId(1L).persist(this.em);
    builder.name("Sin City Happy Hour").specialPrice(new Money(3.50)).offerId(1L).persist(this.em);

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    criteria.setSpecialPrice(new Money(7.50));
    PaginatedListTo<SpecialEto> findSpecialEtos = this.ucFindSpecial.findSpecialEtos(criteria);
    assertThat(findSpecialEtos.getResult()).hasSize(2);
  }

  @Test
  @Ignore
  public void testName() throws Exception {

    new SpecialEntityBuilder()
        .name("Cristobal").offerId(1L).specialPrice(new Money(1.99)).activePeriod(new WeeklyPeriodEmbeddableBuilder()
            .endingHour(1).startingHour(2).startingDay(DayOfWeek.MONDAY).endingDay(DayOfWeek.TUESDAY).createNew())
        .persist(this.em);

    PaginatedListTo<SpecialEto> findSpecialEtos = this.ucFindSpecial.findSpecialEtos(new SpecialSearchCriteriaTo());
    assertThat(findSpecialEtos.getResult()).isEmpty();

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

    SpecialEto saveSpecial = this.ucManageSpecial.saveSpecial(special);

    assertThat(special.getModificationCounter()).isEqualTo(saveSpecial.getModificationCounter() + 1);
  }
}
