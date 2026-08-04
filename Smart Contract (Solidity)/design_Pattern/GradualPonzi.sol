// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Stoppable {
    address private _owner;
    uint private _locked;

    constructor() { _owner = msg.sender; }

    modifier onlyOwner() {
        require(msg.sender == _owner, "Not owner!");
        _;
    }

    modifier onlyIfUnlocked() {
        require(_locked == 0, "The contract is in emergency stop state");
        _;
    }

    function lock() public onlyOwner { _locked = 1; }
    function unlock() public onlyOwner { _locked = 0; }
}

contract GradualPonzi is Stoppable {
    address[] public _investors;
    mapping (address => uint256) public _balances;
    uint256 public constant MINIMUM_INVESTMENT = 1e15; // 1 Finney

    event Invested(address indexed investor, uint256 amount);

    constructor () {
        _investors.push(msg.sender);
    }

    function invest() public payable onlyIfUnlocked {
        require(msg.value >= MINIMUM_INVESTMENT, "Insufficient investment");
        uint256 eachInvestorGets = msg.value / _investors.length;
        
        // Anti-pattern: il costo in Gas di questo ciclo cresce ad ogni investitore
        for (uint256 i = 0; i < _investors.length; i++) {
            _balances[_investors[i]] += eachInvestorGets;
        }
        _investors.push(msg.sender);
        
        emit Invested(msg.sender, msg.value);
    }
}