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


package org.citechnical.jdbc.mysql;

import org.citechnical.jdbc.CryptoService;

import java.sql.*;

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/16/15
 *         time: 8:44 PM
 * @version CHANGEME
 */

public class MySQLCryptoService implements CryptoService {

    /**
     * This method persists an encrypted password using a string key for retrieval.
     *
     * @param key
     * @param encryptedPassword
     */
    @Override
    public void insertEncryptedPassword(String key, byte[] encryptedPassword) {
        Blob blob = null;
        try {
            blob = new javax.sql.rowset.serial.SerialBlob(encryptedPassword);
            MySQLConnectJDBC connection = new MySQLConnectJDBC();
            String insertTableSQL = "INSERT INTO authentication_credentials"
        		+ "(`key`, `encrypted`) VALUES"
        		+ "(?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.getConnection().prepareStatement(insertTableSQL);
            preparedStatement.setString(1, key);
            preparedStatement.setBlob(2, blob);
            preparedStatement .executeUpdate();
            connection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Inserted authentication_credentials row into the table...");

    }

    /**
     * This method pulls an encrypted password from the database using a string
     * key and into a byte-array.
     *
     * @param key
     * @return
     */
    @Override
    public byte[] getEncryptedPassword(String key) {
        MySQLConnectJDBC connection = new MySQLConnectJDBC();
        byte[] result = null;
        try {
            String sql = "SELECT `encrypted` FROM `authentication_credentials` WHERE `key` = '" + key + "'";
            Statement stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            Blob blob = null;
            if (rs != null) {
                while (rs.next()) {
                    blob = rs.getBlob("encrypted");
                    count++;
                }
            }
            if (blob != null && count == 1) {
                long length = blob.length();
                result = blob.getBytes(1, (int) length);
            } else {
                return new byte[0];
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
