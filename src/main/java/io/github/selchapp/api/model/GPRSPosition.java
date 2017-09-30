package io.github.selchapp.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

}
