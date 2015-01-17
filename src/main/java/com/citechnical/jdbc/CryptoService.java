package com.citechnical.jdbc;

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
