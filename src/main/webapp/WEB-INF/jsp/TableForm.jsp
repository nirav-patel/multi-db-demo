<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Table</title>
</head>
<body>
	<div align="center">
		<h1>Create New Table</h1>
		<table>
			<form:form action="savetable" method="post" modelAttribute="tableDto">
			<tr>
				<td>Database Name:</td>
				<td><form:input path="dbName" required="required" readonly="true" /></td>
			</tr>
			<tr>
				<td>Table Name:*</td>
				<td><form:input path="tableName" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>