<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alsia</title>
</head>

<body>
	<h1 style="text-align: center;">ALSIA.COM</h1>
	<br>
	<h2 style="text-align: center;"><spring:message code="añade_extras"/></h2>
	<br>

	<form:form modelAttribute="extraElegido" style="text-align: center;">
		<b><spring:message code="equipaje_extra"/>:</b>
		<br><br>
		<form:checkbox path="bicicleta"/><spring:message code="bicicleta"/>&emsp;
		<form:checkbox path="mascota"/><spring:message code="mascota"/>&emsp;
		<form:checkbox path="tabla_surf"/><spring:message code="tabla_surf"/>&emsp;
		<form:checkbox path="esquies"/><spring:message code="esquies"/>
		<br>
		<br>
		<b><spring:message code="seguros"/>:</b>
		<br><br>
		<form:checkbox path="seguro"/><spring:message code="seguro_viajeros"/>
		<br>
		<br>
		<button type="submit" value="extraElegido"><spring:message code="confirmar"/></button>
	</form:form>
</body>
</html>