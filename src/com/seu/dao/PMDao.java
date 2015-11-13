package com.seu.dao;

import java.util.List;

import com.seu.bean.PM;

public interface PMDao {
	List<PM> findByParams(String sql,Object...params);
	PM getByProj_idAndVersion_id(int proj_id,int version_id);
	void Save(PM pm);
}
