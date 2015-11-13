package com.seu.dao;

import java.util.List;

import com.seu.bean.EIndex;

public interface EIndexDao {
	List<EIndex> findByParams(String sql,Object...params);
	EIndex getByProj_idAndVersion_id(int proj_id,int verison_id);
	void Save(EIndex eindex);
}
