package com.m23.loginservice.model;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Service
public class Validate {

	private boolean tokenValid;
	private String validationResponse;

	public boolean isTokenValid() {
		return tokenValid;
	}

	public void setTokenValid(boolean tokenValid) {
		this.tokenValid = tokenValid;
	}

	public String getValidationResponse() {
		return validationResponse;
	}

	public void setValidationResponse(String validationResponse) {
		this.validationResponse = validationResponse;
	}

	@Override
	public String toString() {
		return "Validate [tokenValid=" + tokenValid + ", validationResponse=" + validationResponse + "]";
	}

}
