package org.framework;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 'Interfaccia' per testing di Smart Contract.
 * Centralizza la connessione alla blockchain, gestione gas e gestione identità. 
*/
public class ContractTester {
    
    private final Web3j web3j;
    private final IdentityAuthenticator identityAuthenticator;
    private final StaticGasProvider gasProvider;
    private final TransactionHandler callsHandler;

    private Object contractInstance;
    private String contractAddress;
    private ContractFactory<?> contractFactory;


    /**
     * Interfaccia funzionale per istanziare qualsiasi contratto Web3j.
    */
    @FunctionalInterface
    public interface ContractFactory<T> {
        T create(String address, Web3j web3j, Credentials credentials, ContractGasProvider gasProvider);
    }


    /**
     * Inizializza l'ambiente di test collegandosi alla blockchain. 
     * @param RPC_url   : url della blockchain (es. "http://127.0.0.1:7545" o 8545).
    */
    public ContractTester(final String RPC_url) {
        this.web3j = Web3j.build(new HttpService(RPC_url));
        this.identityAuthenticator = new IdentityAuthenticator();
        this.gasProvider = new StaticGasProvider(
            DefaultGasProvider.GAS_PRICE,
            BigInteger.valueOf(6_721_975L)
        );
    
        TransactionHandler executor = new ExecutionHandler();
        this.callsHandler = new CheckGasHandler(executor, gasProvider);
    }

    // ----identityAuthenticator:----
    public void loadIdentity(final String roleName, final String privateKey) {
        this.identityAuthenticator.loadIdentity(roleName, privateKey);
    }

    /** Carica l'identity e aggiorna lo Smart Contract con nuove credenziali */
    public void useIdentity(final String roleName) {
        this.identityAuthenticator.setIdentity(roleName);

        // Rigenerazione contratto con nuove credenziali:
        if (this.contractFactory != null) {
            this.contractInstance = this.contractFactory.create(
                this.contractAddress,
                this.web3j,
                getActiveCredentials(),
                this.gasProvider
            );
        }

    }

    /**
     * Registra un qualsiasi Smart Contract nel framework.
     */
    public <T> void registerContract(String address, ContractFactory<T> factory) {
        this.contractAddress = address;
        this.contractFactory = factory;
        this.contractInstance = factory.create(address, web3j, getActiveCredentials(), gasProvider);
    }

    /**
     * Recupera l'istanza del contratto correntemente attiva e aggiornata.
     */
    @SuppressWarnings("unchecked")
    public <T> T getContract() {
        if (this.contractInstance == null) {
            throw new IllegalStateException("No contract registred. Use registerContract first.");
        }
        return (T) this.contractInstance;
    }


    // ----web3j: getters----
    public Web3j getWeb3j() {
        return web3j;
    }

    public Credentials getActiveCredentials() {
        return this.identityAuthenticator.getActiveCredentials();
    }

    public StaticGasProvider getGasProvider() {
        return gasProvider;
    }

    /**
     * Interfaccia funzionale per testing su CoR.
     * Dato che Web3j lancia sempre "Exception", la gestiamo per non 
     * sporcare il codice del test.
    */
    @FunctionalInterface
    public interface ContractCall {
        void execute() throws Exception;
    }

    /** Gestisce le require necessarie per testare la Business Logic.
     * @param call                  :  condition del require
     * @param expectedReason        : messaggio personalizzato di errore
    */
    public void assertRequireFails(ContractCall call, String expectedReason) {
        try {
            this.callsHandler.handleRequest(call, expectedReason);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    public void assertRequireFails(ContractCall call) {
        assertRequireFails(call, null);
    }

}