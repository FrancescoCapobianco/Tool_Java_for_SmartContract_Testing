package org.framework;

import org.framework.ContractTester.ContractCall;

/**
 * Chain of Responsibility: Catena Handler.
*/
interface TransactionHandler {

    /**
     * Elabora la richiesta di esecuzione all'interno della catena.
     * @param call              : Chiamata alla SmartContract da eseguire.
     * @param expectedReason    : Motivo del revert atteso (null se test positivo come valore atteso).
    */
    Object handleRequest(final ContractCall call, final String expectedReason) throws Exception;

}