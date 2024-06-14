<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/lib/taglib.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <%@include file="/WEB-INF/lib/lib.jsp" %>
</head>
<body>

<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/home">Home</a></li>
                    <li class="breadcrumb-item"><a href="category.html">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Sub-category</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                <c:forEach items="${listcategory}" var="o">
                    <li class="list-group-item ${tagActive == o.id ? "active" : "" } "><a href="product?cid=${o.id}">${o.icon} ${o.cateName }</a></li>
				</c:forEach>
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Last product</div>
                <div class="card-body">
                    <img class="img-fluid" src="${bestProduct.imgLink }" />
                    <h5 class="card-title">${bestProduct.name }</h5>
                    <p class="card-text">${bestProduct.description}</p>
                    <p class="bloc_left_price">${bestProduct.proprice} $</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row">
         <c:forEach items="${listallproduct}" var="pro">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="card">
                        <img class="card-img-top" src="${pro.imgLink}" alt="Card image cap" style="height: 300px">
                        <div class="card-body">
                            <h4 class="card-title"><a href="productdetail?productId=${pro.id}" title="View Product">${pro.name}</a></h4>
                            <p class="card-text">${pro.description}</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block">${pro.proprice} $</p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
             </c:forEach>   
       <!--          <c:forEach var="entry" items="${categoryProductMap}">
			    <h2>${entry.key.cateName}</h2>
			    <div class="row">
			        <c:forEach var="pro" items="${entry.value}">
			            <div class="col-12 col-md-6 col-lg-4">
			                <div class="card">
			                    <img class="card-img-top" src="${pro.imgLink}" alt="Card image cap" style="height: 300px">
			                    <div class="card-body">
			                        <h4 class="card-title"><a href="productdetail?productId=${pro.id}" title="View Product">${pro.name}</a></h4>
			                        <p class="card-text">${pro.description}</p>
			                        <div class="row">
			                            <div class="col">
			                                <p class="btn btn-danger btn-block">${pro.proprice} $</p>
			                            </div>
			                            <div class="col">
			                                <a href="#" class="btn btn-success btn-block">Add to cart</a>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			        </c:forEach>
			    </div>
			</c:forEach>  --> 
                <div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active">
                                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Footer -->
<%@include file="footer.jsp" %>

<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
