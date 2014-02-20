import Formes.Formes;

public class ListePerso{
	/**
	 * STRAT�GIE : impl�mentation dynamique par cha�nage simple
	 * 
	 *            Une Liste est un ou pls noeuds li�s ensemble 
	 *
	 *            Une r�f�rence pointant toujours sur la position courante
	 *
	 */
	 public  class Noeud{

		 //la liste peut les utiliser directement via un objet
		 //donc pas besoin d'accesseurs et de mutateurs
		 private Formes element;
		 private Noeud suivant;

		 //constructeur par copie d'attributs
		 public Noeud(Formes element, Noeud lien){
			 this.element = element;
			 suivant = lien;
		 }
		 
		 
		 public Formes getElement(){
			 
			 return this.element;
			 
		 }
		 
		 
	 }
	
	 
	 /**
	  * ATTRIBUTS
	  */
	 
	 //d�but et fin de liste constamment actualis�s
     private Noeud debut;
	 private Noeud fin;
	 
	 private int nbElement;
	 
	 //la position courante
	 private Noeud position;
	
	 	 
	 /**
	  * Cr�e une liste vide 
	  * debut = fin = position = null;
	  */
	 public ListePerso(){
		 
		 debut = fin = position = null;
		 nbElement = 0;
	 }
	
		
	 
	 /**
	  * Constructeur : ListePerso(ListePerso listeRecu)
	  * Permet de construire une liste chaine depuis une autre
	  * en la copiant
	  * @param listeRecu ListePerso
	  * @throws Exception
	  */
	public ListePerso(ListePerso listeRecu) throws Exception{
		
		 debut = fin = position = null;
		 nbElement = 0;
		 
			Noeud tmplisteRecu = listeRecu.debut;
			
				while(tmplisteRecu != null){
				
				
				//System.out.println((tmplisteRecu.element).getNom());
				this.ajoute(tmplisteRecu.element, 1);
				
				
				tmplisteRecu = tmplisteRecu.suivant;	

			}
	}
	 
	 
	 /**
	  * Insere la Forme recu en debut de liste
	  * antecedent : aucun
	  * consequence : nbElement = nbElement + 1 
	  *                  position == debut 
	  *                  this.getElement() == element
      * @param Forme a inserer dans la liste                  
	  */
	 public void insererDebut(Formes element){
		 
		 //on cree un noeud en faisant le lien sur l'ancien debut
  	     debut = new Noeud(element,debut);
  	     
  	     //la premiere fois il faut placer le pointeur de fin
  	     if (nbElement == 0)
		     fin = debut;
  	     
  	     //place la position courante au debut 
		 position = debut;
	 }
	 
	 
	 /**
	  * Insere la Forme recu apres la position courante
      * antecedent : aucun
	  * consequence : nbElement = nbElement + 1 &       
	  *              liste.getElement() == element
	  * @param Forme a inserer dans la liste
	  *  
	  */
	 public void insererApres(Formes element){
		 
		 //si la liste est vide, on insere au debut
		 if(debut == null)
			 insererDebut(element);
		 
		 //Sinon on insere apres la position courante et la position se deplace
		 else {

			 //coupe le lien du suivant et le pointe sur le nouveau noeud
			  //le nouveau noeud pointe sur l'ancien suivant
		      position.suivant = new Noeud(element,position.suivant);
		      
		      //cas du dernier noeud
		      if(position == fin)
		    	  
		    	  //on d�place la fin
		    	  fin = position.suivant;

		      
		      //On place la position courante sur le suivant
		      position = position.suivant;
		      		      
			 
		 }
	 }
	 
	 /**
	  * Insere la forme recu avant la position courante
      * antecedent : aucun
	  * consequence : nbElement = nbElement + 1 &       
	  *                  liste.getElement() == element
	  * @param Forme a inserer dans la liste
	  */
	 public void insererAvant(Formes element){
	 
		 //si la liste est vide, on insere au debut
		 if(debut == null)
			 insererDebut(element);
		 
		 //on insere apres et on inverse les donn�ees
		 else{
			 
			 //noeud temporaire pour conserver la position actuelle			
			 //pour eviter de parcourir la liste et trouver le prec�edent
			 Noeud tmp = position;
			 			 		  
			 //on insere apres en copiant la valeur de la position actuelle
			 insererApres(position.element);
			 
			 //on met le nouvel element a l'ancienne position
			 tmp.element = element;		

              //replace la position courante sur le precedent      
             position = tmp;
             
		 }
		 
	 }
	 
	  
	 /**
	  * Retourne la forme de la position courante
	  * 
	  * antecedent : la liste ne doit pas etre vide
	  * @throws ListeVideException 
	  * @return Forme position courante
	  */
	 public Formes getElement() throws ListeVideException {

		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez rien recuperer dans une liste vide ");
		 
		 //sinon on retourne l'�l�ment
		 
		 return position.element;
	 }
	 
	 
	 
	  
	 /**
	  * Passe la position courante au suivant dans la liste
	  * antecedent : aucun
	  * consequence : position est deplace sur l'element suivant s'il existe
	  *                  sinon position courante == fin 
 	  * @throws ListeVideException 
	  */
	 public void suivant()  throws ListeVideException{
		
		 //si la liste est vide, on avise
		 if(debut == null)
		     throw new ListeVideException("Vous ne pouvez aller au suivant " +
		     		                      "dans une liste vide");
		 
		 //si c'est la fin, on ne delace pas, sinon ...
		 if(position.suivant != null){
			 
			 //on passe au suivant
    	     position = position.suivant;
		 
    	  }
	
	 }
	 
	 
	 
