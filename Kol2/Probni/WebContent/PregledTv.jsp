<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style>

table {
	text-align: center;
}

th {
	font-weight: bold;
}

h2{
	color: purple;
}

body{
	background-color: black;
}

td,h3,th,h1{
	color:white;
}

</style>


</head>

<body>


<c:if test="${empty tvZaStranicu}">
 	<h1> NEMA TELEVIZORA </h1>
</c:if>

<c:if test="${not empty tvZaStranicu}">
	<h2> Televizori </h2>	
	<table border="1">
		<tr>
			<th>Serijski broj</th>
			<th>Marka</th>
			<th>Cena</th>
			<th>Izmeni</th>
			<th>Izbrisi</th>
		</tr>
		<c:forEach items="${tvZaStranicu}" var="tv">
			<c:if test = "${tv.cena < 1000 }">
				<tr bgcolor='red'>
			</c:if>
			<c:choose>
   				<c:when test="${tv.cena <= 1000}"><tr bgcolor='red'></c:when>
   				<c:when test="${tv.cena > 1000 && tv.cena < 5000}"><tr bgcolor='orange'></c:when> 
   				<c:otherwise><tr bgcolor='green'></c:otherwise> 
			</c:choose>
			
				<td><c:out value="${tv.serijskiBroj}" /></td>
				<td><c:out value="${tv.model}" /></td>
				<td><c:out value="${tv.cena}" /></td>
				<td>IZMENI</td>
				<td>OBRISI</td>
			</tr>
		</c:forEach>
	</table>

<form action="filtriraj-tv" method="POST">
<select name="marka">
						
						<option value="0">Samsung</option>
						<option value="1">Panasonic</option>
						<option value="2">LG</option>
						<option value="3" selected>SVE</option>
				</select>
				<input type="submit" value="FILTRIRAJ~!!!!!!!!!">
</form>
</c:if>

</body>
</html>