<c:if test="${not empty successMsg}">
	<div class="alert alert-success">
		<strong>${successMsg}</strong>
	</div>
</c:if>
<c:if test="${not empty dangerMsg}">
	<div class="alert alert-danger">
		<strong>${dangerMsg}</strong>
	</div>
</c:if>