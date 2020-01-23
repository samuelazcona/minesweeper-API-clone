/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3704224041413428471L;
	@JsonProperty("id")
	private Long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date created;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date updated;

	protected void onCreate() {
		created = new Date();
	}

	public void onChange() {
		this.updated = new Date();
	}
}
