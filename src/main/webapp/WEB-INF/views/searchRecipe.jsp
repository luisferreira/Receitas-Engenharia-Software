<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div>
			<div>
				<c:choose>
					<c:when test="${fn:length(recipes) < 1}">
						<h1>No recipes found with keyword(s) "${searchQuery}"</h1>
						<p class="lead">Search something else<p>
						<form method="POST" action="/recipe/search" class="form-search">
							<div class="input-append">
								<input type="text" class="input-xxlarge search-query" placeholder="Search" name="param" required>
								<button class="btn" type="submit">Search</button>
							</div>
						</form>
						<p class="lead">Or..</p>
						<a class="btn btn-primary" href="/recipe/create">Create a recipe yourself!</a>
					</c:when>
					<c:otherwise>
						<h1>Recipes found with keyword(s) "${searchQuery}" :</h1>
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Name</th>
									<th>Problem</th>
									<th>Solution</th>
									<th>Author</th>
									<th>Date Added</th>
								</tr>
							</thead>
							<tbody data-provides="rowlink">
								<c:forEach var="recipe" items='${recipes}'>
									<tr>
										<td><a class="rowlink" href="/recipe/${recipe.externalId}">${recipe.lastVersion.title}</a></td>
										<td>${recipe.lastVersion.problem}</td>
										<td>${recipe.lastVersion.solution}</td>
										<td>${recipe.lastVersion.author}</td>
										<td>${recipe.lastVersion.getFormatedCreationDate()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<p class="lead">Search something else<p>
						<form method="POST" action="/recipe/search" class="form-search">
							<div class="input-append">
								<input type="text" class="input-xxlarge search-query" placeholder="Search" name="param" required>
								<button class="btn" type="submit">Search</button>
							</div>
						</form>
						<p class="lead">Or..</p>
						<a class="btn btn-primary" href="/recipe/create">Create your own recipe!</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>