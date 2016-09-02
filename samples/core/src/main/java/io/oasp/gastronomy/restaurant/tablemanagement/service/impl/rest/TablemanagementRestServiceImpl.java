package io.oasp.gastronomy.restaurant.tablemanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import net.sf.mmm.util.exception.api.ObjectNotFoundUserException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.gastronomy.restaurant.tablemanagement.common.api.Table;
import io.oasp.gastronomy.restaurant.tablemanagement.logic.api.Tablemanagement;
import io.oasp.gastronomy.restaurant.tablemanagement.logic.api.to.TableEto;
import io.oasp.gastronomy.restaurant.tablemanagement.logic.api.to.TableSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.tablemanagement.service.api.rest.TablemanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.logging.common.api.DiagnosticContextFacade;

/**
 * @author agreul, gazzi, jmolinar
 */
@Named("TablemanagementRestService")
public class TablemanagementRestServiceImpl implements TablemanagementRestService {

  @Inject
  private DiagnosticContextFacade diagnosticCtx;

  private Tablemanagement tableManagement;

  /**
   * This method sets the field <tt>tableManagement</tt>.
   *
   * @param tableManagement the new value of the field tableManagement
   */
  @Inject
  public void setTableManagement(Tablemanagement tableManagement) {

    this.tableManagement = tableManagement;
  }

  @Context
  private HttpHeaders headers;

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(TablemanagementRestServiceImpl.class);

  @Override
  public TableEto getTable(long id) {

    LOG.info("My correlation id: " + this.diagnosticCtx.getCorrelationId());
    return this.tableManagement.findTable(id);
  }

  @Override
  @Deprecated
  public List<TableEto> getAllTables() {

    List<TableEto> allTables = this.tableManagement.findAllTables();
    return allTables;
  }

  @Override
  @Deprecated
  public TableEto createTable(TableEto table) {

    return this.tableManagement.saveTable(table);
  }

  @Override
  public TableEto saveTable(TableEto table) {

    return this.tableManagement.saveTable(table);
  }

  @Override
  public void deleteTable(long id) {

    this.tableManagement.deleteTable(id);
  }

  @Override
  @Deprecated
  public List<TableEto> getFreeTables() {

    return this.tableManagement.findFreeTables();
  }

  @Override
  public boolean isTableReleasable(long id) {

    TableEto table = this.tableManagement.findTable(id);
    if (table == null) {
      throw new ObjectNotFoundUserException(Table.class, id);
    } else {
      return this.tableManagement.isTableReleasable(table);
    }
  }

  @Override
  public PaginatedListTo<TableEto> findTablesByPost(TableSearchCriteriaTo searchCriteriaTo) {

    return this.tableManagement.findTableEtos(searchCriteriaTo);
  }

  @Override
  public Response getTableAsResponse(long id) {

    LOG.info("Querying: {}", String.valueOf(id));
    Response response = Response.ok(this.tableManagement.findTable(id)).build();
    response.getHeaders().add("X-Correlation-Id", this.diagnosticCtx.getCorrelationId());
    return response;
  }
}
