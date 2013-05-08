<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div id="overview" class="jumbotron subhead">
		<div class="container">
			<h1>Software Cookbook</h1>
			<p>Common solutions to software-related problems</p>
				<a href="google.com">ddd</a>
				<a class="btn btn-primary btn-large" href="/recipes/create">Add
					your own!</a>
		</div>
	</div>
	<c:if test="${fn:length(recipes) > 0}">
		<div class="container">
			<div>
				<h1>Latest recipes added</h1>
				<table class="table table-hover" data-provides="rowlink">
					<thead>
						<tr>
							<th>Recipe</th>
							<th>Description</th>
							<th>Author</th>
							<th>Added</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="recipe" items='${recipes}'>
							<tr>
								<td><a href="/recipes/${recipe.id}">${recipe.recipeTitle}</a></td>
								<td>${recipe.recipeProblemDescription}</td>
								<td>${recipe.recipeAuthor}</td>
								<td>${recipe.creationDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>