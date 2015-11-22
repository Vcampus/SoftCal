package com.seu.dao;

import java.util.List;

import com.seu.bean.Size;
import com.seu.exception.SizeNotFoundException;

public interface SizeDao {
	List<Size> findByParams(String sql,Object...params);
	Size getByProj_idAndVersion_id(int proj_id,int version_id)throws SizeNotFoundException;
	Size getByProj_idAndVersion_idAndType(int proj_id,int version_id,int type)throws SizeNotFoundException;
	void Save(Size size);
	boolean Update(Size size);
}
