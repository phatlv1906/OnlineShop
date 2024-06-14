package com.lvp.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class ProductController
 */
@WebServlet(urlPatterns = {"/product", "/san-pham" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductController() {
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
		//top4 san pham them sau cung
		List<product> list4Product = prodao.getTop4Product();
		//top 4 san pham ban nhieu
		List<product> list4Best = prodao.getTop4BestProduct();
		//san pham ban nhieu nhat
		product bestpro = prodao.getTop1BestProduct();
		//List tat ca san pham
		List<product> listProductByCateid = new ArrayList<product>();

		//load cid cho tag active
		request.setAttribute("tagActive", cid);
		
		//Category
		categoryDao categoryDao = new categoryDao();
		List<category> listCategories = categoryDao.getCategory();

		Map<category, List<product>> categoryProductMap = new HashMap<>();

	    for (category category : listCategories) {
	         List<product> products = prodao.filterProductByCategory(category.getId());
	         categoryProductMap.put(category, products);
	    }
		if(cid != null) {
			listProductByCateid = prodao.filterProductByCategory(cid);
			
		}else {
			listProductByCateid = prodao.getAllProduct();
		    
		}
		request.setAttribute("listallproduct", listProductByCateid);
		request.setAttribute("listcategory", listCategories);
		request.setAttribute("bestProduct", bestpro);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/product.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
