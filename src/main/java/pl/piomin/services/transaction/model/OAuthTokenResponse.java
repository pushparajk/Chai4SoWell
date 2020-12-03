package pl.piomin.services.transaction.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;


/**
 * The Class OAuthTokenResponse.
 */
public class OAuthTokenResponse {
	
	/** The access token. */
	@JsonRawValue
	private String access_token;
	
	/** The refresh token. */
	@JsonRawValue
	private String refresh_token;
	
	/** The expires in. */
	@JsonRawValue
	private Long expires_in;
	
	/** The refresh expires in. */
	@JsonRawValue
	private Long refresh_expires_in;
	
	/** The token type. */
	@JsonRawValue
	private String token_type;
	
	/** The id token. */
	@JsonRawValue
	private String id_token;
	
	/** The scope. */
	@JsonRawValue
	@JsonProperty("scope")
	private String scope;

	public String getAccess_token()
	{
		return access_token;
	}

	public void setAccess_token(String access_token)
	{
		this.access_token = access_token;
	}

	public String getRefresh_token()
	{
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token)
	{
		this.refresh_token = refresh_token;
	}

	public Long getExpires_in()
	{
		return expires_in;
	}

	public void setExpires_in(Long expires_in)
	{
		this.expires_in = expires_in;
	}

	public Long getRefresh_expires_in()
	{
		return refresh_expires_in;
	}

	public void setRefresh_expires_in(Long refresh_expires_in)
	{
		this.refresh_expires_in = refresh_expires_in;
	}

	public String getToken_type()
	{
		return token_type;
	}

	public void setToken_type(String token_type)
	{
		this.token_type = token_type;
	}

	public String getId_token()
	{
		return id_token;
	}

	public void setId_token(String id_token)
	{
		this.id_token = id_token;
	}

	public String getScope()
	{
		return scope;
	}

	public void setScope(String scope)
	{
		this.scope = scope;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_token == null) ? 0 : access_token.hashCode());
		result = prime * result + ((expires_in == null) ? 0 : expires_in.hashCode());
		result = prime * result + ((id_token == null) ? 0 : id_token.hashCode());
		result = prime * result + ((refresh_expires_in == null) ? 0 : refresh_expires_in.hashCode());
		result = prime * result + ((refresh_token == null) ? 0 : refresh_token.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result + ((token_type == null) ? 0 : token_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OAuthTokenResponse other = (OAuthTokenResponse) obj;
		if (access_token == null)
		{
			if (other.access_token != null)
				return false;
		}
		else if (!access_token.equals(other.access_token))
			return false;
		if (expires_in == null)
		{
			if (other.expires_in != null)
				return false;
		}
		else if (!expires_in.equals(other.expires_in))
			return false;
		if (id_token == null)
		{
			if (other.id_token != null)
				return false;
		}
		else if (!id_token.equals(other.id_token))
			return false;
		if (refresh_expires_in == null)
		{
			if (other.refresh_expires_in != null)
				return false;
		}
		else if (!refresh_expires_in.equals(other.refresh_expires_in))
			return false;
		if (refresh_token == null)
		{
			if (other.refresh_token != null)
				return false;
		}
		else if (!refresh_token.equals(other.refresh_token))
			return false;
		if (scope == null)
		{
			if (other.scope != null)
				return false;
		}
		else if (!scope.equals(other.scope))
			return false;
		if (token_type == null)
		{
			if (other.token_type != null)
				return false;
		}
		else if (!token_type.equals(other.token_type))
			return false;
		return true;
	}
	
	
}
