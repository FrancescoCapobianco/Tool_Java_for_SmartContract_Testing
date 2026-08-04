// Test su: SimplePonzi (istanza ganache: Gas Profiling)

import org.framework.ContractTester;
import org.framework.contracts.SimplePonzi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayNameGenerator.Simple;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class appTestSP {

    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String simplePonzi_ADDRESS = "0xd5A8A7bFF4dA069f602B39EEB804C879A7028Cf8";

    @BeforeAll
    static void setup() {
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("Admin", "0x2b38939623e50330a54a24dda4390145609c14838b58585600836a02388dd05d");
        tester.loadIdentity("FirstInvestor", "0xcc489b725c6a4ed5174edbc09a1c42bfa4ca53c54ca2373779c5b654a9731594");
        tester.loadIdentity("SecondInvestor", "0x4779a4f1b84b38c22a35ea0c54673dccb3904a8389c21b405c05d0f1af3fe856");
    }

    @Test
    @Order(1)
    void testFinancialConstraint() throws Exception {
        tester.registerContract(simplePonzi_ADDRESS, SimplePonzi::load);
        tester.useIdentity("FirstInvestor");
        SimplePonzi ponzi = tester.getContract();
        ponzi.sendFunds(BigInteger.valueOf(11000)).send();

        tester.useIdentity("SecondInvestor");
        SimplePonzi ponziNewInvestor = tester.getContract();

        // Nuova identità prova a inviare 1050 Wei
        tester.assertRequireFails(
                () -> ponziNewInvestor.sendFunds(BigInteger.valueOf(1050))
                        .send(),
                "Investimento insufficiente");
    }

}