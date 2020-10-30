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
	<br>
	<h2 style="text-align: center;"><spring:message code="cancelar_reserva"/></h2>
	<br>
	<p style="text-align: center;"><spring:message code="introduce_datos"/>:</p>
	<br>
	<br>
	<form:form modelAttribute="cancelarReserva" style="text-align: center;">
		<spring:message code="codigo_reserva"/>:
		<br>
		<form:input path="id"/>
		<br>
		<br>
		<spring:message code="introduce_correo"/>:
		<br>
		<form:input path="email"/>
		<br>
		<br>
		<button type="submit" value="cancelarReserva"><spring:message code="confirmar_cancelacion"/></button>
	</form:form>
</body>
</html>