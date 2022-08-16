<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid" style="background-color:lightblue;">
	<div class="row">
			<div class="col-sm-4 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center bg-dark text-white">
						<h5>Listing</h5>
					</div>
					<div class="card-body" style="background-color:AliceBlue;">
						<form method="post" enctype="multipart/form-data">
						<div class="form-group">
						<label> Company Name*</label>
						<input type="text" name="name" required class="form-control">
						</div>
						<div class="form-group">
						<label>Toll-Free*</label>
						<input type="text" name="phone" maxlength="10" required class="form-control">
						</div>
						<div class="form-group">
						<label>Location*</label>
						<input type="text" name="address" required class="form-control">
						</div>
						<div class="form-group">
						<label>Unit Price*</label>
						<input type="text" name="stockprice" required class="form-control">
						</div>
						<div class="form-group">
						<label>Logo*</label>
						<input type="file" name="photo" accept=".jpg,.png" required class="form-control-file">
						</div>						
						<div class="form-group">
						<label>E-mail*</label>
						<input type="text" name="email" required class="form-control">
						</div>
						<div class="form-group">
						<label>Password</label>
						<input type="password" name="pwd" required class="form-control">
						</div>
						<input type="submit" value="Register" class="btn btn-primary float-right px-4">
					</form>
					<c:if test="${error ne null }">
					<div class="alert text-danger font-weight-bold">${error }</div>
					</c:if>
					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>