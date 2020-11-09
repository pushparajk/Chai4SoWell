pragma solidity >=0.4.6;

contract DonationContract {

    string centralAddress;
	bytes32 identificationNo;
	bytes32 taxIdentificationNo;
	bytes32 donorAccountNo;
	bytes32 donorAccountName;
	bytes32 donorBankCode;
    uint donationAmount=10000;
	
	
    constructor(string memory _centralAddress, bytes32[] memory _donationContractDetails, uint _donationAmount  ) public {
		centralAddress=_centralAddress;
		identificationNo=_donationContractDetails[0];
		taxIdentificationNo=_donationContractDetails[1];
		donorAccountNo=_donationContractDetails[2];
		donorAccountName=_donationContractDetails[3];
		donorBankCode=_donationContractDetails[4];
		donationAmount=_donationAmount;
    }


	
	function getCentralAddress() public view returns(string memory){
		return  centralAddress;
	}

	
	function getIdentificationNo() public view returns(bytes32){
		return  identificationNo;
	}

	function getTaxIdentificationNo() public view returns(bytes32){
		return  taxIdentificationNo;
	}
	
	function getDonorAccountNo() public view returns(bytes32){
		return  donorAccountNo;
	}

	function getDonorAccountName() public view returns(bytes32){
		return  donorAccountName;
	}

	function getDonorBankCode() public view returns(bytes32){
		return  donorBankCode;
	}

	function getDonationAmount() public view returns(uint amount){
		return donationAmount;
	}	
	

}