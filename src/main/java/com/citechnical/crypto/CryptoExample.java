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


package com.citechnical.crypto;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/16/15
 *         time: 7:56 AM
 * @version CHANGEME
 */

public class CryptoExample {
    //private IvParameterSpec ivSpec;
    //private SecretKeySpec keySpec;
    //private Cipher cipher;
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    private static String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    private static byte[] encodeUTF8(String string) {
        return string.getBytes(UTF8_CHARSET);
    }

    public static void main(String[] args) throws Exception {
        CryptoExample e = new CryptoExample();
        String input = new String("john doe");
        System.out.println("The unencrypted input is: " + input);
        byte[] eArray = e.encrypt(input);
        byte[] dArray = e.decrypt(eArray);
        String check;
        check = decodeUTF8(dArray);
        System.out.println("The unencrypted result is:" + check);
    }

    public static byte[] encrypt(String value) {
        byte[] encrypted = null;
        try {

            byte[] raw = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
            Key skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] iv = new byte[cipher.getBlockSize()];

            IvParameterSpec ivParams = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParams);
            encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string:" + encrypted.length);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encrypted;
    }

    public static byte[] decrypt(byte[] encrypted) {
        byte[] original = null;
        Cipher cipher = null;
        try {
            byte[] raw = new byte[]{'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
            Key key = new SecretKeySpec(raw, "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //the block size (in bytes), or 0 if the underlying algorithm is not a block cipher
            byte[] ivByte = new byte[cipher.getBlockSize()];
            //This class specifies an initialization vector (IV). Examples which use
            //IVs are ciphers in feedback mode, e.g., DES in CBC mode and RSA ciphers with OAEP encoding operation.
            IvParameterSpec ivParamsSpec = new IvParameterSpec(ivByte);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParamsSpec);
            original = cipher.doFinal(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return original;
    }
}

