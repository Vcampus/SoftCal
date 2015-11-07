package com.seu.dao;

import java.util.List;

import com.seu.bean.Proj;

public interface ProjDao {
	List<Proj> findByParams(String sql,Object...params);
	Proj getByVersion(String version);
	void Save(Proj proj);
}
