// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BooleanBoxes {
    uint8[32] private BooleanBox; 

    function set(uint256 boxIndex, uint8 value) public {
        require(boxIndex < 32, "Index out of bounds");
        BooleanBox[boxIndex] = value;
    }

    function get(uint256 boxIndex) public view returns (uint8) {
        require(boxIndex < 32, "Index out of bounds");
        return BooleanBox[boxIndex];
    }

    function getFlag(uint256 boxIndex, uint8 bitIndex) public view returns (bool) {
        require(boxIndex < 32 && bitIndex < 8, "Index out of bounds");
        return (BooleanBox[boxIndex] & (1 << bitIndex)) != 0;
    }

    function setFlagTrue(uint256 boxIndex, uint8 bitIndex) public {
        require(boxIndex < 32 && bitIndex < 8, "Index out of bounds");
        BooleanBox[boxIndex] |= uint8(1 << bitIndex);
    }

    function setFlagFalse(uint256 boxIndex, uint8 bitIndex) public {
        require(boxIndex < 32 && bitIndex < 8, "Index out of bounds");
        BooleanBox[boxIndex] &= ~uint8(1 << bitIndex);
    }

    function toggleFlag(uint256 boxIndex, uint8 bitIndex) public {
        require(boxIndex < 32 && bitIndex < 8, "Index out of bounds");
        BooleanBox[boxIndex] ^= uint8(1 << bitIndex);
    }

    function setFlagTrueMask(uint256 boxIndex, uint8 mask) public {
        require(boxIndex < 32, "Index out of bounds");
        BooleanBox[boxIndex] |= mask;
    }

    function setFlagFalseMask(uint256 boxIndex, uint8 mask) public {
        require(boxIndex < 32, "Index out of bounds");
        BooleanBox[boxIndex] &= ~mask;
    }
}