package io.oasp.gastronomy.restaurant.general.service.impl.rest.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO jmolinar This type ...
 *
 * @author jmolinar
 * @since dev
 */
public class JaxrsCorrelationClientRequestFilter implements ClientRequestFilter {
  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(JaxrsCorrelationClientRequestFilter.class);

  @Override
  public void filter(ClientRequestContext requestContext) throws IOException {

    LOG.debug("DROSSEL This is " + JaxrsCorrelationClientRequestFilter.class.getName());
  }

}
