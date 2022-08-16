<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container">
<div class="row">
	<div class="col-sm-12">
		<h4 class="p-2 text-center">Our Customers</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Customer</th>
					<th>Address</th>
					<th>Email Id</th>
					<th>Phone no</th>
					<th>Current Unit Price</th>
					<th>Buy Unit Price</th>	
					<th>Units Bought</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="p">
					<tr>
						<td>${p.customer.name }</td>
						<td>${p.customer.address }</td>
						<td>${p.customer.email }</td>
						<td>${p.customer.phone }</td>
						<td>${p.company.currentprice }</td>
						<td>${p.buyprice }</td>
						<td>${p.qty }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>