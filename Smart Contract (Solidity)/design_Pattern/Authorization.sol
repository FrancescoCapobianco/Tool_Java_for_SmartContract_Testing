// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Authorization
{
    mapping(address => uint256) public permissions; //Mapping per tracciare i livelli di permesso per ogni indirizzo

    constructor()
    {
        permissions[msg.sender] = 3; // Imposta il livello di permesso massimo per il deployer
    }

    modifier hasPermission(uint256 _level) // Modificatore per controllare il livello di permesso
    {
        require(permissions[msg.sender] >= _level, "Permission not granted!");
        _;
    }

    function getPermission(address _user) public view returns(uint256)
    {
        return permissions[_user];
    }

    function setPermission(address _user, uint256 _level) public hasPermission(3) //cambia il livello per un indirizzo
    {
        permissions[_user] = _level;
    }

    function functionLevel1() public hasPermission(1) //Richiede un livello di permesso 1 per essere eseguita
    {
        // Logica della funzione
    }

    function functionLevel2() public hasPermission(2) //Richiede un livello di permesso 2 per essere eseguita
    {
        // Logica della funzione
    }

    function functionLevel3() public hasPermission(3) //Richiede un livello di permesso 3 per essere eseguita
    {
        // Logica della funzione
    }
    
}