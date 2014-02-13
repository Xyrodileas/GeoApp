
public class ListePerso{
	/**
	 * STRATÉGIE : implémentation dynamique par chaînage simple
	 * 
	 *            Une Liste est un ou pls noeuds liés ensemble 
	 *
	 *            Une référence pointant toujours sur la position courante
	 *
	 */
	 private static class Noeud{
		 
		 //la liste peut les utiliser directement via un objet
		 //donc pas besoin d'accesseurs et de mutateurs
		 private Formes element;
		 private Noeud suivant;	 
		 
		 //constructeur par copie d'attributs
		 public Noeud(Formes element, Noeud lien){
			 this.element = element;
			 suivant = lien;
		 }
	 }
	 
	 /**
	  * ATTRIBUTS
	  */
	 
	 //début et fin de liste constamment actualisés
	 private Noeud debut;
	 private  Noeud fin;
	 
	 private int nbElement;
	 
	 //la position courante
	 private Noeud position;
	
	 	 
	 /**
	  * Crée une liste vide 
	  * debut = fin = position = null;
	  */
	 public ListePerso(){
		 
		 debut = fin = position = null;
		 nbElement = 0;
	 }
	
	 /**
	  * Insère l'élément reçu en début de liste
	  * antédécent : aucun
	  * conséquence : nbElement = nbElement + 1 
	  *                  position == debut 
	  *                  this.getElement() == element
      * @param element à insérer dans la liste                  
	  */
	 private void insererDebut(Formes element){
		 
		 //on crée un noeud en faisant le lien sur l'ancien début
  	     debut = new Noeud(element,debut);
  	     
  	     //la première fois il faut placer le pointeur de fin
  	     if (nbElement == 0)
		     fin = debut;
  	     
  	     //place la position courante au début 
		 position = debut;
		 
		 //incrémentation du nombre délément
		 nbElement++;
	 }
	 
	 
	 /**
	  * Insère l'élément reçu après la position courante
      * antédécent : aucun
	  * conséquence : nbElement = nbElement + 1 &       
	  *              liste.getElement() == element
	  * @param element à insérer dans la liste
	  *  
	  */
	 public void insererApres(Formes element){
		 
		 //si la liste est vide, on insère au début
		 if(debut == null)
			 insererDebut(element);
		 
		 //Sinon on insère après la position courante et la position se déplace
		 else {

			 //coupe le lien du suivant et le pointe sur le nouveau noeud
			  //le nouveau noeud pointe sur l'ancien suivant
		      position.suivant = new Noeud(element,position.suivant);
		      
		      //cas du dernier noeud
		      if(position == fin)
		    	  
		    	  //on déplace la fin
		    	  fin = position.suivant;

		      
		      //On place la position courante sur le suivant
		      position = position.suivant;
		      
			  
		      //on incrémente le nombre d'élément
		      nbElement++;		      
			 
		 }
	 }
	 
	 /**
	  * Insère l'élément reçu avant la position courante
      * antédécent : aucun
	  * conséquence : nbElement = nbElement + 1 &       
	  *                  liste.getElement() == element
	  * @param element à insérer dans la liste
	  */
	 public void insererAvant(Formes element){
	 
		 //si la liste est vide, on insère au début
		 if(debut == null)
			 insererDebut(element);
		 
		 //on insère après et on inverse les données
		 else{
			 
			 //noeud temporaire pour conserver la position actuelle			
			 //pour éviter de parcourir la liste et trouver le précédent
			 Noeud tmp = position;
			 			 		  
			 //on insere après en copiant la valeur de la position actuelle
			 insererApres(position.element);
			 
			 //on met le nouvel element à l'ancienne position
			 tmp.element = element;		

              //replace la position courante sur le précédent      
             position = tmp;
             
		 }
		 
	 }
	 
	  
	 /**
	  * Retourne l'élément à la position courante et l'enlève
	  * de la structure
	  * 
	  * antécédent : la liste ne doit pas être vide
	  * @throws ListeVideException 
	  * @return L'élément à la position courante
	  * @Override
	  */
	 public Object getElement() throws ListeVideException {

		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez récupérer un élément " +
                                          "dans une liste vide");
		 
		 //sinon on retourne l'élément
		 
