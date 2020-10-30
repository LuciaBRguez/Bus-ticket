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
	<h2 style="text-align: center;"><spring:message code="plataforma_pago"/></h2>
	<br>

	<form:form modelAttribute="datosPago" style="text-align: center;">
		<b><spring:message code="introduce_tus_datos"/>:</b>
		<br>
		<br>
		<spring:message code="nombre"/>: <form:input path="nombre"/>
		<form:errors path="nombre" />
		<br>
		<br>
		<spring:message code="apellidos"/>: <form:input path="apellidos"/>
		<form:errors path="apellidos" />
		<br>
		<br>
		<spring:message code="identificacion_tit"/>:&emsp;
		<form:radiobutton path="tipo_identificacion" value="NIF" checked="checked"/><spring:message code="nif"/>
		<form:radiobutton path="tipo_identificacion" value="NIE"/><spring:message code="nie"/>
		<form:radiobutton path="tipo_identificacion" value="Pasaporte"/><spring:message code="pasaporte"/>&emsp;
		<form:input path="identificacion"/>
		<form:errors path="identificacion" />
		<br>
		<br>
		<spring:message code="correo_electronico"/>: 
		<form:input path="email"/>
		<form:errors path="email" />
		<br>
		<br>
		<button type="submit" value="datosPago"><spring:message code="pagar"/></button>
	</form:form>
</body>
</html>