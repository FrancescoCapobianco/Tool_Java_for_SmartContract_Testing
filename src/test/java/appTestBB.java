// Test su: BooleanBoxes (istanza ganache: Patterns)

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.BooleanBoxes;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class appTestBB {

    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String booleanBoxes_ADDRESS = "0x0B62a7db10aDaDa0DD58e939FD824171BC3DEeaf"; 

    @BeforeAll
    static void setup() {
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("BitMaster", "0x8b190c36adb13f7cb6dc1369e68f4206015cbc3d2aa94e2e66aa17cc14c9c860"); 
    }

    @Test
    @Order(1)
    void testSingleBitOperations() throws Exception {
        tester.registerContract(booleanBoxes_ADDRESS, BooleanBoxes::load);
        tester.useIdentity("BitMaster");
        BooleanBoxes boxes = tester.getContract();

        BigInteger boxIndex = BigInteger.ZERO;

        // bit 0 ON (il primo da destra)
        boxes.setFlagTrue(boxIndex, BigInteger.ZERO).send();
        assertTrue(boxes.getFlag(boxIndex, BigInteger.ZERO).send());

        // bit 0 OFF (da acceso a spento)
        boxes.toggleFlag(boxIndex, BigInteger.ZERO).send();
        assertFalse(boxes.getFlag(boxIndex, BigInteger.ZERO).send());

        // bit 4
        boxes.setFlagTrue(boxIndex, BigInteger.valueOf(4)).send();
        assertTrue(boxes.getFlag(boxIndex, BigInteger.valueOf(4)).send());
    }

    @Test
    @Order(2)
    void testMaskOperations() throws Exception {
        BooleanBoxes boxes = tester.getContract();

        BigInteger boxIndex = BigInteger.ONE;

        // byte intero a 0
        boxes.set(boxIndex, BigInteger.ZERO).send();

        // Maschera per accendere i primi 4 bit a destra: 0000 1111 (Decimale: 15)
        BigInteger maskOn = BigInteger.valueOf(15);
        boxes.setFlagTrueMask(boxIndex, maskOn).send();
        
        assertEquals(BigInteger.valueOf(15), boxes.get(boxIndex).send());

        // Maschera per spegnere il bit 0 e il bit 2: 0000 0101 (Decimale: 5)
        // Valore atteso: 15 - 5 = 10 (Binario: 0000 1010)
        BigInteger maskOff = BigInteger.valueOf(5);
        boxes.setFlagFalseMask(boxIndex, maskOff).send();
        
        assertEquals(BigInteger.valueOf(10), boxes.get(boxIndex).send());
    }

    @Test
    @Order(3)
    void testOutOfBounds() {
        tester.useIdentity("BitMaster");
        BooleanBoxes boxes = tester.getContract();

        tester.assertRequireFails(
            () -> boxes.get(BigInteger.valueOf(32)).send(),
            "Index out of bounds"
        );

        tester.assertRequireFails(
            () -> boxes.setFlagTrue(BigInteger.ZERO, BigInteger.valueOf(8)).send(),
            "Index out of bounds"
        );
    }
}