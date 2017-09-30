package io.github.selchapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GPRSPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private double north;
	private double east;

	public Long getId() {
		return id;
	}

	public double getNorth() {
		return north;
	}

	public void setNorth(double north) {
		this.north = north;
	}

	public double getEast() {
		return east;
	}

	public void setEast(double east) {
		this.east = east;
	}

}
