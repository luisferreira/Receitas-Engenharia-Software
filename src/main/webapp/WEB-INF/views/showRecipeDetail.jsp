<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container">
	<c:if test="${(creationMessage eq 'creation') || (creationMessage eq 'update')}">	
		<div class="span12 pagination-centered">
			<div id="saveSuccessMessage" class="alert alert-success fade in"
				data-alert="alert">
				<a class="close" href="#">×</a>
				<p>${creationMessage eq "creation" ? "Recipe created!" : "Recipe
					updated!"}</p>
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
				<div class="well">${recipe.lastVersion.problem}</div>
			</div>
			<div class="row">&nbsp;</div>
			<div>
				<p class="lead">The solution:</p>
				<div class="well">${recipe.lastVersion.solution}</div>
			</div>
			<div>
				<p class="lead">Tags:</p>
				<c:choose>
					<c:when test="${empty recipe.lastVersion.getTagSet()}">
						<div class="well">no tags</div>
					</c:when>
					<c:otherwise>
					<div class= "hero-unit">
						<c:forEach var="tag" items='${recipe.lastVersion.getTagSet()}'>
								<span class="badge badge-info" >${tag.tag} </span>
						</c:forEach>
					</div>
					</c:otherwise>
				</c:choose>
			</div>
			<a href="#" class="confirm-delete btn btn-danger" data-toggle="modal">Delete Recipe</a> 
			<a href="/recipe/${recipe.externalId}/edit" class="btn btn-info"> Edit Recipe</a>
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
					<c:set var="v" value="-1" scope="page" />
					<c:forEach var="version" items='${recipe.recipeVersionSet}'>
						<c:set var="total" value="${recipe.recipeVersionCount}" />
						<c:set var="v" value="${v + 1}" scope="page" />
						<tr>
							<td>${v == 0 ? "Current" : total-v}</td>
							<td><a class="rowlink" href="/recipe/${recipe.externalId}/version/${version.externalId}">${version.getFormatedCreationDate()}</a></td>
							<td>${recipe.lastVersion.author}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div id="myModal" class="modal hide">
    <div class="modal-header">
        <a href="#" data-dismiss="modal" aria-hidden="false" class="close">×</a>
         <h3>Delete Recipe...</h3>
    </div>
    <div class="modal-body">
        <p>Are you sure about to delete this recipe?</p>
    </div>
    <div class="modal-footer">
      <a href="/recipe/${recipe.externalId}/delete" id="btnYes" class="btn btn-success">Yes</a>
      <a href="#" data-dismiss="modal" aria-hidden="false" class="btn btn-danger">No </a>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>