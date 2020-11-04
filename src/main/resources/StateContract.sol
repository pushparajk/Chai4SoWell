pragma solidity >=0.4.6;

contract StateContract {

    // (1)
    string schemeName;
    // (2)
    uint schemeSanctionedAmount;
	
	string centralContractAddress;
	
	uint stateId;
	
	uint balanceAmount;
	
	constructor(string memory _schemeName, uint _schemeSanctionedAmount, string memory _centralContractAddress,uint _stateId) public {
        schemeName = _schemeName;
        schemeSanctionedAmount = _schemeSanctionedAmount;
		centralContractAddress=_centralContractAddress;
		stateId = _stateId;
		balanceAmount=schemeSanctionedAmount;
    }

	function disburseAmountToIndividual(uint _amount) public {
		balanceAmount -=_amount;
	}
	
}