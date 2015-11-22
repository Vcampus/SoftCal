package com.seu.bean;

public class Version {
	private int id;
	private int proj_id;
	private String proj_name;
	private String version;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProj_id() {
		return proj_id;
	}
	public void setProj_id(int proj_id) {
		this.proj_id = proj_id;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Version(int id, int proj_id, String proj_name, String version) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.proj_name = proj_name;
		this.version = version;
	}
	
	public Version(int proj_id, String proj_name, String version) {
		super();
		this.proj_id = proj_id;
		this.proj_name = proj_name;
		this.version = version;
	}
	public Version() {
		super();
		// TODO 自动生成的构造函数存根
	}
}
