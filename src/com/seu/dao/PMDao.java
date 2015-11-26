package com.seu.dao;

import java.util.List;

import com.seu.bean.PM;
import com.seu.exception.PmNotFoundException;

public interface PMDao {
	List<PM> findByParams(String sql,Object...params);
	PM getByProj_idAndVersion_id(int proj_id,int version_id)throws PmNotFoundException;
	void Save(PM pm);
	void updateExp(PM pm);
	void updateReal(PM pm);
	void updateAdjA(PM pm);
	void updateAdjAB(PM pm);
	void updateDate(PM pm);
}
