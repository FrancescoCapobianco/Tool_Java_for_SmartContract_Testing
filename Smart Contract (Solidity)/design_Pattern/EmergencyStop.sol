// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "./Ownable.sol";

contract Stoppable is Ownable
{
    uint private _locked;
    
    modifier onlyIfUnlocked()
    {
        require(_locked == 0, "The contract is in emergency stop state, try again later.");
        _;
    }

    function lock() public onlyOwner
    {
        _locked = 1;
    }

    function unlock() public onlyOwner
    {
        _locked = 0;
    }
    
}