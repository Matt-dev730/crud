<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>

	<html>
		
		<head>
			
			<meta charset="utf-8">
			
			<link href="CSS/Boutique.css" rel="stylesheet"/>
			
			<link href="CSS/NavBarre-Footer.css" rel="stylesheet"/>
			
			<link href="Bootstrap/css/bootstrap.css" rel="stylesheet">
			
			<script type="text/javascript" src="jquery/jquery-3.4.1.min.js"></script>
			
			<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
			
			<title>Boutique</title>
		
		</head>
	
		<body>
			
			<div class="containt">
			
			<header>	
				
				<img src="img\AlichatUlt.jpg" alt="bannière" class="ban"/>
				
					<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #c24585;">
					
								<a class="navbar-brand" href="#">AliChat</a>
					
							<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					
								<span class="navbar-toggler-icon"></span>
					
							</button>				
					
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
					
							<ul class="navbar-nav mr-auto">
					
								<li class="nav-item">
					
									<a class="nav-link" href="Home.jsp">Acceuil <span class="sr-only">(current)</span></a>
					
								</li>
								
								<li class="nav-item active">
						
									<a class="nav-link" href="Boutique.jsp">Disponible</a>
						
								</li>
								
								<li class="nav-item">
						
									<a class="nav-link" href="Creer.jsp">Sur mesure</a>
						
								</li>
						
								<li class="nav-item">
						
									<a class="nav-link" href="Contact.jsp">Contact</a>
						
								</li>
								
								<li class="nav-item">
						
									<a class="nav-link" href="Login.jsp">Connexion</a>
						
								</li>
								
							</ul>
					
						<form class="form-inline my-2 my-lg-0">
					
							<input class="form-control mr-sm-2" type="search" placeholder="Recherche" aria-label="Recherche">
					
							<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
					
						</form>
					
						</div>
					
					</nav>
				
			</header>
			
			<article>
				
				<nav class="sidebar">
				
					<div class="text">Collections doudou</div>
					
						<ul>
						
							<li><a href="#">Taille</a></li>
							
							<li>
									
								<ul>
									
									<li><a href="#">Chaton</a></li>
											
									<li><a href="#">Chat Adulte</a></li>
											
									<li><a href="#">Papy Chat</a></li>
									
								</ul>
									
							</li>
									
							<li><a href="#">Collection</a></li>
									
							<li>
									
								<ul>
									
									<li><a href="#">Comics</a></li>
											
									<li><a href="#">Harry Potter</a></li>
											
									<li><a href="#">jeux Vidéos</a></li>
											
									<li><a href="#">Manga</a></li>
											
									<li><a href="#">De Saison</a></li>
											
									<li><a href="#">Autre</a></li>
									
								</ul>
									
							</li>
							
							<li><a href="#">Couleurs</a></li>
							
							<li>
									
								<ul>
									
									<li><a href="#">Comics</a></li>
											
									<li><a href="#">Harry Potter</a></li>
											
									<li><a href="#">jeux Vidéos</a></li>
											
									<li><a href="#">Manga</a></li>
											
									<li><a href="#">De Saison</a></li>
											
									<li><a href="#">Autre</a></li>
									
								</ul>
									
							</li>
						
						</ul>
				
				</nav>
				
					<ul id="grid">
						
						<li class="Mix_Comics"><img src="img\chats.jpg" width="240" height="160" alt=""></li>
							
						<li class="Mix_HP"><img src="img\chats.jpg" width="240" height="160" alt=""></li>
							
						<li class="Mix_JV"><img src="img\chats.jpg" width="240" height="160" alt=""></li>
						
						<li class="Mix_Manga"><img src="img\chats.jpg" width="240" height="160" alt=""></li>
							
						<li class="Mix_Saison"><img src="img\chats.jpg" width="240" height="160" alt=""></li>
							
						<li class="Mix_Autre"><img src="img\chats.jpg" width="240" height="160" alt=""></li>
							
					</ul>
				
				</article>
				
			<footer class="page-footer font-small mdb-color lighten-3 pt-4" style="background-color: #c24585;">

          		<div class="container text-center text-md-left">

            	<div class="row">

             	 <div class="col-md-4 col-lg-3 mr-auto my-md-4 my-0 mt-4 mb-1">

	                <h5 class="font-weight-bold text-uppercase mb-4">SERVICE CLIENT</h5>
	                <p>Par mail: Remplir le <a href="Contact.jsp">formulaire de contact</a></p>
	                <p>Prise en charge sous 24h.</p>

	              </div>
	
	              <hr class="clearfix w-100 d-md-none">
	
	              <div class="col-md-2 col-lg-2 mx-auto my-md-4 my-0 mt-4 mb-1">
	
	                <h5 class="font-weight-bold text-uppercase mb-4">INFORMATION</h5>
	
	                <ul class="list-unstyled">
	                
	                  <li><a href="Contact.jsp">Contactez nous</a></li>
	                  <li><a href="Modalité-Livraison.jsp">Livraison</a></li>
	                  <li><a href="Mention-Légales.jsp">Mentions légales</a></li>
	                  <li><a href="Condition.jsp">Conditions d'utilisation</a></li>
	                  <li><a href="Nous.jsp">Qui somme nous ?</a></li>
	                  <li><a href="Sécurité.jsp">Paiement sécurisé</a></li>
	                  
	                </ul>
	
	              </div>
	
	              <hr class="clearfix w-100 d-md-none">
	
	              <div class="col-md-4 col-lg-3 mx-auto my-md-4 my-0 mt-4 mb-1">
	
	                <h5 class="font-weight-bold text-uppercase mb-4">Mon compte</h5>
	
	                <ul class="list-unstyled">
	                
	                  <li><a href="Compte-Commandes.jsp">Mes commandes</a></li>			
	                  <li><a href="Compte-Coordonées.jsp">Mes coordonnées</a></li>
	               
	                </ul>
	
	              </div>
	
	              <hr class="clearfix w-100 d-md-none">
	
	              <div class="col-md-2 col-lg-2 text-center mx-auto my-4">
	
	                <h5 class="font-weight-bold text-uppercase mb-4">NOUS SUIVRE</h5>
	
		               <a href="https://www.facebook.com/Alichat-104632598008565" type="button" class="btn-fb">
				       		<img src="img\Fb.png" alt="Facebook" class="fb"/>
				       </a>
			
				       <a href="#" type="button" class="btn-insta">
				       		<img src="img\Insta.png" alt="Instagram" class="insta"/>
				       </a>
			
				       <a href="#" type="button" class="btn-tw">
				       		<img src="img\Twitter.png" alt="Twitter" class="twitter"/>
				       </a>
	
	              </div>
	
	            </div>
	
	          </div>
	          
	          <div class="footer-copyright text-center py-3">&copy; Alicha.fr | Designed by Matt Brunel</div>

        </footer>
        
        	</div>
        	
			<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
			<script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
			
			<script type="text/javascript">
 
				$(function(){

					$('body').addClass('js');
				 
					$('h2:first').before('<div class="filters">'+
							'<div class="col">'+
								'<h2>Filtres</h2>'
								+
								'<ul>'+
									'<li><button type="button" class="filter" data-filter="Comics">Comics</button></li>'+
									'<li><button type="button" class="filter" data-filter="HarryPotter">Harry Potter</button></li>'+
									'<li><button type="button" class="filter" data-filter="JeuxVideos">Jeux Vidéos</button></li>'+
									'<li><button type="button" class="filter" data-filter="Manga">Manga</button></li>'+
									'<li><button type="button" class="filter all"  data-filter="Saison">Saisonniers</button></li>'+
								'</ul>'+
							'</div>'
							+
							'<div class="col">'+
								'<h2>Ordonner par</h2>'+
								'<ul>'+
									'<li><button type="button" class="sort" data-sort="data-alphabetic" data-order="desc">Lettre Desc.</button></li>'+
									'<li><button type="button" class="sort" data-sort="data-alphabetic" data-order="asc">Lettre Asc.</button></li>'+
									'<li><button type="button" class="sort line" data-sort="data-numeric" data-order="desc">Numérique Desc.</button></li>'+
									'<li><button type="button" class="sort" data-sort="data-numeric" data-order="asc">Numérique Asc.</button></li>'+
									'<li><button type="button" class="sort line active" data-sort="default" data-order="asc">Normal</button></li>'+
									'<li><button type="button" class="sort" data-sort="random">Aléatoire</button></li>'+
								'</ul>'+
							'</div>'+
						'</div>');
				 
				});
				
					$('#grid').mixitup({
						effects: ['fade','scale','rotateZ'],
					});
			</script>
			
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
			<script src="Bootstrap/js/bootstrap.js"></script>
			<script type="text/javascript" src="JS/Filtre.js"></script>
		
		</body>
	
	</html>