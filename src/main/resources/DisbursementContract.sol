pragma solidity >=0.4.6;

contract DisbursementContract {

	
	string stateContractAddress;
	string identificationNumber;
	string bankCode;
	string accountNumber;
	uint disbursementAmount;
	
	
	constructor(string memory _stateContractAddress,string memory _identificationNumber,string memory _bankCode,string memory _accountNumber,uint _disbursementAmount) public {
		 stateContractAddress = _stateContractAddress;
		 identificationNumber=_identificationNumber;
		 bankCode = _bankCode;
		 accountNumber=_accountNumber;
		 disbursementAmount=_disbursementAmount;
	}

	function getIdentificationNumber() public view returns(string memory _identificationNumber){
		return identificationNumber;
	}
	
	function getBankCode() public view returns(string memory _bankCode){
		return bankCode;
	}

	function getAccountNumber() public view returns(string memory _accountNumber){
		return accountNumber;
	}

	function getDisbursementAmount() public view returns(uint _disbursementAmount){
		return disbursementAmount;
	}

	function getStateContractAddress() public view returns(string memory _stateContractAddress){
		return stateContractAddress;
	}
	
	
}