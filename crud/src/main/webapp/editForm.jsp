<!DOCTYPE html>
	
	<html>
	
		<head>
	
			<meta charset=UTF-8>
			<title>Edit Form</title>
	
		</head>
	
		<body>
	
			<h1>Edit Form</h1>
	
					<form action="update.jsp" >
	
					<input type="hidden" name="id" value="${ param.id }"/>
							      
						Prenom    : <input type="text" name="prenom" value="${param.prenom}"/> <br>
						Nom       : <input type="text" name="nom" value='${ param.nom }'/><br>
						Motdepasse       : <input type="text" name="motdepasse" value='${ param.motdepasse }'/><br>
						
					<input type="submit" value="Éditer"/>
		        
		    </form>
		</body>
	</html>