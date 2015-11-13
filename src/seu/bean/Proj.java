package com.seu.bean;

public class Proj {
	private int id;
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public Proj(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Proj(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Proj() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public int getId() {
		return id;
	}
}
