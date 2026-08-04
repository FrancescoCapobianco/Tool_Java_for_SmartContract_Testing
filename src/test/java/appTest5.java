// Test finale su: Migration, ThirdContract

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.framework.ContractTester;
import org.framework.contracts.Migration;
import org.framework.contracts.ThirdContract;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class appTest5 {

    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String Migration_Address = "0xb07072c5Ea35554771D8F8E04e9191Eb4c03C11D";
    private static final String thirdContract_Address = "0x65042377bd335ec492Ff467073e269b18A5903Be";

    @BeforeAll
    static void setup() {
        tester = new ContractTester("http://127.0.0.1:7545");
        tester.loadIdentity("MigrationOwner", "0x44dc59229e9fb5fa3e557cf1d55b7fc1d6a37940a9eae0cf6fc5a261a22d739c");
        tester.loadIdentity("ThirdOwner", "0x58800be24bd884b64325865c33dd95dc87a97816c3ce104ac96de778a3c57bbc");
        tester.loadIdentity("Hacker", "0xc79c0ef7e9a9678c02175a5572ecb25ac2f94cc0dbd05e708769d1efe8a26634"); 
    }

    @Test
    @Order(1)
    void testMigration_UnauthorizedUpdate() {
        tester.registerContract(Migration_Address, Migration::load);
        tester.useIdentity("Hacker");
        Migration contract = tester.getContract();

        // Tentativo di aggiornare la reference, Revert EVM attesa:
        tester.assertRequireFails(
            () -> contract.updateReference("0x0000000000000000000000000000000000000001").send(), 
            "Not owner!" 
        );
    }

    @Test
    @Order(2)
    void testThirdContract_WrongParameters() {
        tester.registerContract(thirdContract_Address, ThirdContract::load);
        tester.useIdentity("ThirdOwner");
        ThirdContract contract = tester.getContract();

        List<BigInteger> emptyArray = java.util.Collections.emptyList();

        // Tentativo chiamata con dimensione lista errata, Revert EVM attesa:
        tester.assertRequireFails(
            () -> contract.calldataWorking(emptyArray).send(), 
            "wrong number of parameters" 
        );
    }

}