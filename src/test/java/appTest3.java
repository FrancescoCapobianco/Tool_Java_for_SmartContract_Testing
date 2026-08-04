// Test su: Authorization

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.Authorization;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class appTest3 {
    
    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String Authorization_Address = "0xD204836Fd88762aFABD57f17d534B2e4b187C0C7";
    private static final String CommonUser_Address = "0x7A89907D9474C70686ca4af3FE0D619981aEa4B0";

    @BeforeAll
    static void setup(){
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("AdminAuthorization", "0xb2584a0ea329992df26dcc27e53f97ebcc98f0435c7be4916b637369c6c368bc");
        tester.loadIdentity("CommonUser", "0xdb42ccbb4234246831eabccad5d5d3354f9625cdacaa8eb446e2719fde2f3b6f");
    }

    @Test
    @Order(1)
    void testSetPermission() throws Exception {
        tester.registerContract(Authorization_Address, Authorization::load);
        tester.useIdentity("AdminAuthorization");
        Authorization contract = tester.getContract();

        // Assegnazione livello:
        contract.setPermission(CommonUser_Address, BigInteger.valueOf(1)).send();

        // Verifica Assegnazione:
        BigInteger userLevel = contract.getPermission(CommonUser_Address).send();
        assertEquals(BigInteger.valueOf(1), userLevel);
    }

    @Test
    @Order(2)
    void testUnauthorizedLevelAccess() {
        // Essendo ancora con il AuthorizationContract, la Facade si occupa di ricreare il contratto:
        tester.useIdentity("CommonUser");
        Authorization contract = tester.getContract();

        // User prova functionLevel2, Revert EVM attesa.
        tester.assertRequireFails(
            () -> contract.functionLevel2().send(),
            "Permission not granted!"
        );
    }

}