<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='404 fallback' />

</head>
<body>
	<v:menu title='Euhm!' subtitle='dit was niet de bedoeling' />
	<div class="container">
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h2>
					<span class="glyphicon glyphicon-cog" aria-hidden="true"></span><strong>
						Whoops!</strong> Pagina niet gevonden.
				</h2>
			</div>
			<div class="panel-body">
				<div class="text-center">
					<c:url value='/' var='indexURL'/>
						<h1>We hebben overal gezocht</h1>
						<p class="text-warning">maar we konden de pagina niet vinden. We hebben wel dit gevonden onder de kussens van de zetel:</p>
						<img alt="404 error" src="images/404.png">
				</div>
				<div class="text-center">
					<a href="${indexURL}" class="btn btn-warning" role="button">Probeer nog eens via deze weg...</a> <a
						href="http://www.theuselessweb.com/" class="btn btn-info"
						role="button">... of moest je je nog wat meer nutteloos willen bezighouden ...</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>