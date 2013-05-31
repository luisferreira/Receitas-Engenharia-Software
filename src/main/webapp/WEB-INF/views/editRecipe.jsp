<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="container">
	<div class="page-header">
		<h1>Edit Recipe</h1>
		<p>Know something and want to share with the world?</p>
		<p>Go ahead, show your software-fu!</p>
	</div>
	<form class="form-horizontal" method="post" action="/recipe/${recipe.externalÎd}">
		<div class="control-group">
			<label class="control-label" for="recipetitle">Title *</label>
			<div class="controls">
				<input type="text" class="input-xxlarge" id="recipetitle"
					name="recipetitle" value="${recipe.lastVersion.title}" placeholder="How to do an infinite loop"
					required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeProblemDescription">Problem
				*</label>
			<div class="controls">
				<textarea rows="2" class="input-xxlarge"
					id="recipeProblemDescription" name="recipeProblemDescription"
					placeholder="Know how many cycles it take to do an infinite loop"
					required></textarea>
				<span class="help-block">Add a brief description of the
					problem.</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeSolutionDescription">Solution
				*</label>
			<div class="controls">
				<textarea rows="3" class="input-xxlarge"
					id="recipeSolutionDescription" name="recipeSolutionDescription"
					placeholder="How did you slay that dragon?" required></textarea>
				<span class="help-block">Describe how to solve that problem.</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeTags">Tags *</label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="recipeTags"
					name="recipeTags" placeholder="Tag Me..." required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="recipeAuthor">Author *</label>
			<div class="controls">
				<input type="text" class="input-xlarge" id="recipeAuthor"
					name="recipeAuthor" placeholder="That's you!" required>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn btn-primary">Save recipe</button>
				<button type="button" class="btn" onclick="location.href='/'">Cancel</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>

