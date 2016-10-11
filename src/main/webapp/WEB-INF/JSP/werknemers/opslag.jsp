<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Opslag' />
</head>
<body>
	<v:menu />
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1>Opslag voor ${werknemer}</h1>
			</div>
			<div class="panel-body">
			<div class="well well-sm" style="width: 400px">Huidig salaris: <strong>${werknemer.salaris}</strong></div>
				<form:form commandName='opslagForm'>
					<div class="input-group" style="width: 400px">
						<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon glyphicon-eur" aria-hidden="true"></span></span>
						<form:input path='bedrag' class="form-control" placeholder="geef een bedrag in" />
						
						<div class="input-group-btn">
						<spring:url value="${werknemer.id}" var="urlOpslag" />
						<form:errors path='bedrag' delimiter=', ' class="btn btn-danger" onclick="location.href='${urlOpslag}'"/>
						<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon glyphicon-chevron-right" aria-hidden="true"></span></button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
</body>
</html>