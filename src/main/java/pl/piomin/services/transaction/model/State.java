package pl.piomin.services.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "state")
public class State {

	@Id
	private String id;
	private String homeName;
	private Integer stateId;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getHomeName()
	{
		return homeName;
	}
	public void setHomeName(String homeName)
	{
		this.homeName = homeName;
	}
	public Integer getStateId()
	{
		return stateId;
	}
	public void setStateId(Integer stateId)
	{
		this.stateId = stateId;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((homeName == null) ? 0 : homeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
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
		State other = (State) obj;
		if (homeName == null)
		{
			if (other.homeName != null)
				return false;
		}
		else if (!homeName.equals(other.homeName))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (stateId == null)
		{
			if (other.stateId != null)
				return false;
		}
		else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

}
