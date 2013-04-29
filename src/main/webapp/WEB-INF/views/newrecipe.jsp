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
		<h1>Criar Nova Receita</h1>
		<center>
			<table>
				<tr>
					<td>Recipe Name</td>
					<td><input type="text" name="recipeName"></td>
				</tr>
				<tr>
					<td>Recipe Description</td>
					<td><input type="text" name="recipeDescription"></td>
				</tr>
				<tr>
					<td>Recipe Author</td>
					<td><input type="text" name="recipeAuthor"></td>
				</tr>
				<tr>
					<td>Recipe Date</td>
					<td><input type="text" id="recipeDate" name="recipeDate"></td>
					<script type="text/javascript">
						document.getElementById("recipeDate").value = new Date();
					</script>
				</tr>
			</table>
			<div class="container">
				<a href=" ">Criar Receita</a> 
				<a href=" ">Limpar Campos</a>
</body>
</html>