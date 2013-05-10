<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="container">
	<div class="hero-unit">
		<h1>Software Cookbook</h1>
		<p>Common solutions to software-related problems</p>
		<a class="btn btn-primary btn-large" href="/recipe/create">Add your own</a>
		<c:if test="${fn:length(recipes) > 0}">
			<a class="btn btn-primary btn-large" href="/recipe/all">Show All Recipes</a>
		</c:if>
	</div>
</div>
<c:if test="${fn:length(recipes) > 0}">
	<div class="container">
		<div>
			<h1>Latest <c:choose><c:when test="${fn:length(recipes) == 1}">recipe added</c:when><c:otherwise>${fn:length(recipes)} recipes added</c:otherwise></c:choose></h1>
			<div class="container">&nbsp;</div>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Problem</th>
						<th>Author</th>
						<th>Added</th>
					</tr>
				</thead>
				<tbody data-provides="rowlink">
					<c:forEach var="recipe" items='${recipes}'>
						<tr>
							<td><a class="rowlink" href="/recipe/${recipe.id}">${recipe.recipeTitle}</a></td>
							<td>${recipe.recipeProblemDescription}</td>
							<td>${recipe.recipeAuthor}</td>
							<td>${recipe.formatedCreationDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</c:if>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>