<%@ include file="/WEB-INF/views/common/header.jsp"%>
<html>
<head>
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
</div>
</html>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Version</th>
					<th>Added</th>
					<th>Author</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>${recipe.getRecipeversion()}</td>
					<td>${recipe.getCreationData()}</td>
					<td>${recipe.getRecipeAuthor()}</td>
				</tr>

			</tbody>
		</table>
	</div>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>