package com.seu.cal;
import com.seu.bean.*;
import com.seu.dao.*;

public class DataCal {
	static int lag =53;
	float A;
	float B;
	static float sign=0.01f;
	 float E;
	float Em;
	float Pm;
	int SIZE;
public void SizeCal(Size size){
	
		int inlogUFP = 0;
		int exlogUFP = 0;
		int exputUFP = 0;
		int inoutUFP = 0;
		int exqurUFP = 0;
		int ILF = size.getInLogicalFiles();
		int ILD = size.getInLogicalData();

		int EIFF = size.getExInterfaceFile();
		int EIFD = size.getExInterfaceData();

		int EIF = size.getExInputFiles();
		int EID = size.getExInputData();

		int EQF = size.getExInquiryFiles();
		int EQD = size.getExInquiryData();

		int EOF = size.getExOutputFiles();
		int EOD = size.getExOutputData();
		if (ILF == 1) {// 内部逻辑文件
			if (ILD >= 1 && ILD <= 50)
				inlogUFP = 7;
			if (ILD > 50)
				inlogUFP = 10;

		} else if (ILF <= 5 && ILF >= 2) {
			if (ILD >= 1 && ILD <= 19)
				inlogUFP = 7;
			if (ILD <= 50 && ILD >= 20)
				inlogUFP = 10;
			if (ILD > 50)
				inlogUFP = 15;
		} else {
			if (ILD >= 1 && ILD <= 19)
				inlogUFP = 10;
			if (ILD > 19)
				inlogUFP = 15;
		}
		if (EIFF == 1) {// 外部接口文件
			if (EIFD >= 1 && EIFD <= 50)
				exlogUFP = 5;
			if (EIFD > 50)
				exlogUFP = 7;

		} else if (EIFF <= 5 && EIFF >= 2) {
			if (EIFD >= 1 && EIFD <= 19)
				exlogUFP = 5;
			if (EIFD <= 50 && EIFD >= 20)
				exlogUFP = 7;
			if (EIFD > 50)
				exlogUFP = 10;
		} else {
			if (EIFD >= 1 && EIFD <= 19)
				exlogUFP = 7;
			if (EIFD > 19)
				exlogUFP = 10;
		}
		if (EOF == 1 || EOF == 0) {// 外部输出
			if (EOD >= 1 && EOD <= 19)
				exputUFP = 4;
			if (EOD > 19)
				exputUFP = 5;

		} else if (EOF <= 3 && EOF >= 2) {
			if (EOD >= 1 && EOD <= 5)
				exputUFP = 4;
			if (EOD <= 19 && EOD >= 6)
				exputUFP = 5;
			if (EOD > 19)
				exputUFP = 7;
		} else {
			if (EOD >= 1 && EOD <= 5)
				exputUFP = 5;
			if (EOD > 5)
				exputUFP = 7;
		}
		if (EQF == 1 || EQF == 0) {// 外部查询
			if (EQD >= 1 && EQD <= 19)
				exqurUFP = 3;
			if (EQD > 19)
				exqurUFP = 4;

		} else if (EQF <= 3 && EQF >= 2) {
			if (EQD >= 1 && EQD <= 5)
				exqurUFP = 3;
			if (EQD <= 19 && EQD >= 6)
				exqurUFP = 4;
			if (EQD > 19)
				exqurUFP = 6;
		} else {
			if (EQD >= 1 && EQD <= 5)
				exqurUFP = 4;
			if (EQD > 5)
				exqurUFP = 6;
		}
		if (EIF == 1 || EIF == 0) {// 外部输入
			if (EID >= 1 && EID <= 15)
				inoutUFP = 3;
			if (EID > 15)
				inoutUFP = 4;

		} else if (EIF <= 3 && EIF >= 2) {
			if (EID >= 1 && EID <= 4)
				inoutUFP = 3;
			if (EID <= 15 && EID >= 5)
				inoutUFP = 4;
			if (EID > 15)
				inoutUFP = 6;
		} else {
			if (EID >= 1 && EID <= 4)
				inoutUFP = 4;
			if (EID > 4)
				inoutUFP = 6;
		}
	
	SIZE=(inlogUFP+ exlogUFP+ exputUFP+ inoutUFP+ exqurUFP)*lag;
	
	//未完
}
public void EIndexCal(EIndex eindex){
	float prec=eindex.getPREC();
	float flex=eindex.getFLEX();
	float resl=eindex.getRESL();
	float team=eindex.getTEAM();
	float pmat=eindex.getPMAT();

	 E=B+sign*prec*flex*resl*team*pmat;
}
public void EMCal(EM em){
	float cplx=em.getCPLX();
float time=	em.getTIME();
float pvol=	em.getPVOL();
float pcon=em.getPCON();
float apex=em.getAPEX();
float ltex=em.getLTEX();
float site=em.getSITE();
float rely=em.getRELY();
float docu=em.getDOCU();
float stor=	em.getSTOR();
float acap=em.getACAP();
float pcap=em.getPCAP();
float plex=em.getPLEX();
float tool=em.getTOOL();
float sced=em.getSCED();
	Em= cplx*time*pvol*pcon*apex*ltex*site*rely*docu*stor*acap*pcap*plex*tool*sced;
}

public void PMCal(){
	
	Pm=A*(float)Math.pow(SIZE, E)*Em;
}
}
