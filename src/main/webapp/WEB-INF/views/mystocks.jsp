<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container">
<div class="row">
	<div class="col-sm-8">
		<h4 class="p-2">My Service Providers</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Company</th>
					<th>Current Unit Price</th>
					<th>Buy Unit Price</th>	
					<th>Units Bought</th>
					<th>Action</th>			
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="p">
					<tr>
						<td><img src="${p.company.logo }" style="width:100px;"> ${p.company.name }</td>
						<td>${p.company.currentprice }</td>
						<td>${p.buyprice }</td>
						<td>${p.qty }</td>
						<td><a href="mystocks/${p.id}" class="btn btn-sm btn-primary">Pay Now</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="col-sm-4">
	<c:if test="${sell }">
	<h4 class="p-2">Sell Now</h4>
		<form method="post" action="/sellnow">
		<input type="hidden" name="id" value="${stk.id }">
			<div class="form-group">
				<label>Price per Stock</label>
				<input type="number" name="buyprice" value="${stk.company.currentprice }" readonly class="form-control">
			</div>
			<div class="form-group">
				<label>No. of Shares</label>
				<input type="number" name="qty" min="1" max="${stk.qty }" required value="1" class="form-control">
			</div>
			
			<button class="btn btn-primary">Sell Now</button>
		</form>
	</c:if>
	</div>
</div>
</div>
</body>
</html>