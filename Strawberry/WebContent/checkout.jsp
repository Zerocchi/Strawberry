<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thanks for ordering!</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">


     <!-- Main component for a primary marketing message or call to action -->
     <div class="jumbotron">
       <h1></h1>
     </div>
     
     <div class="container" style="margin-top:40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading" align="center">
						<strong> Done!</strong>
					</div>
					<div class="panel-body">
						<div class="form-group" align="center">
							<c:set var="totalPrice"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalPrice}" /></c:set>
							Thanks for ordering with us! Your order ID is <strong>${orderId}</strong>. Please write it down on a medium.
							Total price of your ordering is RM<strong>${totalPrice}</strong>.
						</div>
						<div class="form-group" align="center">
							<a class="btn btn-sm btn-default" href="index.jsp">
							<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>Back to Main Menu</a>
						</div>
					</div>
					<div class="panel-footer ">
						© Strawberry Cafe 2015
					</div>
                </div>
			</div>
		</div>
	</div>

	</div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>