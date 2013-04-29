<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<%@ include file="/WEB-INF/views/common/libs.jsp"%>
</head>
<body>
	<div class="container">
		<table>
			<tr>
				<td>Recipe Name</td>
				<td><input type="text" name="recipeName"></td>
			</tr>
			<tr>
				<td>Recipe Description</td>
				<td><input type="text" name="recipeDescription"></td>
			</tr>
		</table>
				<a href="/recipes/create">Criar Receita</a>
</body>
</html>