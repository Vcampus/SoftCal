package com.seu.dao;

import java.util.List;

import com.seu.bean.Version;;

public interface VersionDao {
	List<Version> findByParams(String sql,Object...params);
	Version getByName(String name);
	void Save(Version version);
}
