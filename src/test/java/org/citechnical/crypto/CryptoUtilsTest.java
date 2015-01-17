package org.citechnical.crypto;

import junit.framework.TestCase;

import java.io.UnsupportedEncodingException;

public class CryptoUtilsTest extends TestCase {

    public void testDecodeUTF8() throws Exception {
        String string = "\u0048\u0065\u006C\u006C\u006F World";
        boolean over = true;
        byte[] bytes = null;

        try {
            bytes = string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        String result = CryptoUtils.decodeUTF8(bytes);

        assertEquals("Hello World", result);
    }

    public void testEncodeUTF8() throws Exception {

        String string = "\u0048\u0065\u006C\u006C\u006F World";
        byte[] bytes = CryptoUtils.encodeUTF8(string);
        assertNotNull(bytes);

    }

    public void testToHex() throws Exception {

    }

    public void testToHex1() throws Exception {

    }

    public void testCreateKeyForAES() throws Exception {

    }

    public void testCreateCtrIvForAES() throws Exception {

    }

    public void testToString() throws Exception {

    }

    public void testToString1() throws Exception {

    }

    public void testToByteArray() throws Exception {

    }
}