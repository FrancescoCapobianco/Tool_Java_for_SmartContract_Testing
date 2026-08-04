// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract GasOptimizer {
    uint256 public total;

    // Scrive nello storage della blockchain ad ogni iterazione
    function expensiveSum(uint256 n) public {
        total = 0;
        for (uint256 i = 1; i <= n; i++) {
            total += i; 
        }
    }

    // Usa la memoria locale e scrive nello storage una sola volta
    function optimizedSum(uint256 n) public {
        uint256 tempTotal = 0;
        for (uint256 i = 1; i <= n; i++) {
            tempTotal += i;
        }
        total = tempTotal;
    }
}