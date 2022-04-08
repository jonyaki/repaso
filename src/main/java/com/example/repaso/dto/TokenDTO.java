package com.example.repaso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TokenDTO {
	private String token;

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenDTO(String token) {
		this.token = token;
	}
}
