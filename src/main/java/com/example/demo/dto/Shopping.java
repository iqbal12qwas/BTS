package com.example.demo.dto;

public class Shopping {
	
	private long id;
	private String name;
	private String createddate;
	
	public Shopping() {
	}

	public Shopping(long id, String name, String createddate) {
		super();
		this.id = id;
		this.name = name;
		this.createddate = createddate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	
	
	

}
