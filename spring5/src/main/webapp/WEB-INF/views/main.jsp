<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type='text/javascript' src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<!-- Bootstrap 3.3.4 -->
    <link href="${context}/resources/other_resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${context}/resources/other_resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="${context}/resources/other_resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    
</head>
<body>
	<div id="wrapper">
	</div>
	<script type='text/javascript' src='${context}/resources/js/swiper.min.js'></script>
	<script type='text/javascript' src='${context}/resources/js/custom.js'></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script src="${context}/resources/js/app.js"></script>
	<script>
		app.init('${context}');
		/* alert('DB체크'+'${user}');
		if('${user}'!=''){
			user.session({
				userid : '${user.userid}',
				name : '${user.name}',
				age : '${user.age}',
				gender : '${user.gender}',
				teamid : '${user.teamid}',
				roll : '${user.roll}'
			});
		} */
	</script>
</body>
</html>