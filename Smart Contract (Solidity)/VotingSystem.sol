// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

// Contratto Base (Ownable)
contract Ownable {
    address private _owner;

    constructor() {
        _owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == _owner, "Not owner!");
        _;
    }
}

// Contratti composti (Accettano chiamate solo dalla Facade)
contract VoteBaseComposed is Ownable {
    address public facadeAddress;
    bool public votingOpen = true;

    function setFacadeAddress(address _facade) public onlyOwner {
        facadeAddress = _facade;
    }

    modifier onlyFacade() {
        require(msg.sender == facadeAddress, "Access denied: caller is not the Facade!");
        _;
    }

    function openVoting() public onlyFacade {
        votingOpen = true;
    }

    function closeVoting() public onlyFacade {
        votingOpen = false;
    }
}

// 3. Modulo per tenere traccia di CHI ha votato
contract VoteTracker is VoteBaseComposed {
    mapping(address => bool) private hasVoted;
    uint256 public totalVoters;

    modifier onlyIfOpen() {
        require(votingOpen, "Voting is closed!");
        _;
    }

    function registerVoter(address voter) public onlyFacade onlyIfOpen {
        require(!hasVoted[voter], "User has already voted!");
        hasVoted[voter] = true;
        totalVoters++;
    }
}

// 4. Modulo per tenere traccia dei RISULTATI (I voti)
contract VoteRecorder is VoteBaseComposed {
    mapping(uint256 => uint256) public votes;
    uint256 public totalCandidates;

    function addCandidate() public onlyFacade {
        totalCandidates++;
    }

    modifier validCandidate(uint256 candidateId) {
        require(candidateId > 0 && candidateId <= totalCandidates, "Invalid candidate ID!");
        _;
    }

    modifier onlyIfOpen() {
        require(votingOpen, "Voting is closed!");
        _;
    }

    function recordVote(uint256 candidateId) public onlyFacade onlyIfOpen validCandidate(candidateId) {
        votes[candidateId]++;
    }
}

// LA FACADE: L'unico punto di contatto per gli utenti
contract VotingFacade is Ownable {
    VoteTracker public tracker;
    VoteRecorder public recorder;

    constructor(address _trackerAddress, address _recorderAddress) {
        tracker = VoteTracker(_trackerAddress);
        recorder = VoteRecorder(_recorderAddress);
    }

    function addCandidate() public onlyOwner {
        recorder.addCandidate();
    }

    function vote(uint256 candidateId) public {
        tracker.registerVoter(msg.sender); // Registra l'utente (fallisce se ha gia votato)
        recorder.recordVote(candidateId);  // Registra il voto (fallisce se l'ID è errato)
    }

    function openVoting() public onlyOwner {
        tracker.openVoting();
        recorder.openVoting();
    }

    function closeVoting() public onlyOwner {
        tracker.closeVoting();
        recorder.closeVoting();
    }
}