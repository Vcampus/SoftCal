package com.seu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seu.bean.EM;
import com.seu.dao.EMDao;

public class EMDaoImpl implements EMDao {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<EM> findByParams(String sql, Object... params) {
		// TODO 自动生成的方法存根
		Connection conn = null;List<EM> list = new ArrayList<EM>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement(sql);
			for(int i = 0;i<params.length;i++){
				ppsm.setObject(i+1, params[i]);
			}
			ResultSet rs = ppsm.executeQuery();	
			while(rs.next()){
				int id = rs.getInt("id");
				int proj_id =rs.getInt("proj_id");
				int version_id =rs.getInt("version_id");
				float cpex =rs.getFloat("CPEX");
				float time =rs.getFloat("TIME");
				float pvol =rs.getFloat("PVOL");
				float pcon =rs.getFloat("PCON");
				float apex =rs.getFloat("APEX");
				float ltex =rs.getFloat("LTEX");
				float site =rs.getFloat("SITE");
				float rely =rs.getFloat("RELY");
				float docu =rs.getFloat("DOCU");
				float stor =rs.getFloat("STOR");
				float acap =rs.getFloat("ACAP");
				float pcap =rs.getFloat("PCAP");
				float plex =rs.getFloat("PLEX");
				float tool =rs.getFloat("TOOL");
				float sced =rs.getFloat("SCED");
				EM em = new EM(id,proj_id,version_id,cpex,time,pvol,pcon,apex,ltex,site,rely,docu,stor,acap,pcap,plex,tool,sced);
				list.add(em);
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
	public EM getByProj_idAndVersion_id(int proj_id,int version_id) {
		// TODO 自动生成的方法存根
		return findByParams("select * from em_info where proj_id = ? and version_id = ?",proj_id,version_id).get(0);
	}
	
	@Override
	public void Save(EM em) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("insert into em_info (proj_id,version_id,CPLX, "
					+ "TIME,PVOL ,PCON ,APEX ,LTEX ,SITE ,RELY ,DOCU ,STOR ,ACAP ,PCAP ,PLEX ,"
					+ "TOOL ,SCED) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ppsm.setInt(1, em.getProj_id());
			ppsm.setInt(2, em.getVersion_id());
			ppsm.setFloat(3,em.getCPLX());
			ppsm.setFloat(4,em.getTIME());
			ppsm.setFloat(5,em.getPVOL());
			ppsm.setFloat(6,em.getPCON());
			ppsm.setFloat(7,em.getAPEX());
			ppsm.setFloat(8,em.getLTEX());
			ppsm.setFloat(9,em.getSITE());
			ppsm.setFloat(10,em.getRELY());
			ppsm.setFloat(11,em.getDOCU());
			ppsm.setFloat(12,em.getSTOR());
			ppsm.setFloat(13,em.getACAP());
			ppsm.setFloat(14,em.getPCAP());
			ppsm.setFloat(15,em.getPLEX());
			ppsm.setFloat(16,em.getTOOL());
			ppsm.setFloat(17,em.getSCED());
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
