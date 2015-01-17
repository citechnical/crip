package org.citechnical.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/16/15
 *         time: 8:37 PM
 * @version CHANGEME
 */

public interface ConnectJDBC {

    public Connection getConnection() throws SQLException;

    public void closeConnection() throws SQLException;
}
