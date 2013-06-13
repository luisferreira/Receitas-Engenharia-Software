<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Edit Recipe</h1>
		<p>Know something and want to share with the world?</p>
		<p>Go ahead, show your software-fu!</p>
	</div>
	<form class="form-horizontal" method="post" action="/recipe/${recipe.externalId}/edit/">
		<div class="control-group">
			<label class="control-label" for="recipetitle">Title *</label>
			<div class="controls">
				<input type="text" class="input-xxlarge" id="recipetitle" name="recipetitle" value="${recipe.lastVersion.title}" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeProblemDescription">Problem*</label>
			<div class="controls">
				<textarea rows="2" class="input-xxlarge" id="recipeProblemDescription" name="recipeProblemDescription" text="${recipe.lastVersion.problem}" required>${recipe.lastVersion.problem}</textarea>
				<span class="help-block">Brief description of the problem.</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeSolutionDescription">Solution*</label>
			<div class="controls">
				<textarea rows="3" class="input-xxlarge"id="recipeSolutionDescription" name="recipeSolutionDescription" required>${recipe.lastVersion.solution}</textarea>
				<span class="help-block">How to solve that problem.</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeTags">Tags *</label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="recipeTags" name="recipeTags" value="${recipe.lastVersion.tagsAsStrings}" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeAuthor">Author *</label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="recipeAuthor"name="recipeAuthor" value="${recipe.lastVersion.author}" required>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn btn-primary">Save recipe Changes</button>
				<button type="button" class="btn" onclick="location.href='/recipe/${recipe.externalId}'">Cancel</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>

