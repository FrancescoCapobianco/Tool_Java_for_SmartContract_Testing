// Test su: SecureVault, SimpleStorage (istanza ganache: JUnit-javaToBlockchain)

import org.framework.ContractTester;
import org.framework.contracts.SimpleStorage;
import org.framework.contracts.SecureVault;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.DisplayNameGenerator.Simple;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

/** Test in esecuzione per mantenere coerente stato blockchain */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class appTest {

    private static ContractTester ctEnv;

    private static final String SIMPLE_STORAGE_ADDR = "0xc961881F395e8758Ab9D00C425FbBA0c63941B3e";
    private static final String SECURE_VAULT_ADDR = "0x285D6D4fCefEe09B3d14454646229AF22C00e526";

    @BeforeAll
    static void setup(){

        ctEnv = new ContractTester("http://127.0.0.1:7545");

        ctEnv.loadIdentity("AdminVault", "0x39fedbba8a681231f49e4e9f4d638f559e11ae1222ed18a95f1e0d9c048d5240");         // 0
        ctEnv.loadIdentity("AdminStorage", "0x81fd6340b100137ed08fc08d9fe7878336f45823bbc53664e018ccba5599027d");       // 2
        ctEnv.loadIdentity("Common User", "0xd5b231e9b047277b512c090f89c7a32a9d32ae90b3fe0750a4d9822bba385c56");        // 8
        ctEnv.loadIdentity("Unauthorized User", "0xd8c9e76c87989064e5f4fe7a4efb7c8e89f79d2c6f9f1d3c9f08e3bfaa840093");  // 9

        ctEnv.useIdentity("AdminVault");

    }

    /** Checking RBAC Conditions */
    @Test
    @Order(1)
    void testAccessControl() {
        ctEnv.registerContract(SECURE_VAULT_ADDR, SecureVault::load);
        ctEnv.useIdentity("Unauthorized User");
        
        SecureVault vault = ctEnv.getContract();

        ctEnv.assertRequireFails(
            () -> vault.unlockVault().send(),
            "Solo l'admin puo sbloccare"
        );

    }

    /** Checking depositions with 0 ethers: still Unauthorized User */
    @Test
    @Order(2)
    void testInputValidation() {

        ctEnv.useIdentity("Unauthorized User");
        SecureVault vault = ctEnv.getContract();

        ctEnv.assertRequireFails(
            () -> vault.deposit(BigInteger.ZERO).send(),
            "L'importo deve essere maggiore di zero"
        );

    }

    /** Checking Business Logic: Admin unlocks & User deposits */
    @Test
    @Order(3)
    void testBusinessLogic_Au_Ud() throws Exception {

        ctEnv.useIdentity("AdminVault");
        SecureVault vault = ctEnv.getContract();
        vault.unlockVault().send();
        assertTrue(vault.isUnlocked().send(), "La cassaforte dovrebbe risultare sbloccata sulla EVM");

        ctEnv.useIdentity("Common User");
        vault = ctEnv.getContract();
        
        BigInteger initialBalance = vault.getBalance().send();
        vault.deposit(BigInteger.valueOf(100)).send();

        BigInteger finalBalance = vault.getBalance().send();

        BigInteger expectedBalance = initialBalance.add(BigInteger.valueOf(100));
        assertEquals(expectedBalance, finalBalance, "Il bilancio deve essere aumentato di 100");
    }

    /** Checking Business Logic: Cannot Withdraw more than Balance */
    @Test
    @Order(4)
    void testBusinessLogic_Cwmtb() {

        ctEnv.useIdentity("Unauthorized User");
        SecureVault vault = ctEnv.getContract();
        
        ctEnv.assertRequireFails(
            () -> vault.withdraw(BigInteger.valueOf(200)).send(),
            "Fondi insufficienti"
        );

    }

    /** Testing Smart Contract: SimpleStorage */
    @Test
    @Order(5)
    void testSimpleStorage_SetAndGet() throws Exception {

        ctEnv.useIdentity("AdminStorage");
        ctEnv.registerContract(SIMPLE_STORAGE_ADDR, SimpleStorage::load);

        SimpleStorage storage = ctEnv.getContract();
        storage.set(BigInteger.valueOf(42)).send();

        BigInteger storedValue = storage.get().send();
        assertEquals(BigInteger.valueOf(42), storedValue, "Il valore memorizzato in SimpleStorage deve essere 42");
    
    }

}