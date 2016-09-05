package io.oasp.gastronomy.restaurant.general.service.impl.rest.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.oasp.module.logging.common.api.DiagnosticContextFacade;

/**
 * TODO jmolinar This type ...
 *
 * @author jmolinar
 * @since dev
 */
@Component
@Provider
public class JaxrsCorrelationContainerResponseFilter implements ContainerResponseFilter {

  /**
   *
   */
  private static final String X_CORRELATION_ID = "X-Correlation-Id";

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(JaxrsCorrelationContainerResponseFilter.class);

  @Inject
  @Qualifier("container")
  private DiagnosticContextFacade diagnosticCtx;

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
      throws IOException {

    String correlationId = this.diagnosticCtx.getCorrelationId();
    LOG.info("MOSSEL MOSSEL correlation id: " + correlationId + this.getClass().getName());
    responseContext.getHeaders().add(X_CORRELATION_ID, correlationId);
  }

}
