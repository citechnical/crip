package org.citechnical.crypto;

/**
 * Class description goes here ...
 *
 * @author <a href="mailto:dlwhitehurst@gmail.com">David L. Whitehurst</a>
 *         created: 1/16/15
 *         time: 7:42 AM
 * @version CHANGEME
 */

public interface Cryptography {
    /**
     *
     * @param value
     * @return
     */
    public byte[] encrypt(String value);

    /**
     *
     * @param encrypted
     * @return
     */
    public byte[] decrypt(byte[] encrypted);

}
