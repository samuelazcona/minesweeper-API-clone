package com.samuel.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3704224041413428471L;
	@JsonProperty("id")
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Column(name = "UPDATE_DATE", updatable = false)
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	public void onChange() {
		this.updated = new Date();
	}
}
