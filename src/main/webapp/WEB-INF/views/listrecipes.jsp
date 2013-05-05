<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${recipe.getRecipetitle()}</title>
</head>
<body>
	<div class="container">
		<div>
			<div>
				<h1>Latest recipes added</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Recipe ID</th>
							<th>Recipe Name</th>
							<th>Recipe Description</th>
							<th>Recipe Author</th>
							<th>Recipe Date Added</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="recipe" items='${recipes}'>
							<tr>
								<td><a href="/recipes/${recipe.getid()}">${recipe.getid()}</a></td>
								<td>${recipe.getRecipeProblemDescription()}</td>
								<td>${recipe.getRecipeAuthor()}</td>
								<td>${recipe.getCreationData()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>