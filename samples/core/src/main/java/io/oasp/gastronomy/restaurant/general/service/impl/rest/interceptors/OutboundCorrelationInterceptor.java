package io.oasp.gastronomy.restaurant.general.service.impl.rest.interceptors;

import java.util.Arrays;
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
public class OutboundCorrelationInterceptor extends AbstractPhaseInterceptor<Message> {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(OutboundCorrelationInterceptor.class);

  private static final String X_CORRELATION_ID = "X-Correlation-Id";

  private DiagnosticContextFacade dcf;

  /**
   * The constructor.
   *
   * @param phase
   */
  public OutboundCorrelationInterceptor(DiagnosticContextFacade dcf) {
    super(Phase.SEND);
    this.dcf = dcf;
  }

  @Override
  public void handleMessage(Message message) throws Fault {

    String correlationId = this.dcf.getCorrelationId();
    if (correlationId != null) {
      Object headers = message.getContextualProperty(Message.PROTOCOL_HEADERS);
      if (headers instanceof TreeMap<?, ?>) {
        ((TreeMap<String, List<String>>) message.getContextualProperty(Message.PROTOCOL_HEADERS)).put(X_CORRELATION_ID,
            Arrays.asList(correlationId));
      } else if (headers instanceof MultivaluedMap<?, ?>) {
        ((MultivaluedMap<String, String>) message.getContextualProperty(Message.PROTOCOL_HEADERS)).add(X_CORRELATION_ID,
            correlationId);
      }
    }
  }

}
