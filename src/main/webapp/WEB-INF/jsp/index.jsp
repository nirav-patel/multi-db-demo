<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Multiple Database Handling Exercise</title>
    </head>
    <body>
        <div align="center">
	        <h1>Databases</h1>
	        <table class='table table-hover table-responsive table-bordered'> 
			    <tr>
			    	<td>
				      	<h3><a href="newdb">Create New Database</a></h3>
			    	</td>
				</tr>
			    <tr>
		        <td> 	
		        	<table border="1">
			        	<th>Sr. No</th>
			        	<th>Database Names</th>
			        	<th>Actions</th>
						<c:forEach var="database" items="${databaseList}" varStatus="status">
			        	<tr>
			        		<td>${status.index + 1}</td>
							<td>${database.dbName}</td>
							<td><a href="newtable?dbName=${database.dbName}">Create Table</a></td>
			        	</tr>
						</c:forEach>	        	
		        	</table>
		        </td>
		        </tr>
	        </table>
        </div>
    </body>
</html>
