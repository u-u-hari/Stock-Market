<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-sm-8">
		<h4 class="p-2">Customer Help Desk</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Company</th>
					<th>Description</th>
					<th>Status</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="p">
					<tr>
						<td>${p.id }</td>
						<td>${p.company.name }</td>
						<td>
						${p.description }
						<c:if test="${p.status == 'Done' }">
						<br><b>Solution:</b><br>${p.solution }
						</c:if>
						</td>
						</td>
						<td>${p.status }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="col-sm-4">
	<h4 class="p-2">Raise Ticket</h4>
		<form method="post">
			<div class="form-group">
				<label>Select Company</label>
				<select name="compid" required class="form-control">
					<option value="">Select Company</option>
					<c:forEach items="${clist}" var="c">
						<option value="${c.id }">${c.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea name="description" required class="form-control" rows="3"></textarea>
			</div>
			
			<button class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>
</div>
</body>
</html>