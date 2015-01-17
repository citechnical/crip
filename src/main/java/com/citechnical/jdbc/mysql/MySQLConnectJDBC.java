/******************************************************************************
 * Copyright (c) 2014,2015 Contributors - see below
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/LICENSE-2.0.html
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific 
 * language governing permissions and limitations under the 
 * License.
 *
 * Contributors:
 *    dlwhitehurst 
 *
 *******************************************************************************
 */


package com.citechnical.jdbc.mysql;

import com.citechnical.jdbc.ConnectJDBC;

import java.sql.*;

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/16/15
 *         time: 8:38 PM
 * @version CHANGEME
 */

public class MySQLConnectJDBC implements ConnectJDBC {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/security";

    static final String USER = "root";
    static final String PASS = "";

    private Connection conn = null;

    public MySQLConnectJDBC() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("[INFO]:Initializing database connection...");
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public void closeConnection() throws SQLException {
        conn.close();
        conn = null;
    }
}
