<%-- 
    Document   : addProduct
    Created on : Apr 28, 2016, 9:14:54 PM
    Author     : Rakesh Shrestha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Products</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Products</h1>
                    <p>Add products</p>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal">
                <fieldset>
                    <legend>Add new product</legend>
				
                    <form:errors path="*" cssClass="text-danger"/>
                    <div class="form-group">
                        <!--<label class="control-label col-lg-2 col-lg-2" for="productId">Product Id</label>-->
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.productId.label"/> </label>
                        <div class="col-lg-10">
                            <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                             <form:errors path="productId" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <!--<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>-->
                        <!--<label class="control-label col-lg-2 col-lg-2" for="productId">Product Id</label>-->
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.name.label"/> </label>
                        <div class="col-lg-10">
                            <form:input id="name" path="name" type="text" class="form:input-large"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.unitPrice.label"/> </label>
                        <!--<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit Price</label>-->
                        <div class="col-lg-10">
                            <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                            <form:errors path="unitPrice" cssClass="text-danger"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.manufacturer.label"/> </label>
                        <!--<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>-->
                        <div class="col-lg-10">
                            <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.category.label"/> </label>
<!--                        <label class="control-label col-lg-2 col-lg-2" for="category">Category</label>-->
                        <div class="col-lg-10">
                            <form:input id="category" path="category" type="text" class="form:input-large"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.unitsInStock.label"/> </label>
                        <!--<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Units In Stock</label>-->
                        <div class="col-lg-10">
                            <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                        </div>
                    </div>

<!--                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Units In Order</label>
                        <div class="col-lg-10">
                            <%--<form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>--%>
                        </div>
                    </div>-->

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code= "addProduct.form.description.label"/> </label>
                        <!--<label class="control-label col-lg-2" for="description">Description</label>-->
                        <div class="col-lg-10">
                            <form:textarea id="description" path="description" rows="2"/>
                        </div>
                    </div>
<!--                    <div class="form-group">
                        <label class="control-label col-lg-2" for="discontinued">Discontinued</label>
                        <div class="col-lg-10">
                            <%--<form:checkbox  id="discontinued" path="discontinued"/>--%>
                        </div>
                    </div>-->

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="condition">Condition</label>
                        <div class="col-lg-10">
                            <form:radiobutton path="condition" value="New" />New 
                            <form:radiobutton path="condition" value="Old" />Old 
                            <form:radiobutton path="condition" value="Refurbished" />Refurbished
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>
