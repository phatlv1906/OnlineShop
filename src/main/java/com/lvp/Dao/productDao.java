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
	public List<product> getAllProduct(){
		List<product> listpro = new ArrayList<product>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product";
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
		product pro = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product order by Amount desc limit 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				pro = new product();
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
	public product getProductById(String id){
		product pro = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product where productId = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pro = new product();
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
	public List<product> filterProductByCategory(String cateId){
		List<product> listPro = new ArrayList<product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product where categoryId = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cateId);
			rs = ps.executeQuery();
			while(rs.next()) {
				listPro.add(new product(rs.getInt(1), 
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
		return listPro;
	}
	public List<product> filterProductByCategory(int cateId){
		List<product> listPro = new ArrayList<product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product where categoryId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			rs = ps.executeQuery();
			while(rs.next()) {
				listPro.add(new product(rs.getInt(1), 
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
		return listPro;
	}
	public List<product> searchProduct(String a){
		List<product> listPro = new ArrayList<product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "Select * from product where productName LIKE N?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"  + a + "%");
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while(rs.next()) {
				listPro.add(new product(rs.getInt(1), 
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
		return listPro;
	}
	public static void main(String[] args) {
		productDao proDao = new productDao();
		List<product> a = proDao.searchProduct("bé");
		System.out.println(a.toString());
	}
}
