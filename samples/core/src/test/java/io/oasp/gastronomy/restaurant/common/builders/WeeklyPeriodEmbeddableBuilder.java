package io.oasp.gastronomy.restaurant.common.builders;

import java.util.LinkedList;
import java.util.List;

import io.oasp.gastronomy.restaurant.offermanagement.common.api.datatype.DayOfWeek;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;

/**
 * Test data builder for WeeklyPeriodEmbeddable generated with cobigen.
 */
public class WeeklyPeriodEmbeddableBuilder {

  private List<P<WeeklyPeriodEmbeddable>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public WeeklyPeriodEmbeddableBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * @param startingDay the startingDay to add.
   * @return the builder for fluent population of fields.
   */
  public WeeklyPeriodEmbeddableBuilder startingDay(final DayOfWeek startingDay) {

    this.parameterToBeApplied.add(new P<WeeklyPeriodEmbeddable>() {
      @Override
      public void apply(WeeklyPeriodEmbeddable target) {

        target.setStartingDay(startingDay);
      }
    });
    return this;
  }

  /**
   * @param startingHour the startingHour to add.
   * @return the builder for fluent population of fields.
   */
  public WeeklyPeriodEmbeddableBuilder startingHour(final int startingHour) {

    this.parameterToBeApplied.add(new P<WeeklyPeriodEmbeddable>() {
      @Override
      public void apply(WeeklyPeriodEmbeddable target) {

        target.setStartingHour(startingHour);
      }
    });
    return this;
  }

  /**
   * @param endingDay the endingDay to add.
   * @return the builder for fluent population of fields.
   */
  public WeeklyPeriodEmbeddableBuilder endingDay(final DayOfWeek endingDay) {

    this.parameterToBeApplied.add(new P<WeeklyPeriodEmbeddable>() {
      @Override
      public void apply(WeeklyPeriodEmbeddable target) {

        target.setEndingDay(endingDay);
      }
    });
    return this;
  }

  /**
   * @param endingHour the endingHour to add.
   * @return the builder for fluent population of fields.
   */
  public WeeklyPeriodEmbeddableBuilder endingHour(final int endingHour) {

    this.parameterToBeApplied.add(new P<WeeklyPeriodEmbeddable>() {
      @Override
      public void apply(WeeklyPeriodEmbeddable target) {

        target.setEndingHour(endingHour);
      }
    });
    return this;
  }

  /**
   * @return the populated WeeklyPeriodEmbeddable.
   */
  public WeeklyPeriodEmbeddable createNew() {

    WeeklyPeriodEmbeddable weeklyperiodembeddable = new WeeklyPeriodEmbeddable();
    for (P<WeeklyPeriodEmbeddable> parameter : this.parameterToBeApplied) {
      parameter.apply(weeklyperiodembeddable);
    }
    return weeklyperiodembeddable;
  }

}
