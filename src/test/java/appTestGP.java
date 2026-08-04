// Test su: GradualPonzi (istanza ganache: Patterns)

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.GradualPonzi;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class appTestGP {

    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String gradualPonzi_ADDRESS = "0x3316a7565ba3bb6F0E1a3C28FeD33B77F240e3E8";

    @BeforeAll
    static void setup() {
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("Owner", "0x91516158c49d0ed0c73478ae1622704456d8442b7d48a1d6037b4efeea2426de");
        tester.loadIdentity("Investor", "0xfc4052700cc12fc506223912717a20e7c0d897a1314a7478ce8fff59abc94213");
    }

    @Test
    @Order(1)
    void testInvestmentGasEvent() throws Exception {
        tester.registerContract(gradualPonzi_ADDRESS, GradualPonzi::load);
        tester.useIdentity("Investor");
        GradualPonzi ponzi = tester.getContract();

        // 1 Finney = 10^15 Wei
        BigInteger investment = BigInteger.valueOf(1000000000000000L);
        BigInteger gasLimit = BigInteger.valueOf(150000);

        tester.assertGasConsumption(
            () -> ponzi.invest(investment).send(),
            gasLimit
        );
    }

    @Test
    @Order(2)
    void testEmergencyStopLock() throws Exception {
        tester.useIdentity("Owner");
        GradualPonzi ponziOwner = tester.getContract();
        ponziOwner.lock().send();

        tester.useIdentity("Investor");
        GradualPonzi ponziInvestor = tester.getContract();
        BigInteger investment = BigInteger.valueOf(1000000000000000L);

        tester.assertRequireFails(
            () -> ponziInvestor.invest(investment).send(),
            "The contract is in emergency stop state"
        );
    }
}