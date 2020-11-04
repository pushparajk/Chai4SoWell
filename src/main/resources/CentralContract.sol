pragma solidity >=0.4.6;

contract CentralContract {

    // (1)
    string schemeName="TestScheme";
    // (2)
    uint schemeAmount=10000;

	// (3)
	// enum StateCode{JK,HP,PB,CH,UK,HR,DL,RJ,UP,BR,SK,AR,NL,MN,MZ,TR,ML,AS,WB,JH,OD,CG,MP,GJ,DNHDD,MH,KA,GA,LD,KL,TN,PY,AN,TS,AD,LA,OT}
	// enum StateCode{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,29,30,31,32,33,34,35,36,37,38,97} can't have uint in enum
	// (4)
	uint[] selectedStates;
    // (5)
    mapping (uint => uint) public sanctionedAmount;
    // (6)
    mapping (uint => uint) public balanceAmount;

    // (5)
	
	event Sent(string __schemeName, uint __schemeAmount);
	
	    constructor(string memory _schemeName, uint _schemeAmount) public {
        schemeName = _schemeName;
        schemeAmount = _schemeAmount;
    }


	function disburseAmountToState(uint _stateId, uint _amount) public {
			
			//xamount=_amount;
			//uint arraySize = selectedStates.length;
			selectedStates.push(_stateId);
			sanctionedAmount[_stateId]=_amount;
			
	}
	
	function getSchemeName() public view returns(string memory ){
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

}