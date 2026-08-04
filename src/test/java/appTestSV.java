// Test su: SwapVariables (istanza ganache: Patterns)

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.SwapVariables;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class appTestSV {

    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String swapVariables_ADDRESS = "0xd5517Faa425eB6c39072A4d16437731952F1C922"; 

    @BeforeAll
    static void setup() {
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("Developer", "0xe65866b8561bea5d909b24816c62b077b54360f79e54b96c09be772a300f1822"); 
    }

    @Test
    @Order(1)
    void testSwapOptimization() throws Exception {
        tester.registerContract(swapVariables_ADDRESS, SwapVariables::load);
        tester.useIdentity("Developer");
        SwapVariables contract = tester.getContract();

        BigInteger gasLimit = BigInteger.valueOf(31250);

        tester.assertGasConsumption(
            () -> contract.optimizedSwap().send(),
            gasLimit
        );

        AssertionError errorExpected = assertThrows(
            AssertionError.class,
            () -> {
                tester.assertGasConsumption(
                    () -> contract.expensiveSwap().send(),
                    gasLimit
                );
            }
        );

        assertTrue(errorExpected.getMessage().contains("Gas consumption exceed!"));
    }
}