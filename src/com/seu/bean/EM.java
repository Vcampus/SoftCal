package com.seu.bean;

public class EM {
	private int id;
	private int proj_id;
	private int version_id;
	private float CPLX;
	private float TIME;
	private float PVOL;
	private float PCON;
	private float APEX;
	private float LTEX;
	private float SITE;
	private float RELY;
	private float DOCU;
	private float STOR;
	private float ACAP;
	private float PCAP;
	private float PLEX;
	private float TOOL;
	private float SCED;
	private float InputEm;

	public EM(int id, int proj_id,int version_id, float cPLX, float tIME, float pVOL, float pCON, float aPEX, float lTEX, float sITE,
			float rELY, float dOCU, float sTOR, float aCAP, float pCAP, float pLEX, float tOOL, float sCED,float inputEm) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.version_id=version_id;
		CPLX = cPLX;
		TIME = tIME;
		PVOL = pVOL;
		PCON = pCON;
		APEX = aPEX;
		LTEX = lTEX;
		SITE = sITE;
		RELY = rELY;
		DOCU = dOCU;
		STOR = sTOR;
		ACAP = aCAP;
		PCAP = pCAP;
		PLEX = pLEX;
		TOOL = tOOL;
		SCED = sCED;
		InputEm = inputEm;
	}
	
	public EM(int proj_id,int version_id, float cPLX, float tIME, float pVOL, float pCON, float aPEX, float lTEX, float sITE,
			float rELY, float dOCU, float sTOR, float aCAP, float pCAP, float pLEX, float tOOL, float sCED,float inputEm) {
		super();
		this.proj_id = proj_id;
		this.version_id =version_id;
		CPLX = cPLX;
		TIME = tIME;
		PVOL = pVOL;
		PCON = pCON;
		APEX = aPEX;
		LTEX = lTEX;
		SITE = sITE;
		RELY = rELY;
		DOCU = dOCU;
		STOR = sTOR;
		ACAP = aCAP;
		PCAP = pCAP;
		PLEX = pLEX;
		TOOL = tOOL;
		SCED = sCED;
		InputEm = inputEm;
	}
	
	public float getInputEm() {
		return InputEm;
	}

	public void setInputEm(float inputEm) {
		InputEm = inputEm;
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

	public float getCPLX() {
		return CPLX;
	}

	public void setCPLX(float cPLX) {
		CPLX = cPLX;
	}

	public float getTIME() {
		return TIME;
	}

	public void setTIME(float tIME) {
		TIME = tIME;
	}

	public float getPVOL() {
		return PVOL;
	}

	public void setPVOL(float pVOL) {
		PVOL = pVOL;
	}

	public float getPCON() {
		return PCON;
	}

	public void setPCON(float pCON) {
		PCON = pCON;
	}

	public float getAPEX() {
		return APEX;
	}

	public void setAPEX(float aPEX) {
		APEX = aPEX;
	}

	public float getLTEX() {
		return LTEX;
	}

	public void setLTEX(float lTEX) {
		LTEX = lTEX;
	}

	public float getSITE() {
		return SITE;
	}

	public void setSITE(float sITE) {
		SITE = sITE;
	}

	public float getRELY() {
		return RELY;
	}

	public void setRELY(float rELY) {
		RELY = rELY;
	}

	public float getDOCU() {
		return DOCU;
	}

	public void setDOCU(float dOCU) {
		DOCU = dOCU;
	}

	public float getSTOR() {
		return STOR;
	}

	public void setSTOR(float sTOR) {
		STOR = sTOR;
	}

	public float getACAP() {
		return ACAP;
	}

	public void setACAP(float aCAP) {
		ACAP = aCAP;
	}

	public float getPCAP() {
		return PCAP;
	}

	public void setPCAP(float pCAP) {
		PCAP = pCAP;
	}

	public float getPLEX() {
		return PLEX;
	}

	public void setPLEX(float pLEX) {
		PLEX = pLEX;
	}

	public float getTOOL() {
		return TOOL;
	}

	public void setTOOL(float tOOL) {
		TOOL = tOOL;
	}

	public float getSCED() {
		return SCED;
	}

	public void setSCED(float sCED) {
		SCED = sCED;
	}

	public EM() {
		// TODO Auto-generated constructor stub
	}

}
