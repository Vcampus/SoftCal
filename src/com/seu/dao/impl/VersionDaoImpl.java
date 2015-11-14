package com.seu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seu.bean.Version;
import com.seu.dao.VersionDao;
import com.seu.exception.VersionExistedException;

public class VersionDaoImpl implements VersionDao{
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Version> findByParams(String sql, Object... params) {
		// TODO 自动生成的方法存根
		Connection conn = null;List<Version> list = new ArrayList<Version>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement(sql);
			for(int i = 0;i<params.length;i++){
				ppsm.setObject(i+1, params[i]);
			}
			ResultSet rs = ppsm.executeQuery();	
			while(rs.next()){
				int id = rs.getInt("id");
				int proj_id = rs.getInt("proj_id");
				String proj_name = rs.getString("proj_name");
				String version = rs.getString("version");
				Version Version = new Version(id,proj_id,proj_name,version);
				list.add(Version);
			}
			ppsm.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Version getByVesionProjID(int id,String version) {
		// TODO 自动生成的方法存根
		return findByParams("select * from version_info where proj_id = ? and version = ?",id,version).get(0);
	}

	@Override
	public void Save(Version version) throws VersionExistedException{
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("insert into version_info (proj_id,proj_name,version) values (?,?,?)");
			if(!findByParams("select * from version_info where proj_id = ? and version = ?",version.getProj_id(),version.getVersion()).isEmpty())
				throw new VersionExistedException();
			ppsm.setInt(1, version.getProj_id());
			ppsm.setString(2, version.getProj_name());
			ppsm.setString(3, version.getVersion());
			ppsm.execute();
			ppsm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
