<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe ${recipe.id}</title>
</head>
<body>
	<h1>${recipe.recipetitle}</h1>
	<b>ID</b>
	<p>${recipe.id}</p>
	<b>Problema</b>
	<p>${recipe.recipeProblemDescription}</p>
	<b>Solução</b>
	<p>${recipe.recipeSolutionDescription}</p>
	<b>Autor</b>
	<p>${recipe.autor}</p>
	<b>Data Criação</b>
	<p>${recipe.recipeAuthor}</p>
</body>
</html>
=======
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
>>>>>>> 6543ce217f542f27bef77ab3a229dc832d28fc76
