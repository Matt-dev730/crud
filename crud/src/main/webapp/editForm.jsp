<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
	
	<html>
	
		<head>
	
			<meta charset=UTF-8>
			<title>Edit Form</title>
	
		</head>
	
		<body>
	
	<!-- 	context.setAttribute("userDAO",userDAO); -->
			<h1>Edit Form</h1>
	
					<form action="update" method="post">
						id       		: <input type="text" name="id" value="${userDAO.getId()}"/><br>	      
						Nom       		: <input type="text" name="Nom" value="${userDAO.getNom()}"/><br>
						Prenom    		: <input type="text" name="Prenom" value="${userDAO.getPrenom()}"/> <br>
						Motdepasse      : <input type="text" name="Mp" value="${userDAO.getMp()}"/><br>
						
						<input type="submit" value="Éditer"/>
		        
		   			 </form>
		</body>
	</html>