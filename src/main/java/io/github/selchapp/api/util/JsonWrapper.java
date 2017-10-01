package io.github.selchapp.api.util;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

public class JsonWrapper {

	private final String value;

	public JsonWrapper(String value) {
        this.value = value;
    }

	@JsonValue
	@JsonRawValue
	public String value() {
		return value;
	}
}
