<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of users</title>
</head>
<body>
  <c:choose>
    <c:when test="${list.size()>0}">
    <h2>List of users:</h2>
     <c:forEach var="itm" items="${list}">
        <br>${itm} 
        </c:forEach>
    </c:when>
    <c:otherwise>
     <h2>No Users found</h2>
    </c:otherwise>  
  </c:choose>
</body>
</html>