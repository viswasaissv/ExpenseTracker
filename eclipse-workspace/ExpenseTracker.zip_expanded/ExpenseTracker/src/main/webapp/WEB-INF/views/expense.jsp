<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an Expense</title>
</head>
<body>
<h1>Add an Expense</h1>
<form:form action="${contextRoot}/save" method="POST" modelAttribute="expense">
<form:hidden path="id"/>
<form:input path="expensename" placeholder="Enter your Expense Name"/>
<form:input path="amount" placeholder="Enter your Expense Amount"/>
<form:input path="note" placeholder="Enter your Description"/>
<button type="submit">Add</button>
</form:form>
<a href="${contextRoot}/expense/${expense.id}/delete" >Delete</a>
</body>
</html>