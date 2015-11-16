package com.seu.dao;

import java.util.List;

import com.seu.bean.EM;
import com.seu.exception.EmNotFoundException;

public interface EMDao {
	List<EM> findByParams(String sql,Object...params);
	EM getByProj_idAndVersion_id(int proj_id,int version_id)throws EmNotFoundException;
	void Save(EM em);
	boolean Update(EM em);
}
