pragma solidity >=0.4.6;

contract CentralContract {

    bytes32 schemeName;
    uint schemeAmount=10000;
    bytes32 accountNumber;
	bytes32 accountName;
	bytes32 bankcode;
	uint[] selectedStates;
	mapping (uint => uint) public sanctionedAmount;
    mapping (uint => uint) public balanceAmount;
	
	event Sent(string __schemeName, uint __schemeAmount);
	
	    constructor(bytes32[] memory _schemeDetails, uint _schemeAmount  ) public {
        schemeName = _schemeDetails[0];
        schemeAmount = _schemeAmount;
		accountNumber = _schemeDetails[1];
		accountName = _schemeDetails[2];
		bankcode = _schemeDetails[3];
    }


	function disburseAmountToState(uint _stateId, uint _amount) public {
			
			//xamount=_amount;
			//uint arraySize = selectedStates.length;
			selectedStates.push(_stateId);
			sanctionedAmount[_stateId]=_amount;
			
	}
	
	function getSchemeName() public view returns(bytes32){
		return  schemeName;
	}
	
	function getSchemeAmount() public view returns(uint amount){
		return schemeAmount;
	}	
	
	function reverseBalanceAmountFromState(uint stateId, uint reverseAmount) public returns (bool){
		balanceAmount[stateId]=reverseAmount;
	}
	
	function getDisbursementAmount(uint _stateId) public view returns(uint _disbursedAmount){
		return sanctionedAmount[_stateId];
	}	

	function getBalanceAmount(uint _stateId) public view returns(uint _balanceAmount){
		return balanceAmount[_stateId];
	}	

	function getAccountNumber() public view returns(bytes32  ){
		return  accountNumber;
	}

	function getAccountName() public view returns(bytes32 ){
		return  accountName;
	}

	function getBankcode() public view returns(bytes32  ){
		return  bankcode;
	}



}