package io.oasp.gastronomy.restaurant.general.service.impl.rest.interceptors;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;

import io.oasp.module.logging.common.api.DiagnosticContextFacade;

/**
 * TODO jmolinar This type ...
 *
 * @author jmolinar
 * @since dev
 */
public class CxfCorrelationFeature extends AbstractFeature {
  /**
   *
   */
  private DiagnosticContextFacade dcf;

  /**
   * The constructor.
   *
   * @param dcf
   */
  public CxfCorrelationFeature(DiagnosticContextFacade dcf) {
    super();
    // REVIEW is this good style?
    if (dcf == null) {
      throw new IllegalStateException("DiagnosticContextFacade must not be null!");
    }
    this.dcf = dcf;
  }

  @Override
  protected void initializeProvider(InterceptorProvider provider, Bus bus) {

    final InboundCorrelationInterceptor read = new InboundCorrelationInterceptor(this.dcf);
    final OutboundCorrelationInterceptor send = new OutboundCorrelationInterceptor(this.dcf);
    provider.getInInterceptors().add(read);
    provider.getOutInterceptors().add(send);
  }

}
