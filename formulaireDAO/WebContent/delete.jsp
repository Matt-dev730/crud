<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

	<html>
	
		<head>
	
			<meta charset="UTF-8">
			<title>Page Utilisateur/Supprimer</title>
	
		</head>
	
		<body>
			<p action="deleteUser" methode="post">
			
			<c:out value="${ nb_line_delete}"></c:out>

			<a href="index.jsp">back to index</a>
		
		</body>
	
	</html>