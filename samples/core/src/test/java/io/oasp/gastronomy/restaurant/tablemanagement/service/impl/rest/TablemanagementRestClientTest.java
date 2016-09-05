package io.oasp.gastronomy.restaurant.tablemanagement.service.impl.rest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;
import io.oasp.gastronomy.restaurant.general.service.impl.rest.filter.JaxrsCorrelationClientRequestFilter;
import io.oasp.gastronomy.restaurant.tablemanagement.common.api.datatype.TableState;
import io.oasp.gastronomy.restaurant.tablemanagement.logic.api.to.TableEto;
import io.oasp.gastronomy.restaurant.tablemanagement.service.api.rest.TablemanagementRestService;
import io.oasp.module.logging.common.api.DiagnosticContextFacade;
import io.oasp.module.logging.common.impl.DiagnosticContextFacadeImpl;

/**
 * TODO jmolinar This type ...
 *
 * @author jmolinar
 * @since dev
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootApp.class)
@TestPropertySource(properties = { "flyway.locations=filesystem:src/test/resources/db/tablemanagement" })
public class TablemanagementRestClientTest extends AbstractRestServiceTest {

  /**
   *
   */
  private static final String X_CORRELATION_ID = "X-Correlation-Id";

  private TablemanagementRestService service;

  /**
   * Provides initialization previous to the creation of the text fixture.
   */
  @Before
  public void init() {

    getDbTestHelper().resetDatabase();
    this.service = getRestTestClientBuilder().build(TablemanagementRestService.class);

  }

  /**
   * Provides clean up after tests.
   */
  @After
  public void clean() {

    this.service = null;

  }

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(TablemanagementRestClientTest.class);

  //
  // @Test
  // public void testCxfClient() {
  //
  // WebClient webClient = WebClient.create(getRestTestClientBuilder().createRestServiceUrl(),
  // Collections.singletonList(new JacksonJsonProvider()));
  //
  // String payload = "waiter" + ":" + "waiter";
  // String authorizationHeader = "Basic " + Base64Utility.encode(payload.getBytes());
  // MultivaluedMap<String, String> map = webClient.getHeaders();
  // assertThat(map).isNotNull();
  // map.put("Authorization", Arrays.asList(authorizationHeader));
  // TableEto table = webClient.path("/tablemanagement/v1/table/101").accept(MediaType.APPLICATION_JSON)
  // .type(MediaType.APPLICATION_JSON).headers(map).get(TableEto.class);
  //
  // assertThat(table).isNotNull();
  // // Client client = ClientProxy.getClient(this.service);
  // MultivaluedMap<String, String> headers = WebClient.client(webClient).getHeaders();
  // assertThat(headers).isNotNull();
  // LOG.info("WebClient: TPIC:" + headers);
  //
  // }

  @Test
  public void testJaxrsProxyClient() {

    TablemanagementRestService tmpService = this.service;
    // TablemanagementRestService tmpService;
    long id = 101L;
    TableEto table = tmpService.getTable(id);
    assertThat(table).isNotNull();
    // Client client = ClientProxy.getClient(this.service);
    Response response = WebClient.client(tmpService).getResponse();
    assertThat(response).isNotNull();
    String correlationId = extractAndVerifyCorrelationIdHeader(response);

    table.setState(TableState.OCCUPIED);

    table = tmpService.getTable(id);
    assertThat(table).isNotNull();
    Response secondResponse = WebClient.client(tmpService).getResponse();
    String secondCorrelationId = extractAndVerifyCorrelationIdHeader(secondResponse);
    assertThat(correlationId).isEqualTo(secondCorrelationId);

  }

  @Test
  public void testJaxrsClient() {

    String resourcePath = "/tablemanagement/v1/table/test/101";

    MultivaluedMap<String, Object> map = createAuthorization();

    // First request
    Client client = ClientBuilder.newClient();
    client.register(JacksonJsonProvider.class).register(JaxrsCorrelationClientRequestFilter.class);
    Response response = client.target(getRestTestClientBuilder().createRestServiceUrl() + resourcePath)
        .request(MediaType.APPLICATION_JSON).headers(map).get();
    String correlationId = extractAndVerifyCorrelationIdHeader(response);

    // Second request
    // Create copy of initial headers
    MultivaluedMap<String, Object> requestHeaders = new MultivaluedHashMap<>(map);
    requestHeaders.add(X_CORRELATION_ID, correlationId);
    Response secondResponse = client.target(getRestTestClientBuilder().createRestServiceUrl() + resourcePath)
        .request(MediaType.APPLICATION_JSON).headers(requestHeaders).get();
    String secondCorrelationId = extractAndVerifyCorrelationIdHeader(secondResponse);
    assertThat(correlationId).isEqualTo(secondCorrelationId);
  }

  /**
   * @param response
   * @return
   */
  private String extractAndVerifyCorrelationIdHeader(Response response) {

    List<Object> correlationIdList = response.getHeaders().get(X_CORRELATION_ID);
    assertThat(correlationIdList).isNotNull().hasSize(1);
    String correlationId = correlationIdList.get(0) instanceof String ? (String) correlationIdList.get(0) : null;
    assertThat(correlationId).isNotNull();
    assertThat(correlationId).isNotEmpty();
    return correlationId;
  }

  /**
   * @return
   */
  private MultivaluedMap<String, Object> createAuthorization() {

    String payload = "waiter" + ":" + "waiter";
    String authorizationHeader = "Basic " + Base64Utility.encode(payload.getBytes());
    MultivaluedMap<String, Object> map = new MultivaluedHashMap<>();
    assertThat(map).isNotNull();
    map.put("Authorization", Arrays.asList((Object) authorizationHeader));
    return map;
  }

  @Configuration
  public static class DiagnosticContextFacadeProvider {
    @org.springframework.beans.factory.annotation.Qualifier("client")
    @Bean
    public DiagnosticContextFacade diagnosticContextFacade() {

      return new DiagnosticContextFacadeImpl();
    }
  }
}
