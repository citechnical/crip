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

package org.citechnical.crypto.impl;

import org.citechnical.crypto.CryptoUtils;
import junit.framework.TestCase;

public class AESCryptographyTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testEncrypt() throws Exception {
        AESCryptoService crypter = new AESCryptoService();
        String input = new String("David L. Whitehurst");
        byte[] encrypted = crypter.encrypt(input);

        assertNotNull(encrypted);
    }

    public void testDecrypt() throws Exception {
        AESCryptoService crypter = new AESCryptoService();
        String input = new String("David L. Whitehurst");
        byte[] encrypted = crypter.encrypt(input);
        String reverse = CryptoUtils.decodeUTF8(crypter.decrypt(encrypted));
        assertEquals("David L. Whitehurst", reverse);
    }
}