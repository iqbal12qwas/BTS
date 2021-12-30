package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingDto {
	
	@JsonProperty("shopping")
	private Shopping shopping;
	
	public ShoppingDto() {
	}
	
	

	public ShoppingDto(Shopping shopping) {
		super();
		this.shopping = shopping;
	}



	public Shopping getShopping() {
		return shopping;
	}

	public void setShopping(Shopping shopping) {
		this.shopping = shopping;
	}
	
	

}
