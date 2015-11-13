package com.seu.dao;

import java.util.List;

import com.seu.bean.Version;;

public interface VersionDao {
	List<Version> findByParams(String sql,Object...params);
	Version getByVesionProjID(int id,String version);
	void Save(Version version);
}