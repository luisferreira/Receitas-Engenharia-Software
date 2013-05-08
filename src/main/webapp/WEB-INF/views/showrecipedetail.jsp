<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div class="page-header">
			<h1>${recipe.recipeTitle}</h1>
		</div>
			<p class="lead">The problem:</p>
			<p>${recipe.recipeProblemDescription}</p>
		<div>
		</div>
		<div>
			<p class="lead">The solution:</p>
			<p>${recipe.recipeSolutionDescription}</p>
		</div>
		<div>
			<p class="lead">Metadata</p>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Date</th>
						<th>Author</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${recipe.id}</td>
						<td>${recipe.creationDate}</td>
						<td>${recipe.recipeAuthor}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
