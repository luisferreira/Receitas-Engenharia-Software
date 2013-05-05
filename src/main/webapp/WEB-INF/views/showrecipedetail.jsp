<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>${recipe.getRecipetitle()}</h1>
	</div>
	<p class="lead">The problem:</p>
	<p>${recipe.getRecipeProblemDescription()}</p>
	<div></div>
	<div>
		<p class="lead">The solution:</p>
		<p>${recipe.getRecipeSolutionDescription()}</p>
	</div>
	<div>
		<!-- <p class="lead">Metadata</p> -->
		<!-- <table class="table-striped">
			<thead>
				<tr>
					<th>Version</th>
					<th>Added</th>
					<th>Author</th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				
			</tbody>
		</table> -->
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>