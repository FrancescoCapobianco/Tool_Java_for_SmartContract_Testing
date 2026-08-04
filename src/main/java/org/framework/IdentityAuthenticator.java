package org.framework;

import org.web3j.crypto.Credentials;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestisce il pool di Identità per l'ambiente di testing.
 * Permette di mappare i nomi logici alle chiavi private,
 * necessarie per firmare le transazioni.
*/
class IdentityAuthenticator {

    private final Map<String, Credentials> identityPool;
    private String currentIdentity;

    public IdentityAuthenticator() {
        identityPool = new HashMap<>();
        this.currentIdentity = null;
    }

    /**
     * Carica una nuova identità nel pool.
     * @param roleName      : nome logico x testing
     * @param privateKey    : chiavi private
    */
    public void loadIdentity(final String roleName, final String privateKey) {

        Credentials credentials = Credentials.create(privateKey);
        identityPool.put(roleName, credentials);

        if (currentIdentity == null)
            currentIdentity = roleName;
    }

    /**
     * Cambia il chiamante delle transazioni.
     * @param roleName      : nome identità da usare
    */
    public void setIdentity(final String roleName) {
        if (!identityPool.containsKey(roleName))
            throw new IllegalArgumentException("Identity not founded inside the pool: " + roleName);

        this.currentIdentity = roleName;
    }

    /**
     * Restituisce le credenziali dell'identità attualmente attiva.
    */
    public Credentials getActiveCredentials() {
        if (currentIdentity == null)
            throw new IllegalStateException("Empty current identity. load an identity before sending transactions");
    
        return identityPool.get(currentIdentity);
    }

    /**
     * Restituisce il nome logico dell'indirizzo attivo. 
    */
    public String getCurrentIdentity() {
        return currentIdentity;
    }
    
}