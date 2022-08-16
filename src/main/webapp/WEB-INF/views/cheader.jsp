<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Stock Market</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/bootstrap.js"></script>
	<link rel="icon" href="/images/logo.png" />
</head>
<body >
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#"><font color="green" style="font-size:30px">Electricity Billing System</font></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon" style="background-color:aqua;"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav" style="background-color:Gray;">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/stocks">Service Providers</a>
      </li>
      <c:if test="${sessionScope.userid eq null }">
      <li class="nav-item">
        <a class="nav-link" href="/login">Sign in</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/register">Customer Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cmpregister">Service Provider Register</a>
      </li>
      </c:if>
      <c:if test="${sessionScope.userid ne null }">
      
      <c:if test="${sessionScope.role eq 'Company' }">
      <li class="nav-item">
        <a class="nav-link" href="/updateprice">Update Price</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/stockholders">Customers List</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/helpdesk">Helpdesk</a>
      </li>
      </c:if>
      <c:if test="${sessionScope.role eq 'Customer' }">
      <li class="nav-item">
        <a class="nav-link" href="/mystocks">My Service Providers</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/help">Help</a>
      </li>
      </c:if>
      <li class="nav-item">
        <a class="nav-link" href="/">Hi !${sessionScope.uname }</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/logout">Logout</a>
      </li>
      </c:if>
    </ul>
  </div>
</nav>

