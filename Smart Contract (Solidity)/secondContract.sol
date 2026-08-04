// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0; //Specifica la versione del compilatore

contract SimplePonzi
{
    address payable _currentInvestor;
    uint256 public _currentInvestment = 0; //non occorre inizializzare le variabili a zero, è uno spreco di gas!

    receive() external payable 
    {
        uint256 minimumInvestment = _currentInvestment * 11/10; //il nuovo investimento deve essere > 10% di quello corrente
        require(msg.value > minimumInvestment);
        address payable previousInvestor = _currentInvestor;
        _currentInvestor = payable(msg.sender);
        _currentInvestment = msg.value;
        previousInvestor.transfer(msg.value);
    }
}