<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div class="page-header">
			<h1>${recipe.recipeTitle}</h1>
		</div>
		<div class="row-fluid">
			<div class="span5">
				<div>
					<p class="lead">The problem:</p>
					<table class="table table-striped table-bordered">
						<tbody>
							<tr><td>${recipe.recipeProblemDescription}</td></tr>
						</tbody>
					</table>
				</div>
				<div class="row">&nbsp;</div>
				<div>
					<p class="lead">The solution:</p>
					<table class="table table-striped table-bordered">
						<tbody>
							<tr><td>${recipe.recipeSolutionDescription}</td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="span4">
				<p class="lead text-right">Metadata</p>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Version</th>
							<th>Date</th>
							<th>Author</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${recipe.recipeVersion}</td>
							<td>${recipe.formatedCreationDate}</td>
							<td>${recipe.recipeAuthor}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
