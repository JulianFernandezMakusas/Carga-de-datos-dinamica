<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="estiloVerPersona.css"/>
<title>Cargar Personas</title>
</head>
<body>
La persona cargada es:
<table class = "tabla">
	<tr><td>DNI: ${people.dni}</td></tr>
	<tr><td>Nombre: ${people.nombre}</td></tr>
	<tr><td>Apellido: ${people.apellido}</td></tr>
</table>
	<jsp:include page="BarraDeAbajo.jsp">
	<jsp:param value= "Pagina creada por el menor que tres (?)" name = "texto"/>
	</jsp:include>
</body>
</html>