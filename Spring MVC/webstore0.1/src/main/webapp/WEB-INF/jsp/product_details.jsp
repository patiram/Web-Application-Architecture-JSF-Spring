<%-- 
    Document   : product_details
    Created on : May 9, 2016, 3:03:11 PM
    Author     : patir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Products</h1>
                    <p>All the available products in our store</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div class="row">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>Name: ${product.name}</h3>
                                <p>Manufacturer: ${product.manufacturer}</p> 
                                <p>Description: ${product.description}</p>
                                <p>Unit Price: ${product.unitPrice} USD</p>
                                <p>Available units in stock: ${product.unitsInStock}</p>
<!--                                <p><a class="btn btn-info" role="button" href="../products">Back</a></p>-->
                                <p><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/products">Back</a><a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/productdetails/${product.productId}">Order Now</a></p>
                            </div>
                        </div>
                    </div>
            </div>
        </section>
    </body>
</html>