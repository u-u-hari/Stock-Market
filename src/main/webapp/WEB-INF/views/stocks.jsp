<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="main" style="background-color:palegreen;">

	<div class="content">

		<div class="container-fluid" >
			<div class="row">
				<c:forEach items="${prods }" var="p">
					<div class="col-sm-3">
						<div class="card shadow my-1" style="border-radius: 500px; background-color:white;" bgcolor="blue">

							<div class="card-body text-center" >
								<a href="details/${p.id}"> <img
									style="height: 250px; border-radius: 10px 30px;" class="img-thumbnail card-img-top"
									src="${p.logo}" alt="" /></a>
								<h2 class="p-2 font-weight-bold" style="font-size: 20px;">${p.name}</h2>
								<p style="margin-bottom: 15px;">
									Stock Price: <span>&#8377;${p.currentprice}</span>
								</p>
								<div class="button" style="margin: auto">
									<a href="details/${p.id}"
										class="btn btn-success btn-block"><i class="fa fa-cart"></i>Show Details</a>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<jsp:include page="cfooter.jsp"></jsp:include>