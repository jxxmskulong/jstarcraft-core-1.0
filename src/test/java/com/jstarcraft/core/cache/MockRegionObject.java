package com.jstarcraft.core.cache;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.jstarcraft.core.cache.annotation.CacheChange;
import com.jstarcraft.core.cache.annotation.CacheConfiguration;
import com.jstarcraft.core.cache.annotation.CacheConfiguration.Unit;

@Entity
@CacheConfiguration(unit = Unit.REGION, indexes = { "owner" }, transienceStrategy = "lruMemoryStrategy", persistenceStrategy = "queuePersistenceStrategy")
public class MockRegionObject implements CacheObject<Integer> {

	@Id
	private Integer id;

	private int owner;

	MockRegionObject() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	public int getOwner() {
		return owner;
	}

	@CacheChange(values = { "true" })
	public boolean modify(int owner, boolean result) {
		this.owner = owner;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (!(object instanceof MockRegionObject))
			return false;
		MockRegionObject that = (MockRegionObject) object;
		EqualsBuilder equal = new EqualsBuilder();
		equal.append(this.getId(), that.getId());
		return equal.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hash = new HashCodeBuilder();
		hash.append(getId());
		return hash.toHashCode();
	}

	public static MockRegionObject instanceOf(Integer id, int owner) {
		MockRegionObject instance = new MockRegionObject();
		instance.id = id;
		instance.owner = owner;
		return instance;
	}

}
