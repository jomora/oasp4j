package io.oasp.gastronomy.restaurant.general.service.impl.rest.interceptors;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;

/**
 * TODO jmolinar This type ...
 *
 * @author jmolinar
 * @since dev
 */
public class CxfCorrelationFeature extends AbstractFeature {

  @Override
  protected void initializeProvider(InterceptorProvider provider, Bus bus) {

    final InboundCorrelationInterceptor read = new InboundCorrelationInterceptor();
    final OutboundCorrelationInterceptor send = new OutboundCorrelationInterceptor();
    provider.getInInterceptors().add(read);
    provider.getOutInterceptors().add(send);
  }

}
