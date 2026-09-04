# Java Middleware for Ethereum Smart Contract Testing

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=black)
![Ethereum](https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=blue)
![Solidity](https://img.shields.io/badge/Solidity-%23363636.svg?style=for-the-badge&logo=solidity&logoColor=blue)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

A Java middleware designed to automate and simplify off-chain testing of Solidity Smart Contracts, bridging the gap between the Web3 ecosystem and Enterprise-grade Java environments.

## Overview:
Currently, testing smart contracts heavily relies on JavaScript/TypeScript frameworks (e.g., Hardhat), which complicates CI/CD integration for Java-based enterprise backends. Using low-level libraries like **Web3j** directly in Java leads to boilerplate code and complex EVM exception handling (like manual ABI payload decoding for `require` failures).

This tool solves these issues by providing a clean, high-level interface (Facade) to validate smart contract business logic and economic constraints directly via **JUnit**. Network infrastructure, identity context-switching, and blockchain message decoding are seamlessly handled under the hood.

## Key Features:
* **Web3j Boilerplate Abstraction:** Setup RPC nodes and Gas Providers in a single line of code.
* **Dynamic RBAC (Role-Based Access Control):** $O(1)$ identity context-switching via the `IdentityAuthenticator` to easily test user permissions.
* **EVM Revert Decoder:** Custom algorithm to deserialize ABI payloads (`0x08c379a0`) and raw JSON from Ganache, translating native EVM failures into readable text assertions.
* **Gas Profiling:** Monitor and limit transaction costs using `assertGasConsumption` to catch inefficient logic before deployment.
* **Functional Factory:** Dynamic runtime instantiation of Web3j Proxy Contracts while preserving Java's *Type Safety*.

## Architecture:
* **Facade (`ContractTester`):** The single entry point orchestrating connection, identities, and custom assertions.
* **Chain of Responsibility (`TransactionHandler`):** Delegates call processing through a chain of handlers (`CheckGasHandler` -> `ExecutionHandler`), separating gas checks from error decoding.
* **Functional Factory:** Leverages Method References (e.g., `MyContract::load`) to dynamically create Web3j wrappers.

## Quick Start
The main objective of this tool is to enable developers to adopt Test-Driven Development (TDD) practices, allowing them to focus entirely on core business logic.
Here is a quick example of a test using this tool:

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmartContractTest {

    private static ContractTester tester;
    private static final String CONTRACT_ADDRESS = "0x123...";

    @BeforeAll
    static void setup() {
        // Initialize local node (e.g., Ganache)
        tester = new ContractTester("http://127.0.0.1:7545");
        
        // Populate the identity pool
        tester.loadIdentity("Admin", "0xPrivate_Key_1...");
        tester.loadIdentity("Unauthorized User", "0xPrivate_Key_2...");
    }

    @Test
    @Order(1)
    public void testUnauthorizedAccessAndRevert() {
        // Dynamically register the Web3j Proxy via Method Reference
        tester.registerContract(CONTRACT_ADDRESS, SecureVault::load);
        
        // Instantly switch context to the "Unauthorized User" identity
        tester.useIdentity("Unauthorized User");
        SecureVault vault = tester.getContract();
        
        // Intercept EVM Revert just like a standard JUnit assertion
        tester.assertRequireFails(
            () -> vault.stealFunds().send(), 
            "Only admin can withdraw"
        );
    }

    @Test
    @Order(2)
    public void testGasProfiling() throws Exception {
        tester.useIdentity("Admin");
        SecureVault vault = tester.getContract();
        BigInteger gasLimit = BigInteger.valueOf(50_000);

        // Native JUnit failure if the transaction exceeds the gasLimit
        tester.assertGasConsumption(
            () -> vault.optimizedAlgorithm().send(),
            gasLimit
        );
    }
}
