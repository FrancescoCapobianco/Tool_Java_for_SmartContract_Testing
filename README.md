### Java Framework for Ethereum Smart Contract Testing

![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Ethereum](https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=white)
![Solidity](https://img.shields.io/badge/Solidity-%23363636.svg?style=for-the-badge&logo=solidity&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

Un middleware Java progettato per automatizzare e semplificare il testing off-chain di Smart Contract Solidity, colmando il divario tra l'Ecosistema Web3 e gli ambienti di sviluppo Enterprise (JUnit).

### Scopo del Progetto:
Attualmente, il testing degli Smart Contract avviene prevalentemente tramite framework JavaScript, il che rende complessa l'integrazione con i flussi di Continuous Integration e Continuous Deployment (CI/CD) nativi in Java.
L'uso diretto di librerie di basso livello come Web3j in Java comporta accoppiamento forte, codice boilerplate e una gestione molto complessa delle eccezioni EVM (es. i fallimenti dei require).

Questo framework risolve queste limitazioni offrendo un'interfaccia pulita per validare la business logic degli Smart Contract direttamente tramite JUnit, delegando al middleware la gestione infrastrutturale del client blockchain locale (es. Ganache).

### Architettura e Design Pattern:
Il middleware è costruito attorno a due Design Pattern fondamentali:

- Facade (ContractTester): Un punto di accesso unico che maschererà la complessità infrastrutturale, offrendo allo sviluppatore i metodi essenziali per la configurazione e le asserzioni.

- Chain of Responsibility: L'elaborazione delle chiamate ai contratti è delegata a una catena di handler (Gestione del Gas, Esecuzione RPC, Validazione Eccezioni), permettendo di disaccoppiare la logica di invio da quella di controllo degli errori.

### Use Case:
L'obiettivo è consentire allo sviluppatore di concentrarsi esclusivamente sulla logica del test. Ecco come appare un test di Access Control (RBAC) utilizzando il framework:

```
import org.junit.jupiter.api.Test;
import ContractTester; // La Facade del Framework

public class SmartContractTest {

    @Test
    public void testFailForUnauthorizedUser() {
        // 1. Inizializzazione della connessione (sotto il cofano)
        ContractTester ctEnv = new ContractTester("http://127.0.0.1:7545");
        
        // 2. Switch dinamico dell'identità verso un utente non autorizzato
        ctEnv.useIdentity("UnauthorizedUser");
        
        // 3. Esecuzione e cattura dell'eccezione di revert EVM in stile JUnit
        ctEnv.assertRequireFails(
            () -> { mioContratto.funzioneRiservataAdmin().send(); }, 
            "Solo l'admin puo sbloccare"
        );
    }
}
```
