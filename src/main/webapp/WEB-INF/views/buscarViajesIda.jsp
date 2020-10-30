<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alsia</title>
	<script type="text/javascript">
			function printDiv(divName) {
			    var printContents = document.getElementById(divName).innerHTML;
			    var originalContents = document.body.innerHTML;
			
			    document.body.innerHTML = printContents;
			
			    window.print();
			
			    document.body.innerHTML = originalContents;
			}
	</script>
</head>

<body>
	<h1 style="text-align: center;">ALSIA.COM</h1>
	<br>
	<br>
	<h2 style="text-align: center;"><spring:message code="selecciona_billetes"/></h2>
	<br>

	<form:form modelAttribute="buscarViajesIda" style="text-align: center;">
	
		<div id="imprimir">
		<table style="margin:auto;">
			<caption><b><spring:message code="ida"/></b></caption>
			<tr style="text-align: center;">
				<td><b><spring:message code="origen"/></b></td>
				<td><b>&emsp;<spring:message code="fecha_ida_tit"/></b></td>
				<td><b>&emsp;<spring:message code="hora_salida"/></b></td>
				<td><b>&emsp;<spring:message code="destino"/></b></td>
				<td><b>&emsp;<spring:message code="plazas_libres"/></b></td>
			</tr>
				
			<c:forEach items="${viajelist}" var="viaje">
				<tr style="text-align: center;">
					<td><c:out value="${viaje.origen}"></c:out></td>
					<td>&emsp;<c:out value="${viaje.fecha_salida}"></c:out></td>
					<td>&emsp;<c:out value="${viaje.hora_salida}"></c:out></td>
					<td>&emsp;<c:out value="${viaje.destino}"></c:out></td>
					<td>&emsp;<c:out value="${viaje.plazas_libres}"></c:out></td>
					<td>&emsp;<form:radiobutton path="id_ida" value="${viaje.id}" checked="checked"/></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		</div>
		<button type="submit" value="buscarViajesIda"><spring:message code="siguiente"/></button>
		
	</form:form>
	
	<p style="text-align: center;">
		<button onclick="printDiv('imprimir')" value="imprimirPagina"><spring:message code="imprimir_pagina"/></button>
	</p>
</body>
</html>
