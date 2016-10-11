<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='${werknemer.voornaam} ${werknemer.familienaam}' />
</head>
<body>
	<v:menu />
	<div class="container">
		<div class="well">
			<div class="row">
				<div class="col-md-2">
					<img src="<c:url value="/images/${werknemer.id}.jpg"/>"
						alt="${werknemer.voornaam}&nbsp;${werknemer.familienaam}"
						class="img-thumbnail">

				</div>
				<div class="col-md-10">
					<h1>
						${werknemer.voornaam} ${werknemer.familienaam} <small>${werknemer.jobtitel}</small>
					</h1>

					<div class="row">
						<div class="col-xs-6 col-md-4">
							<strong>Voornaam:</strong>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8">${werknemer.voornaam}</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-md-4">
							<strong>Familienaam:</strong>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8">${werknemer.familienaam}</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-md-4">
							<strong>Email adres:</strong>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8">${werknemer.email}</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-md-4">
							<strong>Salaris:</strong>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8">${werknemer.salaris}</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-md-4">
							<strong>Jobtitel:</strong>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8">${werknemer.jobtitel}</div>
					</div>
					<c:if test="${not empty werknemer.chef}">
						<div class="row">
							<div class="col-xs-6 col-md-4">
								<strong>Chef:</strong>
							</div>
							<c:url value="/werknemers/${werknemer.chef.id}" var="urlChef" />
							<div class="col-xs-12 col-sm-6 col-md-8">
								<a href="${urlChef}">${werknemer.chef}</a>
							</div>
						</div>
					</c:if>

				</div>
			</div>

		</div>
		<c:if test="${not empty werknemer.ondergeschikten}">
			<div class="list-group">
				<div class="list-group-item list-group-item-info">Ondergeschikten</div>
				<c:forEach items="${werknemer.ondergeschikten}" var="ondergeschikte">
					<c:url value="/werknemers/${ondergeschikte.id}"
						var="urlOndergeschikte" />
					<a href="${urlOndergeschikte}" class="list-group-item">${ondergeschikte}</a>
				</c:forEach>
			</div>
		</c:if>
		<div class="text-center">
		<c:url value="/werknemers/opslag/${werknemer.id}"	var="urlOpslag" />
			<a class="btn btn-primary" href="${urlOpslag}" role="button">Opslag</a>
		</div>
</body>
</html>