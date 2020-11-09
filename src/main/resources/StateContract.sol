pragma solidity >=0.4.6;

contract StateContract {

    uint schemeSanctionedAmount;
	
	string centralContractAddress;
	
	uint stateId;
	
	uint balanceAmount;
	
	//new string[](size);
	
	constructor( uint _schemeSanctionedAmount, string memory _centralContractAddress,uint _stateId) public {
        schemeSanctionedAmount = _schemeSanctionedAmount;
		centralContractAddress=_centralContractAddress;
		stateId = _stateId;
		balanceAmount=_schemeSanctionedAmount;
	}

	function disburseAmountToIndividual(uint _amount) public {
		balanceAmount -=_amount;
	}
	


	function getBalanceAmount() public view returns(uint _balanceAmount){
		return balanceAmount;
	}	


	function getSchemeSanctionedAmount() public view returns(uint sAmount){
		return schemeSanctionedAmount;
	}	

	function getcentralContractAddress() public view returns(string memory sAmount){
		return centralContractAddress;
	}	


	function getStateId() public view returns(uint sStateId){
		return stateId;
	}	

	
}