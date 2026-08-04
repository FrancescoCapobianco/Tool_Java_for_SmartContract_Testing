// SPDX-License-Identifier: MIT 
pragma solidity ^0.8.19; // Specifica la versione del compilatore

contract firstConctract {   // Dichiarazione del contratto, come definizione classe
    
    uint private _count;    // Variabile memorizzata sulla blockchain

    constructor() {
        _count = 10;
    }

    function increment() public {
        _count += 1;
    }

    function getCount() public view returns (uint) { return _count; }

}