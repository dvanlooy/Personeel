<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ attribute name='title' required='true' type='java.lang.String'%>
<%@ attribute name='subtitle' required='true' type='java.lang.String'%>
<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<c:url value='/' var='urlHome' />
			<a class="navbar-brand" href="${urlHome}"><span
				class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
		</div>
		<ul class="nav navbar-nav">
			<c:url value='/werknemers' var='urlWerknemershiërarchie' />
			<li><a href="${urlWerknemershiërarchie}">Werknemershiërarchie</a></li>
			<li><a href="#">Jobtitels</a></li>
		</ul>
	</div>
</nav>

<div class="container">
	<div class="page-header">
		<h1>
			${title} <small>${subtitle}</small>
		</h1>
	</div>
</div>
