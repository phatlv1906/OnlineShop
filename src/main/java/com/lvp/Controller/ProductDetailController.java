package com.lvp.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvp.Dao.categoryDao;
import com.lvp.Dao.productDao;
import com.lvp.Model.category;
import com.lvp.Model.product;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//Get id cua category
		String cid = request.getParameter("cid");
		//Product
		//Khoi tao DAO
		productDao prodao = new productDao();
		//Get san pham theo id
		String proId = request.getParameter("productId");
		product getProduct = prodao.getProductById(proId);
		request.setAttribute("getproduct", getProduct);
		
		//Category
		categoryDao categoryDao = new categoryDao();
		List<category> listCategories = categoryDao.getCategory();

		
		request.setAttribute("listcategory", listCategories);
		RequestDispatcher rd = request.getRequestDispatcher("/views/productdetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
