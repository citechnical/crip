package com.citechnical.crypto.impl;

import com.citechnical.crypto.CryptoUtils;
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