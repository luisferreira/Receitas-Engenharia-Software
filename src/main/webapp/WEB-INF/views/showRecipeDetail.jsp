<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">	
		<c:if test="${(creationMessage eq 'creation') || (creationMessage eq 'update')}">
			<div class="span12 pagination-centered">
				<div id="saveSuccessMessage" class = "alert alert-success fade in" data-alert = "alert">
  					<a class="close" href="#">×</a>
					<p>${creationMessage eq "creation" ? "Recipe created!" : "Recipe updated!"}</p>
				</div>
			</div> 
		</c:if>
		<div class="page-header">
			<h1>${recipe.lastVersion.title}</h1>
		</div>
		<div class="row-fluid">
			<div class="span5">
				<div>
					<p class="lead">The problem:</p>
					<div class="well">
						${recipe.lastVersion.problem}
					</div>
				</div>
				<div class="row">&nbsp;</div>
				<div>
					<p class="lead">The solution:</p>
					<div class="well">
						${recipe.lastVersion.solution}
					</div>
				</div>
				<a href= "/recipe/${recipe.externalId}/delete" class="btn btn-danger">Delete Recipe</a>
				<a href= "/recipe/${recipe.externalId}/edit" class="btn btn-primary btn-large"> Edit Recipe</a>
			</div>
			
			<div class="span4 pull-right">
				<p class="lead text-right">Metadata</p>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Version</th>
							<th>Date</th>
							<th>Author</th>
						</tr>
					</thead>
					<tbody data-provides="rowlink">
						<c:set var="v" value="0" scope="page" />
						<c:forEach var="version" items='${versions}'>
							<c:set var="v" value="${v + 1}" scope="page"/>
							<tr>
								<td>${v == 1 ? "Current" : v}</td>
								<td><a class="rowlink" href="/recipe/${recipe.externalId}">${version.getFormatedCreationDate()}</a></td>
								<td>${recipe.lastVersion.author}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