	 /**
	  * Methode : retourneSuivant() 
	  * Permet de retourner l'element suivant de la 
	  * position courante
	  * @return Noeud (suivant)
	  * @throws ListeVideException
	  */
	 public Noeud retourneSuivant()  throws ListeVideException{
			
		 //si la liste est vide, on avise
		 if(debut == null)
		     throw new ListeVideException("Vous ne pouvez aller au suivant " +
		     		                      "dans une liste vide");
		 
		 //si c'est la fin, on ne deplace pas, sinon ...
		 if(position.suivant != null){
			 
			 //on passe au suivant
    	     position = position.suivant;
		 
    	  }
		return position;
	
	 }
	 
	 /**
	  * Met la position courante au debut de la  liste
	  * antecedent : la liste ne doit pas etre vide
	  * consequence : position == debut  
 	  * @throws ListeVideException 
	  */
	 
	 public void premier() throws ListeVideException{

		 //si la liste est vide, on avise par exception
         if(debut == null)
			 throw new ListeVideException("Vous ne pouvez aller au debut " +
			 		                      "dans une liste vide");
		 
         //on deplace la position courante au debut
		 position = debut;
		
		 
	 }

	 
	 
	 /**
	  * Met la position courante a la fin de la liste
	  * antecedent : la liste ne doit pas etre vide
	  * consequence : position == fin
 	  * @throws ListeVideException 
	  */  
	 public void dernier() throws ListeVideException{
		 
		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez aller � la fin " +
			 		                      "dans une liste vide");
		 
