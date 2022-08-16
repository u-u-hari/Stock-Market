<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-sm-3">
		<div class="card shadow mt-2">
			<div class="card-header">
				<h5>Service Provider Details</h5>
			</div>
			<div class="card-body text-center">
				<img src="${stk.logo }" style="width:300px;">
				<h5>${stk.name }</h5>
			</div>
			<div class="card-footer">
				<h5>Current unit Price : ${stk.currentprice }</h5>
			</div>
		</div>
	</div>
	<!-- 
	<div class="col-sm-2">
		<h4 class="p-2">Unit Price Table</h4>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Date</th>
					<th>Unit Price</th>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prices }" var="p">
					<tr>
						<td>${p.date }</td>
						<td>${p.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	 -->
	<div class="col-sm-6">
		<canvas id="myChart"></canvas>
	</div>
	
	<div class="col-sm-3">
	<h4 class="p-2">Buy Now</h4>
	<c:if test="${sessionScope.userid ne null and sessionScope.role eq 'Customer' }">
		<form method="post" action="/buynow">
		<input type="hidden" name="custid" value="${sessionScope.id }">
		<input type="hidden" name="compid" value="${stk.id }">
			<div class="form-group">
				<label>Price per Unit</label>
				<input type="number" name="buyprice" value="${stk.currentprice }" readonly class="form-control">
			</div>
			<div class="form-group">
				<label>No. of Units</label>
				<input type="number" name="qty" min="1" required value="1" class="form-control">
			</div><button class="btn btn-primary">Buy Now</button><br><br>
			
			<form><script src="https://checkout.razorpay.com/v1/payment-button.js" data-payment_button_id="pl_IeV6aMPKKLvwX1" async> </script> </form>
		</form>
	</c:if>
	<c:if test="${sessionScope.userid eq null }">
		<h5>Login to subscribe to provider</h5>
	</c:if>
	</div>
</div>
</div>
<script>
// === include 'setup' then 'config' above ===
$(function(){
	let values=[];
	let dates=[];
	$.ajax({
		url:'/api/data/'+[[${stk.id}]],
		success: function(resp){
			console.log(resp)
			for(let item of resp){
				values.push(item.price);
				dates.push(item.date);
			}
			console.log(values)
			const data = {
			  labels: dates,
			  datasets: [{
			  	fill:'origin',
			    label: 'Market Flow for Shares',
			    backgroundColor: '#ebd7ef',
			    borderColor: '#c23cdd',
			    data: values,
			  }]
			};
			const config = {
			  type: 'line',
			  data: data,
			  options: {}
			};

			const myChart = new Chart(
			  document.getElementById('myChart'),
			  config
			);
		}
	})
})


</script>
</body>
</html>