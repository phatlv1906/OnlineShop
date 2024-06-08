package com.lvp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lvp.Connection.JDBCUtil;
import com.lvp.Model.product;

public class productDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//Lay 4 san pham moi nhat
	public List<product> getTop4Product(){
		List<product> listpro = new ArrayList<product>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product order by productId desc limit 4";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				listpro.add(new product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getInt(8)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listpro;
	}
	
	public List<product> getTop4BestProduct(){
		List<product> listpro = new ArrayList<product>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product order by Amount desc limit 4";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				listpro.add(new product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getInt(8)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listpro;
	}
	public product getTop1BestProduct(){
		product pro = new product();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product order by Amount desc limit 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setDescription(rs.getString(3));
				pro.setProprice(rs.getDouble(4));
				pro.setImgLink(rs.getString(5));
				pro.setCategoryId(rs.getInt(6));
				pro.setSellerId(rs.getInt(7));
				pro.setAmount(rs.getInt(8));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
	public static void main(String[] args) {
		productDao prodao = new productDao();
		List<product> listpro = prodao.getTop4BestProduct();
		for (product product : listpro) {
			System.out.println(product.getName());
		}
	}
}
