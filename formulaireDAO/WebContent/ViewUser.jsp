<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>

	<html>
	
		<head>
	
			<meta charset="UTF-8">
			<title>Page Utilisateur</title>
	
		</head>
	
		<body>
			
			<h1>Liste des utilisateurs</h1>
				
				<table>
					
					<thead>
						
						<tr>
							
							<th>Prenom</th>
							
							<th>Nom</th>
							
							<th>Mot de passe</th>
							
							<th>�diter</th>
							
							<th>Supprimer</th>
							
						</tr>
						
					</thead>
					
					<tbody>
							
						<c:forEach items="${liste}" var="u">
							
							<tr>
							
							 	<td>${u.getId()}</td>
							
							 	<td>${u.getNom()}</td>
							
							 	<td>${u.getPrenom()}</td>
							
							 	<td>${u.getMp()}</td>
							
								<td><a href="/adduserserv?id=${u.id}">�diter</a></td>
							
								<td><a href="delete.jsp?id=${u.id}">Supprimer</a></td>
							
							</tr>
							
						</c:forEach>
						
					</tbody>
				
				</table>
				
			<a href="addUser">Ajouter un utilisateur</a>
	
		</body>
	
	</html>