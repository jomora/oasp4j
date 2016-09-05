package io.oasp.gastronomy.restaurant.general.service.impl.rest.interceptors;

import java.util.List;
import java.util.TreeMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.module.logging.common.api.DiagnosticContextFacade;

/**
 * TODO jmolinar This type ...
 *
 * @author jmolinar
 * @since dev
 */
public class InboundCorrelationInterceptor extends AbstractPhaseInterceptor<Message> {
  /**
  *
  */
  private static final String X_CORRELATION_ID = "X-Correlation-Id";

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(InboundCorrelationInterceptor.class);

  private DiagnosticContextFacade dcf;

  /**
   * The constructor.
   *
   * @param phase
   */
  public InboundCorrelationInterceptor(DiagnosticContextFacade dcf) {
    super(Phase.READ);
    this.dcf = dcf;

  }

  @Override
  public void handleMessage(Message message) throws Fault {

    Object headers = message.getContextualProperty(Message.PROTOCOL_HEADERS);
    String correlationId = null;
    if (headers instanceof TreeMap<?, ?>) {
      TreeMap<String, List<String>> asd = (TreeMap<String, List<String>>) headers;
      if (asd.get(X_CORRELATION_ID).size() > 1) {
        throw new Fault(new Exception("More than 1 X-Correlation-Id values available"));
      }
      for (String id : asd.get(X_CORRELATION_ID)) {
        LOG.debug("Incoming correlation id: {}", id);
        correlationId = id;
      }
    } else if (headers instanceof MultivaluedMap<?, ?>) {
      MultivaluedMap<String, String> asd = (MultivaluedMap<String, String>) headers;
      if (asd.get(X_CORRELATION_ID).size() > 1) {
        throw new Fault(new Exception("More than 1 X-Correlation-Id values available"));
      }
      for (String id : asd.get(X_CORRELATION_ID)) {
        LOG.debug("Incoming correlation id: {}", id);
        correlationId = id;
      }
    }
    if (correlationId != null && !correlationId.isEmpty()) {
      this.dcf.setCorrelationId(correlationId);
    }
  }

}
