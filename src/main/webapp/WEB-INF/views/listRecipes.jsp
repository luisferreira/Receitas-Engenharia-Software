<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<c:if test="${deletionMessage eq 'deleted'}">
			<div class="span12 pagination-centered">
				<div id="saveSuccessMessage" class = "alert alert-info fade in" data-alert = "alert">
  					<a class="close" href="#">×</a>
					<p>Recipe deleted!</p>
				</div>
			</div> 
		</c:if>
		<div>
			<div>
				<c:choose>
					<c:when test="${fn:length(recipes) < 1}">
						<h1>There are no recipes yet :(</h1>
						<a class="btn btn-primary btn-large" href="/recipe/create">Good. I'll create one myself!</a>
						<a class="btn btn-primary btn-large" href="/">Oh nay! Get me back to the homepage, then.</a>
					</c:when>
					<c:otherwise>
						<h1>Recipes</h1>
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Problem</th>
									<th>Author</th>
									<th>Last Change</th>
								</tr>
							</thead>
							<tbody data-provides="rowlink">
								<c:forEach var="recipe" items='${recipes}'>
									<tr>
										<td><a class="rowlink" href="/recipe/${recipe.externalId}">${recipe.lastVersion.title}</a></td>
										<td>${recipe.lastVersion.problem}</td>
										<td>${recipe.lastVersion.author}</td>
										<td>${recipe.lastVersion.getFormatedCreationDate()}</td>
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