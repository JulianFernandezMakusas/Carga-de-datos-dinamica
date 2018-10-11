<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>Ver Personas</title>
</head>
<body>
	<c:if test="${not empty listaPersona}">

		<c:set var="hayDatos">Hay datos</c:set>

		<table>

			<c:forEach var="persona" items="${listaPersona}">

				<tr>

					<td>dni: ${persona.dni}</td>

					<td>nombre: ${persona.nombre}</td>
					
					<td>apellido: ${persona.apellido}</td>

				</tr>

			</c:forEach>

		</table>

	</c:if>

</body>
</html>