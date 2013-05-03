<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe ${recipe.id}</title>
<%@ include file="/WEB-INF/views/common/libs.jsp"%>
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