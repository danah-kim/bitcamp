<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="contentBox">
	<table>
	<colgroup>
	<col style="width: 15%">
	<col style="width: 15%">
	<col style="width: 70%">
	</colgroup>
	  <tr>
	    <th colspan="3">
	    	<h1>WELCOME RETRIEVE HOMEPAGE</h1>
	    </th>
	  </tr>
	  <tr>
	    <td class="profileImg" colspan="2">
	    	<c:choose>
				<c:when test="${profile ne null}">
					<img src="${img}/${profile}" alt="profileImg">
				</c:when>
				<c:otherwise>
					<img src="resources/img/home/profileImg.png" alt="profileImg">
				</c:otherwise>
			</c:choose>
	    </td>
	    <td rowspan="2" >
			<img src="resources/img/home/test.jpg" alt="기본이미지">
		</td>
	  </tr>
	  <tr>
	    <td>
	    	<ul id="retrieveInfoList">
				<li>아이디 : <br/></li>
				<li>비밀번호 : <br/></li>
				<li>이름 : <br/></li>
				<li>주민등록번호 : <br/></li>
				<li>성별 : <br/></li>
				<li>나이 : <br/></li>
				<li>팀명 : <br/></li>
				<li>역할 : <br/></li>
				<li>과목 : <br/></li>
			</ul>
		</td>
	    <td>
			<ul id="retrieveInfoList">
				<li>${user.memId}<br/></li>
				<li>**** <br/></li>
				<li>${user.name}<br/></li>
				<li>${user.ssn}<br/></li>
				<li>${user.gender}<br/></li>
				<li>${user.age}<br/></li>
				<li>${user.teamId}<br/></li>
				<li>${user.roll}<br/></li>
				<li>${user.subject}<br/></li>
			</ul>
		</td>
	  </tr>
	</table>
</div>