<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Info' />

</head>
<body>
	<c:choose>
		<c:when test="${not empty jobtitel }">
			<v:menu title='${jobtitel}' subtitle='' />
		</c:when>
		<c:when test="${empty jobtitel }">
			<v:menu title='Jobtitels' subtitle='kies uit bovenstaand menu' />
		</c:when>
	</c:choose>
	<div class="container">
		<c:if test="${not empty page}">
			<div class="row">
				<div class="col-md-6">
					<div class="list-group">
						<div class="list-group-item list-group-item-info">
							Werknemers met als jobtitel ${jobtitel}</div>
						<c:forEach items="${page.content}" var="werknemer">
							<c:url value="/werknemers/${werknemer.id}" var="urlWerknemer" />
							<a href="${urlWerknemer}" class="list-group-item">${werknemer}</a>
						</c:forEach>
					</div>
					<c:if test="${page.totalPages gt 1}">
						<nav aria-label="Page navigation">
							<ul class="pagination">
							<fmt:parseNumber var="p" type="number" value="${param.page}" />
								<c:url value="" var="urlPrevious">
									<c:param name="page" value="${p - 1}" />
									<c:param name="size" value="5" />
								</c:url>
								<li <c:if test="${page.first}">class="disabled"</c:if>><a <c:if test="${!page.first}">href="${urlPrevious}"</c:if> aria-label="Previous"> <span
										class="glyphicon glyphicon glyphicon-chevron-left"
										aria-hidden="true"></span>
								</a></li>
								<c:forEach var="pageNr" begin="1" end="${page.totalPages}">
									<c:choose>
										<c:when test="${pageNr-1 == page.number}">
											<li class="active"><a>${pageNr}</a></li>
										</c:when>
										<c:otherwise>
											<c:url value="" var="url">
												<c:param name="page" value="${pageNr-1}" />
												<c:param name="size" value="5" />
											</c:url>
											<li><a href="${url}">${pageNr}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<fmt:parseNumber var="p" type="number" value="${param.page}" />
								<c:url value="" var="urlNext">
									<c:param name="page" value="${p + 1}" />
									<c:param name="size" value="5" />
								</c:url>
								<li <c:if test="${page.last}">class="disabled"</c:if>><a <c:if test="${!page.last}">href="${urlNext}"</c:if> aria-label="Previous"> <span
										class="glyphicon glyphicon glyphicon-chevron-right"
										aria-hidden="true"></span>
								</a></li>
							</ul>
						</nav>
					</c:if>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>