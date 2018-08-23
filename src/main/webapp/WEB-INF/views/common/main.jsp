<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" href="${context}/resources/img/favicon.ico">
	<link rel="stylesheet" href="${context}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${context}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${context}/resources/css/swiper.min.css">
	<link rel="stylesheet" href="${context}/resources/css/style.css">
	<script type='text/javascript' src='${context}/resources/js/jquery.js'></script>
	<script type='text/javascript' src='${context}/resources/js/swiper.min.js'></script>
	<script type='text/javascript' src='${context}/resources/js/custom.js'></script>
	<script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type='text/javascript' src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="${context}/resources/js/app.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="content">
			<div id="header">
				<tiles:insertAttribute name="header"/>
			</div>
			<div class="outer-container">
				<tiles:insertAttribute name="hero"/>
				<tiles:insertAttribute name="content"/>
			</div>
		</div>
			<div id="footer">
				<tiles:insertAttribute name="footer"/>
			</div>
	</div>
<script>
	app.init('${context}');
</script>
</body>
</html>