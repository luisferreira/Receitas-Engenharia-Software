<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<title>${title}</title>
    	<link rel="shortcut icon" type="image/x-icon" href="/static/img/favicon.ico" />
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="">
    	<meta name="author" content="Miguel Verissimo, Luis Ferreira, Rui Silva, João Feteira">
    	<link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/static/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" type="text/css" href="/static/css/bootstrap-rowlink.min.css" />
		<link rel="stylesheet" type="text/css" href="/static/css/style.css" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
       	<link rel="stylesheet" type="text/css" href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css"/>
       	<script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-tooltip.js"></script>
		<script>
        $(document).ready(function () {		
            $("#myInput").on("focus", function() {
                console.log(this.value);
                    $(this).tooltip("show");
            }).tooltip({
                placement: "bottom",
                trigger: "manual"
            });
            $("#myInput").on("focusout", function() {
                console.log(this.value);
                    $(this).tooltip("hide");
            }).tooltip({
                placement: "bottom",
                trigger: "manual"
            });			
        });
        </script>
		
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
									<a href="/recipe/all"><i class="icon-book"></i> All recipes</a>
								</li>
								<li class="">
									<a href="/recipe/create"><i class="icon-pencil"></i> Create Recipe</a>
								</li>
							</ul>
							<form method="POST" action="/recipe/search" class="navbar-search pull-right">
			    				<input id="myInput" title="Comma separated values " type="text" class="search-query" placeholder="Search" name="param"> 
			    			</form>
						</div>
					</div>
				</div>
			</div>