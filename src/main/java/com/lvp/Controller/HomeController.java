package com.lvp.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvp.Dao.productDao;
import com.lvp.Model.product;
@WebServlet(urlPatterns = {"/home", "/trangchu"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//Khoi tao DAO
		productDao prodao = new productDao();
		//top4 san pham them sau cung
		List<product> list4Product = prodao.getTop4Product();
		//top 4 san pham ban nhieu
		List<product> list4Best = prodao.getTop4BestProduct();
		//san pham ban nhieu nhat
		product bestpro = prodao.getTop1BestProduct();
		req.setAttribute("list4", list4Product);
		req.setAttribute("list4best", list4Best);
		req.setAttribute("probest", bestpro);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
