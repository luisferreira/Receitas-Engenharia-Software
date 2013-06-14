<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">
		<c:if test="${!(direct eq 'direct')}">
			<c:choose>
				<c:when test="${fn:length(results.get('topThree')) < 1}">
					<h1>No recipes found with ${searchQuery}</h1>
					<p class="lead">Search something else<p>
					<form method="POST" action="/recipe/search" class="form-search">
						<div class="input-append">
							<input type="text" class="srchBoxType input-xxlarge search-query" placeholder="Search" name="param" 
									title="search multiple with comma separated values, enter to submit" required>
							<button class="btn" type="submit">Search</button>
						</div>
					</form>
					<p class="lead">Or..</p>
					<a class="btn btn-primary" href="/recipe/create">Create a recipe yourself!</a>
				</c:when>
				<c:otherwise>
					<h1>Top three results found for "${searchQuery}" :</h1>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Search term</th>
								<th>Matching Fields</th>
								<th>Name</th>
								<th>Problem</th>
								<th>Solution</th>
								<th>Author</th>
								<th>Date Added</th>
							</tr>
						</thead>
						<tbody data-provides="rowlink">
							<c:forEach var="result" items="${results.get('topThree')}">
								<tr>
									<td>${result.term}</td>
									<td>
										<div>
										<c:forEach var="field" items="${result.matchFieldsList()}">
											<c:choose>
												<c:when test="${field eq 'title'}"><span class="label">${field}</span></c:when>
												<c:when test="${field eq 'problem'}"><span class="label label-success">${field}</span></c:when>
												<c:when test="${field eq 'solution'}"><span class="label label-info">${field}</span></c:when>
												<c:when test="${field eq 'author'}"><span class="label label-inverse">${field}</span></c:when>
												<c:when test="${field eq 'tags'}"><span class="label label-warning">${field}</span></c:when>
											</c:choose>
										</c:forEach>
										</div>
									</td>
									<td><a class="rowlink" href="/recipe/${result.recipe.externalId}">${result.recipe.lastVersion.title}</a></td>
									<td><div class="ellipsis">${result.recipe.lastVersion.problem}</div></td>
									<td><div class="ellipsis">${result.recipe.lastVersion.solution}</div></td>
									<td>${result.recipe.lastVersion.author}</td>
									<td>${result.recipe.lastVersion.getFormatedCreationDate()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<c:forEach var="str" items="${results.keySet()}">
						<c:if test="${!(str eq 'topThree')}">
							<h1>Recipes found with keyword "${str}" :</h1>
							<table class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Search term</th>
										<th>Matching Fields</th>
										<th>Name</th>
										<th>Problem</th>
										<th>Solution</th>
										<th>Author</th>
										<th>Date Added</th>
									</tr>
								</thead>
								<tbody data-provides="rowlink">
									<c:forEach var="result" items='${results.get(str)}'>
										<tr>
											<td>${result.term}</td>
											<td>
												<div>
												<c:forEach var="field" items="${result.matchFieldsList()}">
													<c:choose>
														<c:when test="${field eq 'title'}"><span class="label">${field}</span></c:when>
														<c:when test="${field eq 'problem'}"><span class="label label-success">${field}</span></c:when>
														<c:when test="${field eq 'solution'}"><span class="label label-info">${field}</span></c:when>
														<c:when test="${field eq 'author'}"><span class="label label-inverse">${field}</span></c:when>
														<c:when test="${field eq 'tags'}"><span class="label label-warning">${field}</span></c:when>
													</c:choose>
												</c:forEach>
												</div>
											</td>
											<td><a class="rowlink" href="/recipe/${result.recipe.externalId}">${result.recipe.lastVersion.title}</a></td>
											<td>${result.recipe.lastVersion.problem}</td>
											<td>${result.recipe.lastVersion.solution}</td>
											<td>${result.recipe.lastVersion.author}</td>
											<td>${result.recipe.lastVersion.getFormatedCreationDate()}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
		 			</c:forEach>
					
					<p class="lead">Search something else<p>
					<form method="POST" action="/recipe/search" class="form-search">
						<div class="input-append">
							<input type="text" class="srchBoxType input-xxlarge search-query" placeholder="Search" name="param" 
								title="search multiple with comma separated values, enter to submit" required>
							<button class="btn" type="submit">Search</button>
						</div>
					</form>
					<p class="lead">Or..</p>
					<a class="btn btn-primary" href="/recipe/create">Create your own recipe!</a>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${direct eq 'direct'}">
			<h1>Search recipes!</h1>
			<form method="POST" action="/recipe/search" class="form-search">
				<div class="input-append">
					<input type="text" class="srchBoxType input-xxlarge search-query" placeholder="Search" name="param"
						title="search multiple with comma separated values, enter to submit" required>
					<button class="btn" type="submit">Search</button>
				</div>
			</form>
			<p class="lead">Or..</p>
			<a class="btn btn-primary" href="/recipe/create">Create a recipe yourself!</a>
		</c:if>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>