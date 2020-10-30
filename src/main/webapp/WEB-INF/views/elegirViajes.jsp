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
	<h2 style="text-align: center;"><spring:message code="selecciona_viaje"/></h2>
	<br>

	<form:form modelAttribute="viajeElegido" class="fecha" style="text-align: center;">
	
	<spring:message code="origen"/>:
	<form:select path="origen">
    	<form:options items="${origenes}"/>
	</form:select>

	&emsp;
	<spring:message code="destino"/>:
	<form:select path="destino">
    	<form:options items="${destinos}" />
	</form:select>
	
	<br>
	<br>
	<div id="ida">
		<spring:message code="fecha_ida_tit"/>: 
		<form:input path="fecha_ida" placeholder="dd/mm/yyyy"/>
		<form:errors path="fecha_ida" />
	</div>
            
    <br>
    <div id="vuelta">
    	<spring:message code="fecha_vuelta_tit"/>: 
		<form:input path="fecha_vuelta" placeholder="dd/mm/yyyy"/>
		<form:errors path="fecha_vuelta" />
    </div>

	<br>
	<spring:message code="num_plazas"/>:
	<form:select path="num_viajeros">
    	<form:options items="${plazas}" />
	</form:select>

	<br><br>
	<button type="submit" value="viajeElegido"><spring:message code="buscar"/></button>
	</form:form>

</body>

</html>