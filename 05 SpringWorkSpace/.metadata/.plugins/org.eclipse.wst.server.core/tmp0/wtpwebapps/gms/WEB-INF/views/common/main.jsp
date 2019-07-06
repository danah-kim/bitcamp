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
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"50122",secure:"50123"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/common/main.jsp">
	<div id="wrapper" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/common/main.jsp">
		<div id="header">
				<tiles:insertAttribute name="header"/>
				<tiles:insertAttribute name="nav"/>
		</div>
		<div id="content">
			<tiles:insertAttribute name="fluid"/>
			<tiles:insertAttribute name="content"/>
		</div>
		<div id="footer">
			<footer class="sit-footer">
				<tiles:insertAttribute name="footerImg"/>
				<tiles:insertAttribute name="footerBar"/>
			</footer>
		</div>
	</div>
	<script type='text/javascript' src='${context}/resources/js/jquery.js'></script>
	<script type='text/javascript' src='${context}/resources/js/swiper.min.js'></script>
	<script type='text/javascript' src='${context}/resources/js/custom.js'></script>
	<script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type='text/javascript' src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="${context}/resources/js/app.js"></script>
	<script>
		app.init('${context}');
		alert('DB체크'+'${user}');
		if('${user}'!=''){
			user.session({
				userid : '${user.userid}',
				name : '${user.name}',
				age : '${user.age}',
				gender : '${user.gender}',
				teamid : '${user.teamid}',
				roll : '${user.roll}'
			});
		}
	</script>
</body>
</html>