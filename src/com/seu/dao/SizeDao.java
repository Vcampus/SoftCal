package com.seu.dao;

import java.util.List;

import com.seu.bean.Size;;

public interface SizeDao {
	List<Size> findByParams(String sql,Object...params);
	Size getByProj_idAndVersion_id(int proj_id,int version_id);
	void Save(Size size);
	boolean Update(Size size);
}
