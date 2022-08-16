<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container">
<div class="row">
	<div class="col-sm-8">
		<h4 class="p-2">Company Helpdesk</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Customer</th>
					<th>Description</th>
					<th>Status</th>
					<th>Action</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="p">
					<tr>
						<td>${p.id }</td>
						<td>${p.customer.name }</td>
						<td>
						${p.description }
						<c:if test="${p.status == 'Done' }">
						<br><b>Solution:</b><br>${p.solution }
						</c:if>
						</td>
						<td>${p.status }</td>
						<td><a href="/helpdesk/${p.id }" class="btn btn-sm btn-primary">Process</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="col-sm-4">
	<c:if test="${process }">
	<h4 class="p-2">Process Ticket</h4>
		<form method="post" action="/processhelp">
			<input type="hidden" name="id" value="${hd.id }">
			<div class="form-group">
				<label>Customer </label>
				<input type="text" class="form-control" value="${hd.customer.name }" rows="3"></textarea>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea name="description" readonly required class="form-control" rows="3">${hd.description }</textarea>
			</div>
			<div class="form-group">
				<label>Solution</label>
				<textarea name="solution" required class="form-control" rows="3"></textarea>
			</div>
			
			<button class="btn btn-primary">Submit</button>
		</form>
	</c:if>
	</div>
</div>
</div>
</body>
</html>