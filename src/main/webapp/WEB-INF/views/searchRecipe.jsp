<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div>
			<div>
				<c:choose>
					<c:when test="${fn:length(recipes) < 1}">
						<h1>No recipes found with ${searchQuery}</h1>
						<p class="lead">Search something else<p>
						<form method="POST" action="/recipe/search" class="navbar-search pull-right">
							<input type="text" class="search-query" placeholder="Search" name="param">
						</form>
						<p class="lead">Or..</p>
						<a class="btn btn-primary" href="/recipe/create">Create one yourself!</a>
					</c:when>
					<c:otherwise>
						<h1>Recipes found with ${searchQuery}:</h1>
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Problem</th>
									<th>Author</th>
									<th>Date Added</th>
									<th>ID</th>
								</tr>
							</thead>
							<tbody data-provides="rowlink">
								<c:forEach var="recipe" items='${recipes}'>
									<tr>
										<td><a class="rowlink" href="/recipe/${recipe.id}">${recipe.recipeTitle}</a></td>
										<td>${recipe.recipeProblemDescription}</td>
										<td>${recipe.recipeAuthor}</td>
										<td>${recipe.formatedCreationDate}</td>
										<td>${recipe.id}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<p class="lead">Search something else<p>
						<form method="POST" action="/recipe/search" class="navbar-search pull-right">
							<input type="text" class="search-query" placeholder="Search" name="param">
						</form>
						<p class="lead">Or..</p>
						<a class="btn btn-primary" href="/recipe/create">Create one yourself!</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>