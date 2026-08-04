// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract MemoryStorageCalldata
{
        uint[5] public numbers = [1, 2, 3, 4, 5];

        function memoryWorking() public view returns (uint[5] memory) {

            uint[5] memory A = numbers;
            A[0] = 99;
            return numbers;

        }

        function storageWorking() public returns (uint[5] memory)
        {
            uint[5] storage B = numbers;
            B[0] = 99;
            return numbers;
        }

        function calldataWorking(uint[] calldata _input) external view returns
        (uint[5] memory)
        {
            require(_input.length > 0, "wrong number of parameters");
            uint[5] memory A = numbers;
            A[0] = _input[0];
            return numbers;
        }

}