		 return position.element;
	 }
	  
	 /**
	  * Passe la position courante au suivant dans la liste
	  * antécédent : aucun
	  * conséquence : position est déplacée sur l'élément suivant s'il existe
	  *                  sinon position courante == fin 
 	  * @throws ListeVideException 
	  */
	 public void suivant()  throws ListeVideException{
		
		 //si la liste est vide, on avise
		 if(debut == null)
		     throw new ListeVideException("Vous ne pouvez aller au suivant " +
		     		                      "dans une liste vide");
		 
		 //si c'est la fin, on ne déplace pas, sinon ...
		 if(position.suivant != null){
			 
			 //on passe au suivant
    	     position = position.suivant;
		 
    	  }
			//Applique les changements On avise l'observeur
	
	 }
	 
	 /**
	  * Met la position courante au début de la  liste
	  * antécédent : la liste ne doit pas être vide
	  * conséquence : position == debut  
 	  * @throws ListeVideException 
	  */
	 
	 public void premier() throws ListeVideException{

		 //si la liste est vide, on avise
         if(debut == null)
			 throw new ListeVideException("Vous ne pouvez aller au début " +
			 		                      "dans une liste vide");
		 
         //on déplace la position courante au début
		 position = debut;
			//Applique les changements On avise l'observeur
		
		 
	 }

	 /**
	  * Met la position courante à la fin de la liste
	  * antécédent : la liste ne doit pas être vide
	  * conséquence : position == fin
 	  * @throws ListeVideException 
	  */  
	 public void dernier() throws ListeVideException{
		 
		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez aller à la fin " +
			 		                      "dans une liste vide");
		 
         //on déplace la position courante à la fin
		 position = fin;

	 }
	 
	 /**
	  * Passe la position courante au précédent dans la liste
	  * antécédent : la liste ne doit pas être vide
	  * conséquence : la position courante est sur l'élément précédent s'il existe
	  *                  sinon position courante == debut
 	  * @throws ListeVideException 
	  */
	 public void precedent() throws ListeVideException{
	
		 //si la liste est vide, on avise
		 if(debut == null )
			 throw new ListeVideException("Vous ne pouvez aller au précédent " +
		                      	 		  "dans une liste vide");
		 if(position != debut){
			 //on se place au début
			 Noeud posTmp = debut;
			 //tant qu'on n'est pas sur l'élément voulu 
			 while(posTmp.suivant != position)

				 //on passe au suivant
				 posTmp = posTmp.suivant;
			 
			 //on place la position courante sur le précédent
			 position = posTmp;
		 }
	 }	
	 
	 /**
	  * Supprime l'élément à la position courante
	  * antécédent : la liste ne doit pas être vide
	  * conséquence : nbElement = nbElement - 1 &
	  *                  position == position.suivant |
	  *                  position == fin == debut si dernier élément
 	  * @throws ListeVideException 
	  */
	 public void supprime() throws ListeVideException{

		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez supprimer " +
			 		                      "dans une liste vide");
		 
		 //cas spécial; un seul élément
		 if(debut == fin){
		    debut = fin = position = null;
		 }
		 
		 //cas spécial; le premier élément
		 else if(position == debut){
			  debut = debut.suivant;
		       position = debut;
		 }		     
		 else{
			    //on retient si c'est le dernier de la liste
			    boolean dernier = position.suivant == null;			     
			 
    		     //cas spécial; le dernier élément
	   	         if(dernier){
	   	        	 
	 				//on ne peut pas utiliser la procédure précédent()
	   	           //parqu'elle avertit les observateurs 
	   	           //On utilise une autre boucle locale qui itère simplement.
	   	        	 //et déplace le  pointeur de fin sur la position précédent
	   	          fin = debut;
	   	         
	   	          while(fin.suivant !=position)
	   	        	  fin = fin.suivant;
	 		     
 		            //on libère le noeud suivant
		            fin.suivant = null;
		            
		            //On replace la position sur la fin
		            position = fin;
		        }		            
	   	         
				 //on copie le suivant dans l'actuel cela supprime le suivant
	   	         //pour détruire en O(1).  À noter que la position ne change pas
				 else{
					 position.element  = position.suivant.element;		 
					 position.suivant  = position.suivant.suivant;
					 
					 //encore un dernier cas spécial;  Si on a détruit l'avant dernier
					 //il faut ajuster le pointeur de fin
					 if(position.suivant == null)
						 fin = position;
				 }
	   	 }
		 
		 //On décrémente le nombre d'éléments
		 nbElement--;
	
	 }

		/**
		 * Retourne un tableau dont les objets sont 
		 * disposés dans le même sens que la ListePerso.
		 *
		 * Cela signifie que l'élément du debut de la ListePerso
		 * est dans la première case du tableau.
		 * 
		 * @return [] d'objets de la ListePerso
		 */
	public Formes[] retournerUnTableauDobjet() {
		//Le tableau à retourner
		Formes[] tab = new Formes[nbElement];

		//Référence temporaire pour parourir la liste du debut a la fin
		Noeud tmp = debut;

			//Indice du tableau
			int i = 0;

			//Tant qu'on a pas atteint la fin de la liste on boucle
			while(tmp != null){
				
				
				//On retient l element dans le tableau
				tab[i] = tmp.element;				
				//On passe à l'élément suivant dans la pile
				tmp = tmp.suivant;	

				//On place l'itérateur pour le prochain ajout
				i++;
			}
			return tab.clone();
			
	} 

	
	/**
	 * Ajoute element dans la liste
	 * antecedent : le mode d'insertion AVANT OU APRES
	 * @param (Object) element a ajoute par rapport a la positon courante
	 */
	public void ajoute(Formes element,int modeInsertion) throws Exception {
		//cas ou le choix d'insertion est AVANT
		if(modeInsertion==0){
			insererAvant(element);
		}
		//cas ou le choix d'insertion est APRES
		else if(modeInsertion==1){
			insererApres(element);
			
		}
	}

	/**
	 * Fonction qui permet de retourner
	 * l'indice de position.element dans
	 * le tableau Array() grace a un 
	 * tableau temporaire
	 * @return int (i)
	 * @throws ListeVideException
	 */
	public int getPosition() throws ListeVideException {
		//si Vide alors exception
		if(debut==null){
			throw new ListeVideException("La Liste est vide il n'y a pas de position");
		}
		//creation d'un tableau temporaire tmp=toArray();
		Object [] tmp=this.retournerUnTableauDobjet();
		int i=0;
		//Tant que un element du tableau ne sera pas identique a position.element on increment i
		while(tmp[i]!=position.element){
			i++;
		}
		return i;
	}
	
	//Unité de test
	public void afficheElementDeListe() throws ListeVideException{
			premier();

			//Référence temporaire pour parourir la liste du debut a la fin
			Noeud tmp = debut;
			
				while(tmp != null){
				
					//aFFICHE
				System.out.println((tmp.element).getNom());
							
				//On passe à l'élément suivant dans la pile
				tmp = tmp.suivant;	

			}
	}
	
	
}