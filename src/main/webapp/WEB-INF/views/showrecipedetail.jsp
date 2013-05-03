	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<div class="page-header">
			<h1>${recipe.title}</h1>
		</div>
			<p class="lead">The problem:</p>
			<p>${recipe.solution}</p>
		<div>
		</div>
		<div>
			<p class="lead">The solution:</p>
			<p>${recipe.solution}</p>
		</div>
		<div>
			<p class="lead">Metadata</p>
			<table class="table-striped">
				<thead>
					<tr>
						<th>Version</th>
						<th>Added</th>
						<th>Author</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${recipe.versions}" var="version">
						<tr>
							<td>${version.version}</td>
							<td>${version.dateAdded}</td>
							<td>${version.author}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>