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


package com.citechnical;

import com.citechnical.crypto.CryptoUtils;
import com.citechnical.crypto.impl.AESCryptoService;
import com.citechnical.jdbc.mysql.MySQLCryptoService;

import javax.swing.*;

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/15/15
 *         time: 11:27 PM
 * @version CHANGEME
 */

public class EncryptDialog {

    public EncryptDialog() {
        initUI();
    }

    private void initUI() {

        JTextField key = new JTextField();
        JTextField password = new JTextField();
        Object[] message = {
            "Key:", key,
            "Password:", password
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Encrypt", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            MySQLCryptoService service = new MySQLCryptoService();
            AESCryptoService cryptoService = new AESCryptoService();
            String str1 = key.getText();
            String plainTextPassword = password.getText();
            byte[] encryptedPasswordBytes = cryptoService.encrypt(plainTextPassword);
            service.insertEncryptedPassword(str1, encryptedPasswordBytes);
        } else {
            System.out.println("Entry canceled");
        }
    }

}
