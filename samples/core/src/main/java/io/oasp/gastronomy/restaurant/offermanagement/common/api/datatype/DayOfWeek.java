package io.oasp.gastronomy.restaurant.offermanagement.common.api.datatype;

import java.util.Calendar;

/**
 * @author jmolinar
 *
 */
public enum DayOfWeek {
  MONDAY(Calendar.MONDAY), TUESDAY(Calendar.TUESDAY), WEDNESDAY(Calendar.WEDNESDAY), THURSDAY(
      Calendar.THURSDAY), FRIDAY(Calendar.FRIDAY), SATURDAY(Calendar.SATURDAY), SUNDAY(Calendar.SUNDAY);

  private int calendarRepresentation;

  private DayOfWeek(int calendarRepresentation) {

    this.calendarRepresentation = calendarRepresentation;
  }

  public int toCalendarDayOfWeek() {

    return this.calendarRepresentation;
  }

}
