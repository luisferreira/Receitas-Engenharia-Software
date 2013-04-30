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
	<%@ include file="/WEB-INF/views/common/navbar.jsp"%>
	<header id="overview" class="jumbotron subhead">
		<div class="container">
			<h1>Software Cookbook</h1>
			<p>Common solutions to software-related problems</p>
			<p>
				<a class="btn btn-primary btn-large" href="/recipes/create">Add
					your own!</a>
			</p>
		</div>
	</header>
	<div class="container">
		
		<div>
			<h1>Latest recipes added</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Recipe</th>
						<th>Description</th>
						<th>Author</th>
						<th>Added</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Lorem ipsum</td>
						<td>Dolor sid Amet</td>
						<td>Barrack Obama</td>
						<td>30-04-2013 16:55</td>
					</tr>
					<tr>
						<td>The onness</td>
						<td>deh ottess</td>
						<td>Cavaco Silva</td>
						<td>30-04-2013 11:23</td>
					</tr>
					<tr>
						<td>//~ BTT</td>
						<td>Alhos Vedros</td>
						<td>João Tomás</td>
						<td>22-04-2013 08:13</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>