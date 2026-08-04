// Test su: VotingSystem [Facade di 2 contratti: voteTracker e voteRecorder] (istanza ganache: Patterns)

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.math.BigInteger;

import org.framework.ContractTester;
import org.framework.contracts.VotingSystem; 

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class appTestVS {

    private static ContractTester tester;
    private static final String urlGanache = "http://127.0.0.1:7545";
    private static final String votingSystem_ADDRESS = "0xBe6908BC5794B0aaC5b7092b72D991C2f94EF023";

    @BeforeAll
    static void setup() {
        tester = new ContractTester(urlGanache);
        tester.loadIdentity("Admin", "0xd498d5624f74de7fbf00af6a1a3513c1f13d64b773995757350398f85818a58e");
        tester.loadIdentity("Voter1", "0x377fa4b567418ec85aefafe7734c6795f495a7985c7a023fcf8dbcaf35d8ee6c");
        tester.loadIdentity("Voter2", "0x810d061b3b4b42619f28c389813e6dc425d0c4a93060ccbdb0ed73a54476d31b");
        tester.loadIdentity("Voter3", "0x4a5679b764fcf5a5997d62ecb0cbac003c640dc43e6daa74a0b0cc331195ad22");
    }

    @Test
    @Order(1)
    void testAddCandidateAndVote() throws Exception {
        tester.registerContract(votingSystem_ADDRESS, VotingSystem::load);
        tester.useIdentity("Admin");
        VotingSystem facadeAdmin = tester.getContract();
        facadeAdmin.addCandidate().send(); 

        tester.useIdentity("Voter3");               // Se rieseguito, fallisce.
        VotingSystem facadeVoter = tester.getContract();
        facadeVoter.vote(BigInteger.valueOf(1)).send();
    }

    @Test
    @Order(2)
    void testDoubleVoting() {
        tester.useIdentity("Voter1");
        VotingSystem facadeVoter = tester.getContract();

        tester.assertRequireFails(
            () -> facadeVoter.vote(BigInteger.valueOf(1)).send(),
            "User has already voted!"
        );
    }

    @Test
    @Order(3)
    void testInvalidCandidate() {
        tester.useIdentity("Voter2"); 
        VotingSystem facadeVoter = tester.getContract();

        tester.assertRequireFails(
            () -> facadeVoter.vote(BigInteger.valueOf(99)).send(),
            "Invalid candidate ID!"
        );
    }

    @Test
    @Order(4)
    void testCloseVoting_AndVote() throws Exception {
        tester.useIdentity("Admin");
        VotingSystem facadeAdmin = tester.getContract();
        facadeAdmin.closeVoting().send();

        tester.useIdentity("Voter2");
        VotingSystem facadeVoter = (VotingSystem) tester.getContract();

        tester.assertRequireFails(
            () -> facadeVoter.vote(BigInteger.valueOf(1)).send(),
            "Voting is closed!"
        );

        // Ripristino stato:
        tester.useIdentity("Admin");
        VotingSystem facadeRestore = tester.getContract();
        facadeRestore.openVoting().send();
    }
}