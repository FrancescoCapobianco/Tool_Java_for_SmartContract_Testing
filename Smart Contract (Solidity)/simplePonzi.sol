// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimplePonzi {
    address payable currentInvestor;
    uint256 public currentInvestment = 0;

    function sendFunds() external payable {
        uint256 minInvestment = currentInvestment + ((currentInvestment * 10) / 100);
        require(msg.value > minInvestment, "Investimento insufficiente");

        address payable prevInvestor = currentInvestor;
        currentInvestor = payable(msg.sender);
        currentInvestment = msg.value;

        if (prevInvestor != address(0)) {
            prevInvestor.transfer(msg.value);
        }
    }
}