         //on d�place la position courante � la fin
		 position = fin;

	 }
	 
	 
	 
	 /**
	  * Passe la position courante au preceent dans la liste
	  * antecedent : la liste ne doit pas etre vide
	  * consequence : la position courante est sur l'element precedent s'il existe
	  *                  sinon position courante == debut
 	  * @throws ListeVideException 
	  */
	 public void precedent() throws ListeVideException{
	
		 //si la liste est vide, on avise par exception
		 if(debut == null )
			 throw new ListeVideException("Vous ne pouvez aller au pr�c�dent " +
		                      	 		  "dans une liste vide");
		 if(position != debut){
			 //on se place au debut
			 Noeud posTmp = debut;
			 //tant qu'on n'est pas sur l'�l�ment voulu 
			 while(posTmp.suivant != position)

				 //on passe au suivant
				 posTmp = posTmp.suivant;
			 
			 //on place la position courante sur le precedent
			 position = posTmp;
		 }
	 }	
	 
	 
	 
	 /**
	  * Supprime les Formes de la liste chainee
	  * selon les position courante
	  * Il y different cas possible a gerer selon la position
	  * antecedent : la liste ne doit pas etre vide
	  * consequence : 	nbElement = nbElement - 1 &
	  *                  position == position.suivant |
	  *                  position == fin == debut si dernier el�ment
 	  * @throws ListeVideException 
	  */
	 public void supprime() throws ListeVideException{

		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez supprimer " +
			 		                      "dans une liste vide");
		 
		 //cas special; un seul element
		 if(debut == fin){
		    debut = fin = position = null;
		 }
		 
		 //cas special; le premier element
		 else if(position == debut){
			  debut = debut.suivant;
		       position = debut;
		 }		     
		 else{
			    //on retient si c'est le dernier de la liste
			    boolean dernier = position.suivant == null;			     
			 
	   	         if(dernier){
	   	        	
	   	          fin = debut;
	   	         
	   	          while(fin.suivant !=position)
	   	        	  fin = fin.suivant;
	 		     
 		            //on libere le noeud suivant
		            fin.suivant = null;
		            
		            //On replace la position sur la fin
		            position = fin;
		        }		            
	   	         
				 //on copie le suivant dans l'actuel cela supprime le suivant
				 else{
					 position.element  = position.suivant.element;		 
					 position.suivant  = position.suivant.suivant;
					 
					 //il faut ajuster le pointeur de fin
					 if(position.suivant == null)
						 fin = position;
				 }
	   	 }
		 
		 //On decremente le nombre d'elements
		 nbElement--;
	
	 }
	 
	 

		/**
		 * Retourne un tableau dont les formes sont 
		 * disposees dans le meme sens que celui de leur arrive
		 * mais aussi selon le tri voulu
		 * 
		 * @return [] Formes ( de ListePerso)
		 */
	public Formes[] retournerUnTableauDobjet() {
		//Le tableau retourner
		Formes[] tab = new Formes[nbElement];

		//Reference temporaire pour parcourir la liste
		//du debut a la fin
		Noeud tmp = debut;

			//Indice du tableau
			int i = 0;

			//Tant qu'on a pas atteint la fin de la liste on parcours
			while(tmp != null){
				
				
				//On retient l element dans le tableau
				tab[i] = tmp.element;				
				//On passe a l'element suivant de la liste
				tmp = tmp.suivant;	
				//on incremente l'indice du tableau
				i++;
			}
			return tab.clone();
			
	} 

	
	
	/**
	 * Ajoute element dans la liste
	 * antecedent : le mode d'insertion AVANT OU APRES
	 * @param element element a ajoute par rapport a la positon courante
	 */
	public void ajoute(Formes element,int modeInsertion) {
		//cas ou le choix d'insertion est AVANT
		if(modeInsertion==0){
			insererAvant(element);
		}
		//cas ou le choix d'insertion est APRES
		else if(modeInsertion==1){
			insererApres(element);
			
		}
		nbElement++;
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
	
	
	/**
	 * Methode : getNbElementListe()
	 * permet de retourner le nombre d'element dans la liste
	 * @return (int) nbElement
	 */
	public int getNbElementListe(){
		return nbElement;
	}
	
	 
	 
	 /**
	  * Methode videLaListeAuComplet()
	  * Permet de supprimer tous les elments de la liste
	  * @throws ListeVideException
	  */
	 public void videLaListeAuComplet() throws ListeVideException{
		 for(int i =0;i<10;i++){
			 this.supprime();
		 }
			 
	 }
	 
		
	 
	 
	
	
	//Unit� de test
	public void afficheElementDeListe() throws ListeVideException{
			premier();

			//R�f�rence temporaire pour parourir la liste du debut a la fin
			Noeud tmp = debut;
			
				while(tmp != null){
				
					//aFFICHE
				System.out.println((tmp.element).getNom());
							
				//On passe � l'�l�ment suivant dans la pile
				tmp = tmp.suivant;	

			}
	}
	//Unit� de test2
		public void afficheIdDeLaLIste() throws ListeVideException{
				premier();
				int i=0;
				//R�f�rence temporaire pour parourir la liste du debut a la fin
				Noeud tmp = debut;
				
					while(tmp != null){
					
						//aFFICHE
					System.out.println((tmp.element).getIDLogger() + "indice : "+i);
								
					//On passe � l'�l�ment suivant dans la pile
					tmp = tmp.suivant;	
					i++;

				}
		}
    //Unit� de test2
    public void affichegetHauteur() throws ListeVideException{
        premier();
        int i=0;
        //R�f�rence temporaire pour parourir la liste du debut a la fin
        Noeud tmp = debut;

        while(tmp != null){

            //aFFICHE
            System.out.println((tmp.element).getHauteur() + "indice : "+i + (tmp.element).getNom());

            //On passe � l'�l�ment suivant dans la pile
            tmp = tmp.suivant;
            i++;

        }
    }
    public void affichegetLargeur() throws ListeVideException{
        premier();
        int i=0;
        //R�f�rence temporaire pour parourir la liste du debut a la fin
        Noeud tmp = debut;

        while(tmp != null){

            //aFFICHE
            System.out.println((tmp.element).getLargeur() + "indice : "+i + (tmp.element).getNom());

            //On passe a l'element suivant dans la pile
            tmp = tmp.suivant;
            i++;

        }
    }
		
		//Unit� de test3
		public void afficheAireDeLaLIste() throws ListeVideException{
				premier();
				int i=0;
				//Reference temporaire pour parourir la liste du debut a la fin
				Noeud tmp = debut;
				
					while(tmp != null){
					
						//aFFICHE
					System.out.println((tmp.element).getAire() + "indice : "+i);
								
					//On passe a l'element suivant dans la pile
					tmp = tmp.suivant;	
					i++;

				}
		}
		
		//Unit� de test4
		public void afficheOrdreDarriveDeLaListe() throws ListeVideException{
				premier();
				//R�f�rence temporaire pour parourir la liste du debut a la fin
				Noeud tmp = debut;
				
					while(tmp != null){
					
						//aFFICHE
					System.out.println((tmp.element).getOrdreArriveForme());
								
					//On passe � l'�l�ment suivant dans la pile
					tmp = tmp.suivant;	

				}
		}

		
	
	
}