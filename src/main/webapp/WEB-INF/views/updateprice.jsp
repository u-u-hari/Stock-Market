<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container">
<div class="row">
	<div class="col-sm-7">
		<h4 class="p-2">Unit Price Table</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Date</th>
					<th>Unit Price</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prices }" var="p">
					<tr>
						<td>${p.id }</td>
						<td>${p.date }</td>
						<td>${p.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="col-sm-5">
	<h4 class="p-2">Update Price</h4>
		<form method="post">
		<input type="hidden" name="compid" value="${sessionScope.id }">
			<div class="form-group">
				<label>Date</label>
				<input type="date" name="udate" class="form-control">
			</div>
			<div class="form-group">
				<label>Unit Price</label>
				<input type="number" name="price" class="form-control">
			</div>
			
			<button class="btn btn-primary">Update Unit Price</button>
		</form>
	</div>
</div>
</div>
</body>
</html>