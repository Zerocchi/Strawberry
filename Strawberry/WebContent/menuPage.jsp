<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Insert title here</title>
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
							Now that you have placed your order, time to proceed to menu selection.
						</div>
						<div class="form-group" align="center">
							<a class="btn btn-sm btn-primary" href="OrderMenu?action=listMenu&orderId=<c:out value="${orderlist.orderId}"/>">
							<span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>Proceed to menu selection</a>
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

${orderlist.orderId}

</body>
</html>