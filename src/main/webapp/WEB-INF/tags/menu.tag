<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ attribute name='title' required='true' type='java.lang.String'%>
<%@ attribute name='subtitle' required='true' type='java.lang.String'%>
<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<c:url value='/' var='urlHome' />
			<a class="navbar-brand" href="${urlHome}"><span
				class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
		</div>
		<ul class="nav navbar-nav">
			<c:url value='/werknemers' var='urlWerknemershiërarchie' />
			<li><a href="${urlWerknemershiërarchie}">Werknemershiërarchie</a></li>
			<c:url value='/jobtitels' var='urlJobtitels' />
			<li><a href="${urlJobtitels}">Jobtitels</a></li>
		</ul>
	</div>
</nav>
<c:if test="${not empty jobtitels }">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">

			<ul class="nav navbar-nav">
				<c:forEach items="${jobtitels}" var="jobtitel">
					<c:url value="/jobtitels/${jobtitel.id}?size=5" var="urlJobtitel" />
					<li ><a href="${urlJobtitel}" >${jobtitel}</a></li>
				</c:forEach>

			</ul>

		</nav>
	</div>
</c:if>

<div class="container">
	<div class="page-header">
		<h1>
			${title} <small>${subtitle}</small>
		</h1>
	</div>
</div>
