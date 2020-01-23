/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3704224041413428471L;
	@JsonProperty("id")
	protected Long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	protected LocalDateTime created;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	protected LocalDateTime updated;

	protected void onCreate() {
		created = LocalDateTime.now();
	}

	public void onChange() {
		this.updated = LocalDateTime.now();
	}
}
