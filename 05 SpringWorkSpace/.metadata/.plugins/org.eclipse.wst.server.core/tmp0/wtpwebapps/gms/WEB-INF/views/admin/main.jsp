<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/header.jsp"/>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/admin/main.jsp">
	<div id="wrapper" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/gms/src/main/webapp/WEB-INF/views/admin/main.jsp">
		<div id="header">
			<jsp:include page="../common/titleBox.jsp"/>
			<jsp:include page="menuBox.jsp"/>
		</div> 
		<div id="content">
			<jsp:include page="../member/search.jsp"/>
		</div>
		<div id="footer">
			<jsp:include page="../common/footerBar.jsp"/>
		</div>
	</div>
<script>
	admin.main('${context}');
</script>
</body>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"50122",secure:"50123"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></html>