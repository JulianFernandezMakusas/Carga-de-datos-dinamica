<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>Ver Personas</title>
<link rel="stylesheet" type="text/css" href="estiloVerPersona.css"/>
</head>
<body>
	<c:if test="${not empty listaPersona}">

		<c:set var="hayDatos">Hay datos</c:set>

		<table class = "tabla">

			<c:forEach var="persona" items="${listaPersona}">

				<tr>

					<td>dni: ${persona.dni}</td>

					<td>nombre: ${persona.nombre}</td>
					
					<td>apellido: ${persona.apellido}</td>

				</tr>

			</c:forEach>

		</table>

	</c:if>
	<jsp:include page="BarraDeAbajo.jsp">
	<jsp:param value= "Pagina creada por el menor que tres (?" name = "texto"/>
	</jsp:include>
</body>
</html>