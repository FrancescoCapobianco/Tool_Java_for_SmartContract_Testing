// Test su: EmergencyStop, FirstConctract (istanza ganache da 2 in poi: ContractTesting)

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.EmergencyStop;
import org.framework.contracts.FirstConctract;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class appTest2 {
    
    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String EmergencyStop_Address = "0x895BF441aB79Add984c4b8E71722DEc53af2Ca15";
    private static final String FirstConctract_Address = "0x08609bdD31D444b8dBD073EAE00F14fF0B11D104";

    @BeforeAll
    static void setup(){
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("AdminEmergency", "0x57233ad921f2b01cc5a7dbc8ef13afb135917c34e76e2e0497142a9cfe5a481f");
        tester.loadIdentity("AdminFirst", "0x725a66c0672b1554d8e6fca82eb6926229c0ab056550b2da940e25f3e29b2460");
        tester.loadIdentity("CommonUser", "0xdb42ccbb4234246831eabccad5d5d3354f9625cdacaa8eb446e2719fde2f3b6f");
    }

    @Test
    @Order(1)
    void testEmergencyStop_UnauthorizedLock(){
        tester.registerContract(EmergencyStop_Address, EmergencyStop::load);

        tester.useIdentity("CommonUser");
        EmergencyStop contract = tester.getContract();

        // Intercettazione corretta di Revert EVM:
        tester.assertRequireFails(
            () -> contract.lock().send(),
            "Not owner!"
        );
    }

    @Test
    @Order(2)
    void testFirstContract_Increment() throws Exception {
        tester.registerContract(FirstConctract_Address, FirstConctract::load);

        tester.useIdentity("AdminFirst");
        FirstConctract contract = tester.getContract();

        BigInteger initialCount = contract.getCount().send();
        contract.increment().send();

        // assertEquals di JUnit normale:
        BigInteger finalCount = contract.getCount().send();
        assertEquals(initialCount.add(BigInteger.ONE), finalCount);
    }

}