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
			<h1>Create new recipe</h1>
			<p>Know something and want to share with the world?</p>
			<p>Go ahead, show your software-fu!</p>
		</div>
	</header>
	<div class="container">
		<form class="form-horizontal">
			<div class="control-group">
				<label class="control-label" for="recipeName">Title</label>
				<div class="controls">
					<input type="text" class="input-xxlarge" id="recipeName" placeholder="How to do an infinite loop">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="recipeProblem">Problem</label>
				<div class="controls">
					<textarea rows="2" class="input-xxlarge" id="recipeProblem" placeholder="Know how many cycles it take to do an infinite loop"></textarea>
					<span class="help-block">Add a brief description of the problem.</span>
				</div>
			</div>
			<div class="control-group">	
				<label class="control-label" for="recipeSolution">Solution</label>
				<div class="controls">
					<textarea rows="3" class="input-xxlarge" id="recipeSolution" placeholder="How did you slay that dragon?"></textarea>
					<span class="help-block">Describe how to solve that problem.</span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="recipeAuthor">Author</label>
				<div class="controls">
					<input type="text" class="input-xlarge" id="recipeAuthor" placeholder="That's you!">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
			    	<button type="submit" class="btn btn-primary">Save recipe</button>
			    	<button type="button" class="btn">Cancel</button>
			    </div>
			</div>
		</form>
	</div>
</body>
</html>