package com.seu.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seu.bean.EIndex;
import com.seu.dao.EIndexDao;
import com.seu.exception.EindexNotFoundException;

public class EIndexDaoImpl implements EIndexDao{
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
	public List<EIndex> findByParams(String sql, Object... params) {
			// TODO 自动生成的方法存根
		Connection conn = null;List<EIndex> list = new ArrayList<EIndex>();
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
					float prec =rs.getFloat("PREC");
					float flex =rs.getFloat("FLEX");
					float resl =rs.getFloat("RESL");
					float team =rs.getFloat("TEAM");
					float pmat =rs.getFloat("PMAT");
					float inputE = rs.getFloat("InputE");
					EIndex eindex= new EIndex(id,proj_id,version_id,prec,flex,resl,team,pmat,inputE);
					list.add(eindex);
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
		public EIndex getByProj_idAndVersion_id(int proj_id,int version_id) throws EindexNotFoundException{
			// TODO 自动生成的方法存根
			try {
				return findByParams("select * from e_info where proj_id = ? and version_id = ?",proj_id,version_id).get(0);
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				throw new EindexNotFoundException();
			}
			
		}
		
		@Override
		public EIndex getByProj_idAndVersion_idAndType(int proj_id,int version_id,int type)throws EindexNotFoundException {
			// TODO 自动生成的方法存根
			try {
				return findByParams("select * from e_info where proj_id = ? and version_id = ? and type = ? ",proj_id,version_id,type).get(0);
			} catch (IndexOutOfBoundsException e) {
				// TODO: handle exception
				throw new EindexNotFoundException();
			}
		}

		@Override
		public boolean Update(EIndex eIndex) {
			// TODO 自动生成的方法存根
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");

				PreparedStatement ppsm = conn.prepareStatement("UPDATE e_info SET PREC=?,FLEX=?,RESL=?,"
						+ "TEAM=?,PMAT=?,InputE=? WHERE proj_id=? AND version_id=? AND type=?");
				ppsm.setFloat(1,eIndex.getPREC());
				System.out.println(eIndex.getPREC());
				ppsm.setFloat(2,eIndex.getFLEX());
				System.out.println(eIndex.getFLEX());
				ppsm.setFloat(3, eIndex.getRESL());
				ppsm.setFloat(4, eIndex.getTEAM());
				ppsm.setFloat(5, eIndex.getPMAT());
				ppsm.setFloat(6, eIndex.getInputE());
				ppsm.setFloat(7, eIndex.getProj_id());
				ppsm.setFloat(8, eIndex.getVersion_id());
				ppsm.setInt(9, eIndex.getType());
				ppsm.executeUpdate();
				ppsm.close();
				return true;
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
			return false;
		}

		@Override
		public void Save(EIndex eindex) {
			// TODO 自动生成的方法存根
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
				PreparedStatement ppsm = conn.prepareStatement("insert into e_info (proj_id,version_id,PREC,"
						+ "FLEX,RESL,TEAM,PMAT,type) values (?,?,?,?,?,?,?,?)");
				ppsm.setInt(1, eindex.getProj_id());
				ppsm.setInt(2, eindex.getVersion_id());
				ppsm.setFloat(3, eindex.getPREC());
				ppsm.setFloat(4, eindex.getFLEX());
				ppsm.setFloat(5, eindex.getRESL());
				ppsm.setFloat(6, eindex.getTEAM());
				ppsm.setFloat(7, eindex.getPMAT());
				ppsm.setInt(8, eindex.getType());
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
		public EIndexDaoImpl() {
		// TODO Auto-generated constructor stub
	}

}
