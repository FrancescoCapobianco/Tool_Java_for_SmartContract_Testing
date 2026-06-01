package org.framework;

import org.framework.ContractTester.ContractCall;

/**
 * Interface for Facade: CoR 
*/
public interface TransactionHandler {

    /**
     * Elabora le richieste contrattuali all'interno della catena.
     * @param call              : Chiamata alla SmartContract da eseguire.
     * @param expectedReason    : Motivo del revert atteso (null se test positivo).
    */
    void handleRequest(final ContractCall call, final String expectedReason) throws Exception;

}