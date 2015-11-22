package com.seu.bean;

public class EIndex {
	private int id;
	private int proj_id;
	private int version_id;
	private float PREC;
	private float FLEX;
	private float RESL;
	private float TEAM;
	private float PMAT;
	private float InputE;
	private int type;

	public EIndex(int id, int proj_id,int version_id, float pREC, float fLEX, float rESL, float tEAM, float pMAT,float inputE) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.version_id = version_id;
		PREC = pREC;
		FLEX = fLEX;
		RESL = rESL;
		TEAM = tEAM;
		PMAT = pMAT;
		InputE = inputE;
	}
	
	public float getInputE() {
		return InputE;
	}

	public void setInputE(float inputE) {
		InputE = inputE;
	}

	public EIndex(int proj_id, float pREC, float fLEX, float rESL, float tEAM, float pMAT,float inputE) {
		super();
		this.proj_id = proj_id;
		this.version_id =version_id;
		PREC = pREC;
		FLEX = fLEX;
		RESL = rESL;
		TEAM = tEAM;
		PMAT = pMAT;
		InputE = inputE;
	}
	
	
	
	public EIndex(int id, int proj_id, int version_id, float pREC, float fLEX,
			float rESL, float tEAM, float pMAT, float inputE, int type) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.version_id = version_id;
		PREC = pREC;
		FLEX = fLEX;
		RESL = rESL;
		TEAM = tEAM;
		PMAT = pMAT;
		InputE = inputE;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
	
	public float getPREC() {
		return PREC;
	}

	public void setPREC(float pREC) {
		PREC = pREC;
	}

	public float getFLEX() {
		return FLEX;
	}

	public void setFLEX(float fLEX) {
		FLEX = fLEX;
	}

	public float getRESL() {
		return RESL;
	}

	public void setRESL(float rESL) {
		RESL = rESL;
	}

	public float getTEAM() {
		return TEAM;
	}

	public void setTEAM(float tEAM) {
		TEAM = tEAM;
	}

	public float getPMAT() {
		return PMAT;
	}

	public void setPMAT(float pMAT) {
		PMAT = pMAT;
	}

	public EIndex() {
		// TODO Auto-generated constructor stub
	}

}
