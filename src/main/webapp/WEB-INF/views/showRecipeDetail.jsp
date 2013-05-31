<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">	
		<c:if test="${creationMessage eq 'success'}">
			<div class="span12 pagination-centered">
				<div id="saveSuccessMessage" class = "alert alert-success fade in" data-alert = "alert">
  					<a class="close" href="#">×</a>
					<p>Recipe created!</p>
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
							<th>Date</th>
							<th>Author</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${recipe.lastVersion.creationTimestamp}</td>
							<td>${recipe.lastVersion.author}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
