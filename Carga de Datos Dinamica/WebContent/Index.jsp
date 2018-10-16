<!DOCTYPE html>
<html>
<head>
<title>Index</title>
<link rel="stylesheet" type="text/css" href="EstiloIndex.css"/>
</head>
<body>
	Cargar datos

	<form action="ServletCargarPersonas" method="post">
		<label for="dni">DNI</label> <input type="text" name="dni"><br>
		<label for="nombre">Nombre</label> <input type="text" name="nombre"><br>
		<label for="apellido">Apellido</label><input type="text" name=apellido><br>
		<input type="submit" value="Cargar datos">
	</form>

	Ver datos
	<form action="ServletVerPersonas">
		<input type="submit" value="Ver todos los datos">
	</form>
	<jsp:include page="BarraDeAbajo.jsp">
	<jsp:param value= "Pagina creada por el menor que tres (?" name = "texto"/>
	</jsp:include>
</body>
</html>