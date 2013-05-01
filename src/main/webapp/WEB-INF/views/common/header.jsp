<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<title>${title}</title>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="">
    	<meta name="author" content="Miguel Verissimo, Luis Ferreira, Rui Silva, João Feteira">
    	<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/static/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" type="text/css" href="/static/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<button class="btn btn-navbar" data-target=".nav-collapse" data-toggle="collapse" type="button">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="brand" href="/">CookBook</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li class="">
									<a href="/list"><i class="icon-book"></i> All recipes</a>
								</li>
								<li class="">
									<a href="/recipes/create"><i class="icon-pencil"></i> Create Recipe</a>
								</li>
							</ul>
							<form class="navbar-search pull-right">
			    				<input type="text" class="search-query" placeholder="Search">
			    			</form>
						</div>
					</div>
				</div>
			</div>