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
							
							<th>Id</th>
							
							<th>Prenom</th>
							
							<th>Nom</th>
							
							<th>Mot de passe</th>
							
							<th>Éditer</th>
							
							<th>Supprimer</th>
							
						</tr>
						
					</thead>
					
					<tbody>
							
						<c:forEach items="${list}" var="u">
							
							<tr>
							
							 	<td>${u.getId()}</td>
							
							 	<td>${u.getNom()}</td>
							
							 	<td>${u.getPrenom()}</td>
							
							 	<td>${u.getMp()}</td>
							
								<td><a href="update?id=${u.id}">Éditer</a></td>
							
								<td><a href="deleteUser?id=${u.id}">Supprimer</a></td>
							
							</tr>
							
						</c:forEach>
						
					</tbody>
				
				</table>
				
			<a href="addUser">Ajouter un utilisateur</a>
	
		</body>
	
	</html>