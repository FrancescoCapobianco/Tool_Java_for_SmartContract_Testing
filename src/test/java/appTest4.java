// Test su: Ownable

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.Ownable;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class appTest4 {
    
    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String Ownable_Address = "0x67a955Fd671442ebee336c5becB4e3314EbbBC50";
    private static final String oldOwner_Address = "0x20ccd5873406F51e45d52B6940F0173E626d77c9";
    private static final String newOwner_Address = "0x5786e845CE474527c970EBf6DB4ACE2D2C648b0C";    

    @BeforeAll
    static void setup(){
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("Old_Owner",  "0x4945c8b6913160a65ea47d4adbf5354a598eb08592ae68496e8498ee4c3b0576");
        tester.loadIdentity("New_Owner", "0xa705927ce272c02d6b195d7214a5fdc1dd1448b08ebe36585cf393a8c994e86b");
    }

    @Test
    @Order(1)
    void testOwnershipTransferLifecycle() throws Exception {
        tester.registerContract(Ownable_Address, Ownable::load);
        tester.useIdentity("Old_Owner");

        // Cambio proprietario: Old_Owner -> New_Owner:
        Ownable contract = tester.getContract();
        contract.changeOwner(newOwner_Address).send();

        // Il vecchio proprietario vuole cambiare lo stato, Revert EVM attesa:
        tester.assertRequireFails(
            () -> contract.setState(BigInteger.valueOf(99)).send(),
            "Not owner!"
        );

        // Nuovo proprietario:
        tester.useIdentity("New_Owner");
        Ownable contractNewOwner = tester.getContract();

        // assertEquals sull'azione del nuovo proprietario:
        contractNewOwner.setState(BigInteger.valueOf(100)).send();
        BigInteger currentState = contractNewOwner.getState().send();
        assertEquals(BigInteger.valueOf(100), currentState);

        // Il nuovo proprietario restituisce la proprietà al vecchio per i test futuri! (Ripristino Stato)
        contractNewOwner.changeOwner(oldOwner_Address).send();
    }

}