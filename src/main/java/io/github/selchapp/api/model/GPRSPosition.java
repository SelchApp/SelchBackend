package io.github.selchapp.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class GPRSPosition {
	
	@Column(nullable=true)
	private double latitude;
	
	@Column(nullable=true)
	private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@JsonIgnore
	public boolean isValid() {
		return latitude > 0 && longitude > 0;
	}
	
}
