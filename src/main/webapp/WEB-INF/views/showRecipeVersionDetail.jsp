<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container">
	<c:if
		test="${(creationMessage eq 'creation') || (creationMessage eq 'update')}">
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
		<h1>${version.title} [${version.getFormatedCreationDate()}]</h1>
	</div>
	<div class="row-fluid">
		<div class="span5">
			<div>
				<p class="lead">The problem:</p>
				<div class="well">${version.problem}</div>
			</div>
			<div class="row">&nbsp;</div>
			<div>
				<p class="lead">The solution:</p>
				<div class="well">${version.solution}</div>
			</div>
			<div>
				<p class="lead">Tags:</p>
				<c:choose>
					<c:when test="${empty version.getTagSet()}">
						<div class="well">no tags</div>
					</c:when>
					<c:otherwise>
					<div class= "hero-unit well">
						<c:forEach var="tag" items='${version.getTagSet()}'>
								<span class="label label-warning">${tag.tag} </span>
						</c:forEach>
					</div>
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test="${!(recipe.lastVersion.externalId eq version.externalId)}">
				<a href="#" class="confirm-delete btn btn-warning" data-toggle="modal">Restore this version</a>
			</c:if>
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
         <h3>Restore ${version.getFormatedCreationDate()} version </h3>
    </div>
    <div class="modal-body">
        <p>Are you sure you want to restore the ${version.getFormatedCreationDate()} version?</p>
    </div>
    <div class="modal-footer">
    	<form method="post" action="/recipe/${recipe.externalId}/version/${version.externalId}/restore">
			<div class="control-group">
			<div class="controls">
					<button type="submit" class="btn btn-warning">Restore version</button>
				</div>
			</div>
		</form>
      <a href="#" data-dismiss="modal" aria-hidden="false" class="btn btn-danger">No </a>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
