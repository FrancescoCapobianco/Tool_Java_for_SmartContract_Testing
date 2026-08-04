// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SwapVariables {
    uint256 public val1 = 100;
    uint256 public val2 = 200;

    // Metodo costoso con variabile ausiliaria
    function expensiveSwap() public {
        uint256 temp = val1;
        val1 = val2;
        val2 = temp;
    }

    // Metodo ottimizzato in linea singola
    function optimizedSwap() public {
        (val1, val2) = (val2, val1);
    }
}