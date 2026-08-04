// SPDX-License-Identifier: MIT 
pragma solidity ^0.8.0; //Specifica la versione del compilatore

contract Ownable {  //Dichiarazione del contratto, simile alla definizione di una classe in altri linguaggi 
    
    address private _owner; //Variabile di tipo address, memorizzerà un indirizzo di un wallet
    uint256 private _state; //Non inizializzo la variabile se devo porla a zero perché è uno spreco di gas
    //Esistono anche interi piu piccoli, ma è uno spreco di gas perche vengono comunque convertiti in uint256
    
    constructor() //Viene chiamato quando il contratto viene deployato
    {
        _owner = msg.sender;
    }

    function getOwner() public view returns (address)
    {
        return _owner;
    }

    function getState() public view returns (uint256)
    {
        return _state;
    }

    modifier onlyOwner()
    {
        require(msg.sender == _owner, "Not owner!");
        _; //Continua l'esecuzione della funzione
    }
    
    function setState(uint256 _value) public onlyOwner // viene usato il modificatore che integra il controllo della funzione
    {
        _state = _value;
    }

    function changeOwner(address _newOwner) public onlyOwner
    {
        _owner = _newOwner;
    }

}