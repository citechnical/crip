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

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/16/15
 *         time: 8:43 PM
 * @version CHANGEME
 */

public interface CryptoService {

    /**
     * This method persists an encrypted password using a string key for retrieval.
     * @param key
     * @param encryptedPassword
     */
    public void insertEncryptedPassword(String key, byte[] encryptedPassword);

    /**
     * This method pulls an encrypted password from the database using a string
     * key and into a byte-array.
     * @param key
     * @return
     */
    public byte[] getEncryptedPassword(String key);
}
