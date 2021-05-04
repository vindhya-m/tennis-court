package com.tenniscourts.guests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Guest {



	@Id
	@GeneratedValue
	@Column(name = "guestid")
	private Long guestid;

	@Column
	@NotNull
	private String name;

	public Long getGuestid() {
		return guestid;
	}

	public void setGuestid(Long guestId) {
		this.guestid = guestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
