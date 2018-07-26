<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	/* location.href : 페이지 이동시킬때 사용하는 객체, 주소 히스토리를 가지고 있어 이전페이지 이동 가능
	   location.replace : 페이지 이동시킬때 사용하는 메소드, 주소 히스토리가 기록되지 않아 이전페이지 이동 불가능
	*/
	// common.do의 servlet으로 이동
	location.href = "<%= application.getContextPath()%>/common.do"
</script>