/******************************************************************************
 * Copyright (c) 2014,2015 CITechnical.org
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
 *    dlwhitehurst - David L. Whitehurst
 *
 *******************************************************************************
 */

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
