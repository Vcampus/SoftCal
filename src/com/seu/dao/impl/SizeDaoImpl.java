package com.seu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seu.bean.Size;
import com.seu.dao.SizeDao;
import com.seu.exception.SizeNotFoundException;

public class SizeDaoImpl implements SizeDao {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Size> findByParams(String sql, Object... params) {
		Connection conn = null;List<Size> list = new ArrayList<Size>();
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
				int version_id =rs.getInt("version_id");
				int su =rs.getInt("SU");
				float unfm = rs.getFloat("UNFM");
				int inlogicalfiles =rs.getInt("InLogicalFiles");
				int exinterfacefile =rs.getInt("ExInterfaceFiles");
				int exinputfiles =rs.getInt("ExInputFiles");
				int exinquiryfiles =rs.getInt("ExInquiryFiles");
				int exoutputfiles =rs.getInt("ExOutputFiles");
				int inlogicaldata =rs.getInt("InLogicalData") ;
				int exinterfacedata =rs.getInt("ExInterfaceData");
				int exinputdata =rs.getInt("ExInputData");
				int exinquirydata =rs.getInt("ExInquiryData");
				int exoutputdata =rs.getInt("ExOutputData");
				Size size = new Size(id,proj_id,version_id,su,unfm,inlogicalfiles,exinterfacefile,exinputfiles,
						exinquiryfiles,exoutputfiles,inlogicaldata,exinterfacedata,exinputdata,
						exinquirydata,exoutputdata);
				list.add(size);
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
	public Size getByProj_idAndVersion_id (int proj_id,int version_id) throws SizeNotFoundException{
		// TODO Auto-generated method stub
		try {
			return findByParams("select * from size_info where proj_id = ? and version_id = ?",proj_id,version_id).get(0);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			throw new SizeNotFoundException();
		}
		
	}

	@Override
	public void Save(Size size) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("insert into size_info (proj_id,version_id,SU,UNFM,InLogicalFiles,"
					+ "ExInterfaceFiles,ExInputFiles,ExInquiryFiles,ExOutputFiles,InLogicalData,ExInterfaceData,"
					+ "ExInputData,ExInquiryData,ExOutputData) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ppsm.setInt(1, size.getProj_id());
			ppsm.setInt(2, size.getVersion_id());
			ppsm.setInt(3, size.getSU());
			ppsm.setFloat(4, size.getUNFM());
			ppsm.setInt(5, size.getInLogicalFiles());
			ppsm.setInt(6, size.getExInterfaceFile());
			ppsm.setInt(7, size.getExInputFiles());
			ppsm.setInt(8, size.getExInquiryFiles());
			ppsm.setInt(9, size.getExOutputFiles());
			ppsm.setInt(10, size.getInLogicalData());
			ppsm.setInt(11, size.getExInterfaceData());
			ppsm.setInt(12, size.getExInputData());
			ppsm.setInt(13, size.getExInquiryData());
			ppsm.setInt(14, size.getExOutputData());
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

	@Override
	public boolean Update(Size size) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");

			PreparedStatement ppsm = conn.prepareStatement("UPDATE size_info SET SU=?,UNFM=?,InLogicalFiles=?,"
					+ "ExInterfaceFiles=?,ExInputFiles=?,ExInquiryFiles=?,ExOutputFiles=?,inLogicalData=?,ExInterfaceData=?,"
					+ "ExInputData=?,ExInquiryData=?,ExOutputData=?  WHERE proj_id=? AND version_id=?");
			ppsm.setInt(1, size.getSU());
			ppsm.setFloat(2, size.getUNFM());
			ppsm.setInt(3, size.getInLogicalFiles());
			ppsm.setInt(4, size.getExInterfaceFile());
			ppsm.setInt(5, size.getExInputFiles());
			ppsm.setInt(6, size.getExInquiryFiles());
			ppsm.setInt(7, size.getExOutputFiles());
			ppsm.setInt(8, size.getInLogicalData());
			ppsm.setInt(9, size.getExInterfaceData());
			ppsm.setInt(10, size.getExInputData());
			ppsm.setInt(11, size.getExInquiryData());
			ppsm.setInt(12, size.getExOutputData());
			ppsm.setInt(13, size.getProj_id());
			ppsm.setInt(14, size.getVersion_id());
			System.out.println(ppsm.toString());
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
	
	

}
