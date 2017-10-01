package io.github.selchapp.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class GPRSPosition {

	@Column(nullable = true)
	private double lat;

	@Column(nullable = true)
	private double lng;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@JsonIgnore
	public boolean isValid() {
		return lat != 0 && lng != 0;
	}

}
