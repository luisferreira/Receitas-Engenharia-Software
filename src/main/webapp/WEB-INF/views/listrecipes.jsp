<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div>
			<div>
				<c:choose>
					<c:when test="${fn:length(recipes) < 1}">
						<h1>There are no recipes yet :(</h1>
						<a class="btn btn-primary btn-large" href="/recipes/create">Good. I'll create one myself!</a>
						<a class="btn btn-primary btn-large" href="/">Oh nay! Get me back to the homepage, then.</a>
					</c:when>
					<c:otherwise>
						<h1>Recipes</h1>
						<table class="table table-hover" data-provides="rowlink">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Problem</th>
									<th>Author</th>
									<th>Date Added</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="recipe" items='${recipes}'>
									<tr>
										<td><a href="/recipes/${recipe.id}">${recipe.id}</a></td>
										<td>${recipe.recipeTitle}</td>
										<td class="nolink">${recipe.recipeProblemDescription}</td>
										<td class="nolink">${recipe.recipeAuthor}</td>
										<td class="nolink">${recipe.creationDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>