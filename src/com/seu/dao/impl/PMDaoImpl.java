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
import com.seu.exception.PmNotFoundException;

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
				float pM_adjA =rs.getFloat("PM_adjA");
				float pM_adjAB =rs.getFloat("PM_adjAB");
				PM newpm =new PM(id,proj_id,version_id,pM_exp,pM_real,pM_adjA,pM_adjAB);
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
	public PM getByProj_idAndVersion_id(int proj_id,int version_id) throws PmNotFoundException{
		// TODO 自动生成的方法存根
		try {
			return findByParams("select * from pm_info where proj_id = ? and version_id = ?",proj_id,version_id).get(0);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			throw new PmNotFoundException();
		}
	}

	@Override
	public void Save(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("insert into pm_info (proj_id,version_id) values (?,?)");
			ppsm.setInt(1, pm.getProj_id());
			ppsm.setInt(2, pm.getVersion_id()); 
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
	public void updateExp(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("UPDATE pm_info SET  PM_exp=? WHERE proj_id=? AND version_id=?");
			ppsm.setFloat(1, pm.getPM_exp());
			ppsm.setInt(2, pm.getProj_id());
			ppsm.setInt(3, pm.getVersion_id());
			System.out.println(ppsm.toString());
			ppsm.executeUpdate();
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
	public void updateReal(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("UPDATE pm_info SET  PM_real=? WHERE proj_id=? AND version_id=?");
			ppsm.setFloat(1, pm.getPM_real());
			ppsm.setInt(2, pm.getProj_id());
			ppsm.setInt(3, pm.getVersion_id());
			System.out.println(ppsm.toString());
			ppsm.executeUpdate();
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
	public void updateAdjA(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("UPDATE pm_info SET  PM_adjA=? WHERE proj_id=? AND version_id=?");
			ppsm.setFloat(1, pm.getPM_adjA());
			ppsm.setInt(2, pm.getProj_id());
			ppsm.setInt(3, pm.getVersion_id());
			System.out.println(ppsm.toString());
			ppsm.executeUpdate();
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
	public void updateAdjAB(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("UPDATE pm_info SET  PM_adjAB=? WHERE proj_id=? AND version_id=?");
			ppsm.setFloat(1, pm.getPM_adjAB());
			ppsm.setInt(2, pm.getProj_id());
			ppsm.setInt(3, pm.getVersion_id());
			System.out.println(ppsm.toString());
			ppsm.executeUpdate();
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
	public void updateDate(PM pm) {
		// TODO 自动生成的方法存根
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/softcal","root","");
			PreparedStatement ppsm = conn.prepareStatement("UPDATE pm_info SET  startYear=?,endYear=?,startMonth=?,endMonth=? WHERE proj_id=? AND version_id=?");
			ppsm.setInt(1, pm.getStartYear());
			ppsm.setInt(2, pm.getEndYear());
			ppsm.setInt(3, pm.getStartMonth());
			ppsm.setInt(4, pm.getEndMonth());
			ppsm.setInt(5, pm.getProj_id());
			ppsm.setInt(6, pm.getVersion_id());
			System.out.println(ppsm.toString());
			ppsm.executeUpdate();
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
