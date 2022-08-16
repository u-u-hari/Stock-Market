<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid" style="background-color:lightblue;">
	<div class="row">
			<div class="col-sm-4 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center bg-dark text-white" >
						<h5>User Register</h5>
					</div>
					<div class="card-body" style="background-color:AliceBlue;">
						<form method="post">
						<div class="form-group">
						<label>Name</label>
						<input type="text" name="name" required class="form-control">
						</div>
						<div class="form-group">
						<label>Gender</label>
						<select name="gender" required class="form-control">	
						<option>Male</option>
						<option>Female</option>
						</select>
						</div>
						<div class="form-group">
						<label>Phone</label>
						<input type="text" maxlength="10" name="phone" required class="form-control">
						</div>
						<div class="form-group">
						<label>Email</label>
						<input type="email" name="email" required class="form-control">
						</div>
						<div class="form-group">
						<label>Address</label>
						<input type="text" name="address" required class="form-control">
						</div>
						<div class="form-group">
						<label>Aadhar</label>
						<input type="text" name="adhar" required class="form-control">
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