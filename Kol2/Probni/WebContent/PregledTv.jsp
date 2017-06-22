<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function validateForm() {
   
    var ser_br = document.forms["tvForma"]["serijskiBroj"].value;
    if (ser_br == "" || ser_br == null) {
        alert("SERIJSKI BROJ MORA BITI UNET...");
        return false;
    }
    
}


</script>
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

td,h3,th{
	color:white;
}

h1{
	color:red;
}

</style>


</head>

<body>

<h1> Prodaja televizora </h1>
<c:if test="${empty zaIzmenu}">
 	<form name="tvForma" onsubmit="return validateForm()"   method="POST" action="dodaj-tv">
			     <table border='1'>
			        <tr>
			          <td>Serijski broj:</td>
			          <td><input type='text' name='serijskiBroj'></td>
			        </tr>
			        <tr>
			          <td>Cena</td>
			          <td><input type="number" name='cena'></td>
			        </tr>
			        <tr>
			          <td>Marka</td>
			          <td><select name='marka' >
			            <option value='0'>SAMSUNG</option>
			            <option value='2'>LG</option>
			            <option value='1'>PANASONIC</option>
			            </select>
			          </td> 
			        </tr> 
			        <tr> 
			          <td colspan='2'><input type='submit' name='operacija' value='dodaj'> 
			                          <input type='submit' name='operacija' value='snimi'> 
			                          <a href='PregledTv.jsp'>odustani</a></td>
			        </tr>
			      </table>
			    </form>
</c:if>
<c:if test="${ not empty zaIzmenu}">
 	<form name="tvForma" onsubmit="return validateForm()"   method="POST" action="dodaj-tv">
			     <table border='1'>
			        <tr>
			          <td>Serijski broj:</td>
			          <td><input type='text' value="${zaIzmenu.serijskiBroj}" name='serijskiBroj'></td>
			        </tr>
			        <tr>
			          <td>Cena</td>
			          <td><input type='number' value="${zaIzmenu.cena}" name='cena'></td>
			        </tr>
			        <tr>
			          <td>Marka</td>
			          <td><select name='marka' >
			         <c:if test="${zaIzmenu.model eq 'Samsung'}"> 
			            <option value='0'>SAMSUNG</option>
			            <option value='2'>LG</option>
			            <option value='1'>PANASONIC</option>
			         </c:if>
			         <c:if test="${zaIzmenu.model eq 'Panasonic'})"> 
			         	<option value='1'>PANASONIC</option>
			            <option value='0'>SAMSUNG</option>
			            <option value='2'>LG</option>
			         </c:if>
			         <c:if test="${zaIzmenu.model eq 'Lg'})"> 
			         	<option value='2'>LG</option>
			         	<option value='1'>PANASONIC</option>
			            <option value='0'>SAMSUNG</option>
			         </c:if>
			         
			            </select>
			          </td> 
			        </tr> 
			        <tr> 
			          <td colspan='2'><input type='submit' name='operacija' value='dodaj'> 
			                          <input type='submit' name='operacija' value='snimi'> 
			                          <a href='PregledTv.jsp'>odustani</a></td>
			        </tr>
			      </table>
			    </form>
</c:if>	

<c:if test="${empty tvZaStranicu}">
 	<h1 style="color:white"> NEMA TELEVIZORA </h1>
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
	
			<c:choose>
   				<c:when test="${tv.cena <= 1000}"><tr bgcolor='red'></c:when>
   				<c:when test="${tv.cena > 1000 && tv.cena < 5000}"><tr bgcolor='orange'></c:when> 
   				<c:otherwise><tr bgcolor='green'></c:otherwise> 
			</c:choose>
			
				<td><c:out value="${tv.serijskiBroj}" /></td>
				<td><c:out value="${tv.model}" /></td>
				<td><c:out value="${tv.cena}" /></td>
				<td><a href = "daIzmenim?izmeni=${tv.serijskiBroj}">IZMENI </a></td>
				<td><a href = "daBrisem?obrisi=${tv.serijskiBroj}">OBRISI</a></td>
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