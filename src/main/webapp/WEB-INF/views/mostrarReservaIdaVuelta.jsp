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
	<h2 style="text-align: center;"><spring:message code="plataforma_pago"/></h2>
	<br>

	<div id="imprimir">
	
	<h3 style="text-align: center; text-decoration: underline;"><spring:message code="numero_reserva"/></h3>
	<p style="text-align: center;" ><c:out value="${idReserva}"></c:out></p>
	
	<form:form modelAttribute="mostrarResumenIda" style="text-align: center;">
	
	<h3 style="text-align: center; text-decoration: underline;"><spring:message code="ida"/></h3>
	
	<table style="margin:auto;">
		<caption><b><spring:message code="viaje_elegido"/></b></caption>
		<tr>
			<td><b><spring:message code="origen"/></b></td>
			<td><b>&emsp;<spring:message code="destino"/></b></td>
			<td><b>&emsp;<spring:message code="fecha_ida_tit"/></b></td>
			<td><b>&emsp;<spring:message code="num_viajeros"/></b></td>
		</tr>
		<tr>
			<td><c:out value="${viajeElegido.origen}"></c:out></td>
			<td>&emsp;<c:out value="${viajeElegido.destino}"></c:out></td>
			<td>&emsp;<c:out value="${viajeElegido.fecha_ida}"></c:out></td>
			<td>&emsp;<c:out value="${viajeElegido.num_viajeros}"></c:out></td>
		</tr>
	</table><br>
	<table style="margin:auto;">
		<caption><b><spring:message code="extras"/></b></caption>
		<tr>
			<td><b><spring:message code="bicicleta"/></b></td>
			<td><b>&emsp;<spring:message code="mascota"/></b></td>
			<td><b>&emsp;<spring:message code="tabla_surf"/></b></td>
			<td><b>&emsp;<spring:message code="esquies"/></b></td>
			<td><b>&emsp;<spring:message code="seguros"/></b></td>
		</tr>
		<tr>
			<td><c:out value="${extraElegido.bicicleta}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.mascota}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.tabla_surf}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.esquies}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.seguro}"></c:out></td>
		</tr>
	</table><br>
	<table style="margin:auto;">
		<caption><b><spring:message code="datos_personales"/></b></caption>
		<tr>
			<td><b><spring:message code="nombre"/></b></td>
			<td><b>&emsp;<spring:message code="apellidos"/></b></td>
			<td><b>&emsp;<spring:message code="tipo_identificacion"/></b></td>
			<td><b>&emsp;<spring:message code="identificacion_tit"/></b></td>
			<td><b>&emsp;<spring:message code="correo_electronico"/></b></td>
		</tr>
		<tr>
			<td><c:out value="${datosPago.nombre}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.apellidos}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.tipo_identificacion}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.identificacion}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.email}"></c:out></td>
		</tr>
	</table>
	</form:form>
	
	
	<form:form modelAttribute="mostrarResumenIdaVuelta" style="text-align: center;">
	
	<br>
	<h3 style="text-align: center; text-decoration: underline;"><spring:message code="vuelta"/></h3>
	
	<table style="margin:auto;">
		<caption><b><spring:message code="viaje_elegido"/></b></caption>
		<tr>
			<td><b><spring:message code="origen"/></b></td>
			<td><b>&emsp;<spring:message code="destino"/></b></td>
			<td><b>&emsp;<spring:message code="fecha_ida_tit"/></b></td>
			<td><b>&emsp;<spring:message code="num_viajeros"/></b></td>
		</tr>
		<tr>
			<td><c:out value="${viajeElegido.destino}"></c:out></td>
			<td>&emsp;<c:out value="${viajeElegido.origen}"></c:out></td>
			<td>&emsp;<c:out value="${viajeElegido.fecha_vuelta}"></c:out></td>
			<td>&emsp;<c:out value="${viajeElegido.num_viajeros}"></c:out></td>
		</tr>
	</table><br>
	<table style="margin:auto;">
		<caption><b>EXTRAS</b></caption>
		<tr>
			<td><b><spring:message code="bicicleta"/></b></td>
			<td><b>&emsp;<spring:message code="mascota"/></b></td>
			<td><b>&emsp;<spring:message code="tabla_surf"/></b></td>
			<td><b>&emsp;<spring:message code="esquies"/></b></td>
			<td><b>&emsp;<spring:message code="seguros"/></b></td>
		</tr>
		<tr>
			<td><c:out value="${extraElegido.bicicleta}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.mascota}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.tabla_surf}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.esquies}"></c:out></td>
			<td>&emsp;<c:out value="${extraElegido.seguro}"></c:out></td>
		</tr>
	</table><br>
	<table style="margin:auto;">
		<caption><b><spring:message code="datos_personales"/></b></caption>
		<tr>
			<td><b><spring:message code="nombre"/></b></td>
			<td><b>&emsp;<spring:message code="apellidos"/></b></td>
			<td><b>&emsp;<spring:message code="tipo_identificacion"/></b></td>
			<td><b>&emsp;<spring:message code="identificacion_tit"/></b></td>
			<td><b>&emsp;<spring:message code="correo_electronico"/></b></td>
		</tr>
		<tr>
			<td><c:out value="${datosPago.nombre}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.apellidos}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.tipo_identificacion}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.identificacion}"></c:out></td>
			<td>&emsp;<c:out value="${datosPago.email}"></c:out></td>
		</tr>
	</table>


	<br>
	<button type="submit" value="enviarMail"><spring:message code="enviar_mail"/></button>
	</form:form>
	
	</div>
	
	
	
	<br>
	<p style="text-align: center;">
		<button onclick="printDiv('imprimir')" value="imprimirPagina"><spring:message code="imprimir_pagina"/></button>
	</p>
</body>
</html>