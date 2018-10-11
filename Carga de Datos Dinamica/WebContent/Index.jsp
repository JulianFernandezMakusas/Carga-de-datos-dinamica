<!DOCTYPE html>
<html>
<head>
<meta>
<title>Index</title>
</head>
<body>
	Cargar datos
	
	<form action="ServletCargarPersonas" method="post">
		<label for="dni">DNI</label> <input type="text" name="dni"><br>
		<label for="nombre">Nombre</label> <input type="text" name="nombre"><br>
		<label for="apellido">Apellido</label><input type="text" name=apellido><br>
		<input type="submit" value = "Cargar datos">
	</form>
	
	Ver datos
	<form action="ServletVerPersonas">
		<input type="submit" value = "Ver todos los datos">
	</form>
		
</body>
</html>