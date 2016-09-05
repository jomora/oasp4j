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
import org.slf4j.MDC;

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

  /**
   * The constructor.
   *
   * @param phase
   */
  public OutboundCorrelationInterceptor() {
    super(Phase.SEND);
  }

  @Override
  public void handleMessage(Message message) throws Fault {

    String correlationId = MDC.get(X_CORRELATION_ID);
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
