<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alsia</title>
</head>
<body style="text-align: center;">
	<h1 style="text-align: center;">ALSIA.COM</h1>
	<br>
	<p style="text-align: center;" ><spring:message code="visitas"/>: <c:out value="${visitas}"></c:out></p>
	<br>
	<h2 style="text-align: center;">¡<spring:message code="bienvenido"/>!</h2>
	<br> 
	<p  style="text-align: center;"><spring:message code="elige_opcion"/>:</p>
	<br>
	<a href="elegirViajes"><spring:message code="comprar"/></a>
	<br />
	<a href="cancelarReserva"><spring:message code="cancelar_reserva"/></a>

</body>
</html>