<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div>
			<div>
				<h1>Latest recipes added</h1>
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
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>