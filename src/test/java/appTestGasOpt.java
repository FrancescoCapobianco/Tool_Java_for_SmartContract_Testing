// Test su: GasOptimizer (istanza ganache: Gas Profiling)

import org.framework.ContractTester;
import org.framework.contracts.GasOptimizer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.DisplayNameGenerator.Simple;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class appTestGasOpt {
    
    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String GasOptimizer_ADDRESS = "0xBB75A56342F8D88DF88Dab4226F8eAB22107c8E0";

    @BeforeAll
    static void setup() {
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("Admin", "0xd6db66a3235f4e5dbd079dd28c7cf12a01679c875dcab6e6e3f5fb6f7db28247");
        tester.loadIdentity("CommonUser", "0x726084486c4ce832fa4c4a5a0937f231a2145f1e5f723216bae1d9ce4d98cfd3");
        tester.loadIdentity("Developer", "0x9d656a0b9364ddee2230fcf93052b5158b121fa290417f6bae49809eee71be03");
    }

    @Test
    @Order(1)
    void economicAssertionGO() throws Exception {

        tester.registerContract(GasOptimizer_ADDRESS, GasOptimizer::load);
        tester.useIdentity("Developer");
        GasOptimizer contract = tester.getContract();

        // OptimizedSum, Risultato atteso: Asserzione positiva
        BigInteger gasLimit = BigInteger.valueOf(110_000);
        tester.assertGasConsumption(
            () -> contract.optimizedSum(BigInteger.valueOf(200)).send(),
            gasLimit
        );

        // ExpensiveSum, Risultato atteso: Asserzione negativa
        AssertionError errorExpected = assertThrows(AssertionError.class, 
            () -> {
                tester.assertGasConsumption(
                    () -> contract.expensiveSum(BigInteger.valueOf(200)).send(),
                    gasLimit
                );
            }
        );

        assertTrue(errorExpected.getMessage().contains("Gas consumption exceed!"));

    }


}