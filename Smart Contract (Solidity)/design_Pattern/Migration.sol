// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "./Ownable.sol";

contract Proxy is Ownable
{
    address internal _realContractAddress;

    function updateReference(address _newContractAddress) external onlyOwner
    {
        _realContractAddress = _newContractAddress;
    }

    fallback() external payable
    {
        (bool success, ) = _realContractAddress.delegatecall(msg.data);
        //cattura il valore della tupla restituita delegatecall (salvando solo il primo elemento)
        require(success, "Delegatecall failed");
    }

    receive() external payable {}


}

contract RealService
{
    
    uint8 private constant _increment = 1;
    uint128 _value;

    function increment() public
    {   
        _value += _increment;
    }

    function getValue() public view returns(uint128)
    {
        return _value;
    }

}

contract UpdatedService
{
    
    uint8 private constant _increment = 10; // differenza con la prima versione
    uint128 _value;

    function increment() public
    {
        _value += _increment;
    }

    function getValue() public view returns(uint128)
    {
        return _value;
    }

}