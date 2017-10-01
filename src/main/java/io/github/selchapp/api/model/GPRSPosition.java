package io.github.selchapp.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class GPRSPosition {
	
	@Column(nullable=true)
	private double lat;
	
	@Column(nullable=true)
	private double lng;

	public double getLatitude() {
		return lat;
	}

	public void setLatitude(double latitude) {
		this.lat = latitude;
	}

	public double getLongitude() {
		return lng;
	}

	public void setLongitude(double longitude) {
		this.lng = longitude;
	}
	
	@JsonIgnore
	public boolean isValid() {
		return lat != 0 && lng != 0;
	}
	
}
