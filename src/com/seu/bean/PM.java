package com.seu.bean;

public class PM {
	private int id;
	private int proj_id;
	private int version_id;
	private float PM_exp;
	private float PM_real;
	private float PM_adjA;
	private float PM_adjAB;
	
	public PM() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public PM(int proj_id, int version_id, float pM_exp, float pM_real, float pM_adj) {
		super();
		this.proj_id = proj_id;
		this.version_id = version_id;
		PM_exp = pM_exp;
		PM_real = pM_real;
		PM_adjA = pM_adj;
	}
	public PM(int id, int proj_id, int version_id, float pM_exp, float pM_real, float pM_adj) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.version_id = version_id;
		PM_exp = pM_exp;
		PM_real = pM_real;
		PM_adjA = pM_adj;
	}
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
	public int getVersion_id() {
		return version_id;
	}
	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}
	public float getPM_exp() {
		return PM_exp;
	}
	public void setPM_exp(float pM_exp) {
		PM_exp = pM_exp;
	}
	public float getPM_real() {
		return PM_real;
	}
	public void setPM_real(float pM_real) {
		PM_real = pM_real;
	}
	
	public float getPM_adjA() {
		return PM_adjA;
	}
	
	public void setPM_adjA(float pM_adjA) {
		PM_adjA = pM_adjA;
	}
	public float getPM_adjAB() {
		return PM_adjAB;
	}
	public void setPM_adjAB(float pM_adjAB) {
		PM_adjAB = pM_adjAB;
	}
	
	
}
