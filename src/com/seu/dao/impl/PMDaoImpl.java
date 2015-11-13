package com.seu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seu.bean.PM;
import com.seu.dao.PMDao;

public class PMDaoImpl implements PMDao{
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<PM> findByParams(String sql, Object... params) {
		// TODO 自动生成的方法存根
		Connection conn = null;List<PM> list = new ArrayList<PM>();
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
				int version_id=rs.getInt("version_id");
				float pM_exp=rs.getFloat("PM_exp");
				float pM_real=rs.getFloat("PM_real");
				float pM_adj =rs.getFloat("PM_adj");
				PM newpm =new PM(id,proj_id,version_id,pM_exp,pM_real,pM_adj);
				list.add(newpm);
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
	public PM getByProj_idAndVersion_id(int proj_id,int version_id) {
		// TODO 自动生成的方法存根
		return findByParams("select * from pm_info where proj_id = ? and version_id = ?",proj_id,version_id).get(0);
	}

	@Override
	public void Save(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("insert into version_info (proj_id,proj_name,version) values (?,?,?)");
			ppsm.setInt(1, pm.getProj_id());
			ppsm.setInt(2, pm.getVersion_id()); 
			ppsm.setFloat(3, pm.getPM_exp());
			ppsm.setFloat(4, pm.getPM_real());
			ppsm.setFloat(5, pm.getPM_adj());
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
