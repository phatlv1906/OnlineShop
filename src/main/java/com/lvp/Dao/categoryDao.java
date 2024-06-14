package com.lvp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lvp.Connection.JDBCUtil;
import com.lvp.Model.category;

public class categoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<category> getCategory(){
		List<category> listCategory = new ArrayList<category>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				listCategory.add(new category(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCategory;
	}
	public static void main(String[] args) {
		categoryDao dao = new categoryDao();
		System.out.println(dao.getCategory().toString());
	}
}
