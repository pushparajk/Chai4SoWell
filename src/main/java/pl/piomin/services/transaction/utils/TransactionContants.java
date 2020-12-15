package pl.piomin.services.transaction.utils;

public class TransactionContants
{
	public enum ContractStatus{
		   NOT_VERIFIED, VERIFIED, VERIFY_FAILED;
	}

	public static final String CLIENT_ID = "client_id";

	public static final String CLIENT_SECRET = "client_secret";

	public static final String GRANT_TYPE = "grant_type";

	public static final String CLIENT_CREDENTIALS = "client_credentials";
	
	public static final String IDEMPOTENCY_KEY_VALUE = "44991089";

	public static final String AUTHORIZATION = "Authorization";
	
	public static final String PRODUCT_ID = "01010DEFAULTUSD";

	public static final String CURRENCY = "USD";
	
	//////Need to move to yml File

	public static final String STATE_ACCOUNT = "010100243400001";
	
	public static final String CENTER_ACCOUNT = "010100247620001";

	public static final String BRANCH_CODE = "00000001";
	
	public static final String CLIENT_ID_VAL = "2ebd0a3a-3d10-4ae3-85bf-826b00930b4a";

	public static final String CLIENT_SECRET_VAL = "04d00400-27f3-4d92-a1f4-16cc809e174f";
	
	public static final String FFDC_TOKEN_URL = "https://api.preprod.fusionfabric.cloud/login/v1/sandbox/oidc/token";

	public static final String FFDC_ACCOUNT_CREATE = "https://api.preprod.fusionfabric.cloud/retail-banking/current-and-savings-account/onboarding/v1/accounts/currentsavings";

	public static final String FFDC_CUSTOMER_CREATE = "https://api.preprod.fusionfabric.cloud/retail-banking/customers/v1/personal-customers";

	public static final String FFDC_FIN_POSTING = "https://api.preprod.fusionfabric.cloud/retail-banking/transactions/v1/financial-postings";
	
	public static final String ML_URL = "http://localhost:5444";
	
	public static final int TIME_INTERVAL_IN_MILLISEC = 3600000;

}

