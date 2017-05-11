package io.oasp.gastronomy.restaurant.bookmanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;

public interface Book extends ApplicationEntity {

  public String getAuthors();

  public void setAuthors(String authors);

  public String getTitle();

  public void setTitle(String title);

}
