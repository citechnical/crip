package com.citechnical.crypto.impl;

import junit.framework.TestCase;

import java.nio.charset.Charset;

public class AESCryptographyTest extends TestCase {

    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    private static String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testEncrypt() throws Exception {
        AESCryptography crypter = new AESCryptography();
        String input = new String("David L. Whitehurst");
        byte[] encrypted = crypter.encrypt(input);

        assertNotNull(encrypted);
    }

    public void testDecrypt() throws Exception {
        AESCryptography crypter = new AESCryptography();
        String input = new String("David L. Whitehurst");
        byte[] encrypted = crypter.encrypt(input);
        String reverse = decodeUTF8(crypter.decrypt(encrypted));
        assertEquals("David L. Whitehurst", reverse);
    }
}