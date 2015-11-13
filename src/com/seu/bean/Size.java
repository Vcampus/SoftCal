package com.seu.bean;

public class Size {
	private int id;
	private int proj_id;
	private int version_id;
	private int SU;
	private float UNFM;
	private int InLogicalFiles;
	private int ExInterfaceFile;
	private int ExInputFiles;
	private int ExInquiryFiles;
	private int ExOutputFiles;
	private int InLogicalData;
	private int ExInterfaceData;
	private int ExInputData;
	private int ExInquiryData;
	private int ExOutputData;
	
	public Size(int id, int proj_id,int version_id, int sU, float uNFM, int inLogicalFiles, int exInterfaceFile, int exInputFiles,
			int exInquiryFiles, int exOutputFiles, int inLogicalData, int exInterfaceData, int exInputData,
			int exInquiryData, int exOutputData) {
		super();
		this.id = id;
		this.proj_id = proj_id;
		this.version_id =version_id;
		SU = sU;
		UNFM = uNFM;
		InLogicalFiles = inLogicalFiles;
		ExInterfaceFile = exInterfaceFile;
		ExInputFiles = exInputFiles;
		ExInquiryFiles = exInquiryFiles;
		ExOutputFiles = exOutputFiles;
		InLogicalData = inLogicalData;
		ExInterfaceData = exInterfaceData;
		ExInputData = exInputData;
		ExInquiryData = exInquiryData;
		ExOutputData = exOutputData;
	}
	
	public Size(int proj_id,int version_id, int sU, float uNFM, int inLogicalFiles, int exInterfaceFile, int exInputFiles,
			int exInquiryFiles, int exOutputFiles, int inLogicalData, int exInterfaceData, int exInputData,
			int exInquiryData, int exOutputData) {
		super();
		this.proj_id = proj_id;
		this.version_id =version_id;
		SU = sU;
		UNFM = uNFM;
		InLogicalFiles = inLogicalFiles;
		ExInterfaceFile = exInterfaceFile;
		ExInputFiles = exInputFiles;
		ExInquiryFiles = exInquiryFiles;
		ExOutputFiles = exOutputFiles;
		InLogicalData = inLogicalData;
		ExInterfaceData = exInterfaceData;
		ExInputData = exInputData;
		ExInquiryData = exInquiryData;
		ExOutputData = exOutputData;
	}
	
	public Size(){
		
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
	public int getSU() {
		return SU;
	}
	public void setSU(int sU) {
		SU = sU;
	}
	public float getUNFM() {
		return UNFM;
	}
	public void setUNFM(float uNFM) {
		UNFM = uNFM;
	}
	public int getInLogicalFiles() {
		return InLogicalFiles;
	}
	public void setInLogicalFiles(int inLogicalFiles) {
		InLogicalFiles = inLogicalFiles;
	}
	public int getExInterfaceFile() {
		return ExInterfaceFile;
	}
	public void setExInterfaceFile(int exInterfaceFile) {
		ExInterfaceFile = exInterfaceFile;
	}
	public int getExInputFiles() {
		return ExInputFiles;
	}
	public void setExInputFiles(int exInputFiles) {
		ExInputFiles = exInputFiles;
	}
	public int getExInquiryFiles() {
		return ExInquiryFiles;
	}
	public void setExInquiryFiles(int exInquiryFiles) {
		ExInquiryFiles = exInquiryFiles;
	}
	public int getExOutputFiles() {
		return ExOutputFiles;
	}
	public void setExOutputFiles(int exOutputFiles) {
		ExOutputFiles = exOutputFiles;
	}
	public int getInLogicalData() {
		return InLogicalData;
	}
	public void setInLogicalData(int inLogicalData) {
		InLogicalData = inLogicalData;
	}
	public int getExInterfaceData() {
		return ExInterfaceData;
	}
	public void setExInterfaceData(int exInterfaceData) {
		ExInterfaceData = exInterfaceData;
	}
	public int getExInputData() {
		return ExInputData;
	}
	public void setExInputData(int exInputData) {
		ExInputData = exInputData;
	}
	public int getExInquiryData() {
		return ExInquiryData;
	}
	public void setExInquiryData(int exInquiryData) {
		ExInquiryData = exInquiryData;
	}
	public int getExOutputData() {
		return ExOutputData;
	}
	public void setExOutputData(int exOutputData) {
		ExOutputData = exOutputData;
	}
	
}
