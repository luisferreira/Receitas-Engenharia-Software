<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<%@ include file="/WEB-INF/views/common/libs.jsp"%>
</head>
<body>
		<h1>Criar Nova Receita</h1>
		<form method="post" action="/recipes">
			<center>
				<table>
					<tr>
						<td>Recipe Title:</td>
						<td><input type="text" name="recipeName"></td>
					</tr>
					<tr>
						<td>Recipe Problem Description:</td>
						<td><input type="text" name="recipeProblemDescription"></td>
					</tr>
					<tr>
						<td>Recipe Solution Description:</td>
						<td><input type="text" name="recipeSolutionDescription"></td>
					</tr>
					<tr>
						<td>Recipe Author:</td>
						<td><input type="text" name="recipeAuthor"></td>
					</tr>
				</table>
				</center>
		</form>
				<td><input type="submit" value="Criar nova Receita"></td>
</body>
</html>