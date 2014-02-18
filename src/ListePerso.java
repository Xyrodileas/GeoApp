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
	  Noeud debut;
	  Noeud fin;
	 
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
	  * Ins�re l'�l�ment re�u en d�but de liste
	  * ant�d�cent : aucun
	  * cons�quence : nbElement = nbElement + 1 
	  *                  position == debut 
	  *                  this.getElement() == element
      * @param element � ins�rer dans la liste                  
	  */
	 public void insererDebut(Formes element){
		 
		 //on cr�e un noeud en faisant le lien sur l'ancien d�but
  	     debut = new Noeud(element,debut);
  	     
  	     //la premi�re fois il faut placer le pointeur de fin
  	     if (nbElement == 0)
		     fin = debut;
  	     
  	     //place la position courante au d�but 
		 position = debut;
		 
		 //incr�mentation du nombre d�l�ment
		 
	 }
	 
	 
	 /**
	  * Ins�re l'�l�ment re�u apr�s la position courante
      * ant�d�cent : aucun
	  * cons�quence : nbElement = nbElement + 1 &       
	  *              liste.getElement() == element
	  * @param element � ins�rer dans la liste
	  *  
	  */
	 public void insererApres(Formes element){
		 
		 //si la liste est vide, on ins�re au d�but
		 if(debut == null)
			 insererDebut(element);
		 
		 //Sinon on ins�re apr�s la position courante et la position se d�place
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
	  * Ins�re l'�l�ment re�u avant la position courante
      * ant�d�cent : aucun
	  * cons�quence : nbElement = nbElement + 1 &       
	  *                  liste.getElement() == element
	  * @param element � ins�rer dans la liste
	  */
	 public void insererAvant(Formes element){
	 
		 //si la liste est vide, on ins�re au d�but
		 if(debut == null)
			 insererDebut(element);
		 
		 //on ins�re apr�s et on inverse les donn�es
		 else{
			 
			 //noeud temporaire pour conserver la position actuelle			
			 //pour �viter de parcourir la liste et trouver le pr�c�dent
			 Noeud tmp = position;
			 			 		  
			 //on insere apr�s en copiant la valeur de la position actuelle
			 insererApres(position.element);
			 
			 //on met le nouvel element � l'ancienne position
			 tmp.element = element;		

              //replace la position courante sur le pr�c�dent      
             position = tmp;
             
		 }
		 
	 }
	 
	  
	 /**
	  * Retourne l'�l�ment � la position courante et l'enl�ve
	  * de la structure
	  * 
	  * ant�c�dent : la liste ne doit pas �tre vide
	  * @throws ListeVideException 
	  * @return L'�l�ment � la position courante
	  * @Override
	  */
	 public Formes getElement() throws ListeVideException {

		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez r�cup�rer un �l�ment " +
                                          "dans une liste vide");
		 
		 //sinon on retourne l'�l�ment
		 
		 return position.element;
	 }
	  
	 /**
	  * Passe la position courante au suivant dans la liste
	  * ant�c�dent : aucun
	  * cons�quence : position est d�plac�e sur l'�l�ment suivant s'il existe
	  *                  sinon position courante == fin 
 	  * @throws ListeVideException 
	  */
	 public void suivant()  throws ListeVideException{
		
		 //si la liste est vide, on avise
		 if(debut == null)
		     throw new ListeVideException("Vous ne pouvez aller au suivant " +
		     		                      "dans une liste vide");
		 
		 //si c'est la fin, on ne d�place pas, sinon ...
		 if(position.suivant != null){
			 
			 //on passe au suivant
    	     position = position.suivant;
		 
    	  }
			//Applique les changements On avise l'observeur
	
	 }
	 public Noeud retourneSuivant()  throws ListeVideException{
			
		 //si la liste est vide, on avise
		 if(debut == null)
		     throw new ListeVideException("Vous ne pouvez aller au suivant " +
		     		                      "dans une liste vide");
		 
		 //si c'est la fin, on ne d�place pas, sinon ...
		 if(position.suivant != null){
			 
			 //on passe au suivant
    	     position = position.suivant;
		 
    	  }
		return position;
	
	 }
	 
	 /**
	  * Met la position courante au d�but de la  liste
	  * ant�c�dent : la liste ne doit pas �tre vide
	  * cons�quence : position == debut  
 	  * @throws ListeVideException 
	  */
	 
	 public void premier() throws ListeVideException{

		 //si la liste est vide, on avise
         if(debut == null)
			 throw new ListeVideException("Vous ne pouvez aller au d�but " +
			 		                      "dans une liste vide");
		 
         //on d�place la position courante au d�but
		 position = debut;
			//Applique les changements On avise l'observeur
		
		 
	 }

	 /**
	  * Met la position courante � la fin de la liste
	  * ant�c�dent : la liste ne doit pas �tre vide
	  * cons�quence : position == fin
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
	  * Passe la position courante au pr�c�dent dans la liste
	  * ant�c�dent : la liste ne doit pas �tre vide
	  * cons�quence : la position courante est sur l'�l�ment pr�c�dent s'il existe
	  *                  sinon position courante == debut
 	  * @throws ListeVideException 
	  */
	 public void precedent() throws ListeVideException{
	
		 //si la liste est vide, on avise
		 if(debut == null )
			 throw new ListeVideException("Vous ne pouvez aller au pr�c�dent " +
		                      	 		  "dans une liste vide");
		 if(position != debut){
			 //on se place au d�but
			 Noeud posTmp = debut;
			 //tant qu'on n'est pas sur l'�l�ment voulu 
			 while(posTmp.suivant != position)

				 //on passe au suivant
				 posTmp = posTmp.suivant;
			 
			 //on place la position courante sur le pr�c�dent
			 position = posTmp;
		 }
	 }	
	 
	 /**
	  * Supprime l'�l�ment � la position courante
	  * ant�c�dent : la liste ne doit pas �tre vide
	  * cons�quence : nbElement = nbElement - 1 &
	  *                  position == position.suivant |
	  *                  position == fin == debut si dernier �l�ment
 	  * @throws ListeVideException 
	  */
	 public void supprime() throws ListeVideException{

		 //si la liste est vide, on avise
		 if(debut == null)
			 throw new ListeVideException("Vous ne pouvez supprimer " +
			 		                      "dans une liste vide");
		 
		 //cas sp�cial; un seul �l�ment
		 if(debut == fin){
		    debut = fin = position = null;
		 }
		 
		 //cas sp�cial; le premier �l�ment
		 else if(position == debut){
			  debut = debut.suivant;
		       position = debut;
		 }		     
		 else{
			    //on retient si c'est le dernier de la liste
			    boolean dernier = position.suivant == null;			     
			 
    		     //cas sp�cial; le dernier �l�ment
	   	         if(dernier){
	   	        	 
	 				//on ne peut pas utiliser la proc�dure pr�c�dent()
	   	           //parqu'elle avertit les observateurs 
	   	           //On utilise une autre boucle locale qui it�re simplement.
	   	        	 //et d�place le  pointeur de fin sur la position pr�c�dent
	   	          fin = debut;
	   	         
	   	          while(fin.suivant !=position)
	   	        	  fin = fin.suivant;
	 		     
 		            //on lib�re le noeud suivant
		            fin.suivant = null;
		            
		            //On replace la position sur la fin
		            position = fin;
		        }		            
	   	         
				 //on copie le suivant dans l'actuel cela supprime le suivant
	   	         //pour d�truire en O(1).  � noter que la position ne change pas
				 else{
					 position.element  = position.suivant.element;		 
					 position.suivant  = position.suivant.suivant;
					 
					 //encore un dernier cas sp�cial;  Si on a d�truit l'avant dernier
					 //il faut ajuster le pointeur de fin
					 if(position.suivant == null)
						 fin = position;
				 }
	   	 }
		 
		 //On d�cr�mente le nombre d'�l�ments
		 nbElement--;
	
	 }

		/**
		 * Retourne un tableau dont les objets sont 
		 * dispos�s dans le m�me sens que la ListePerso.
		 *
		 * Cela signifie que l'�l�ment du debut de la ListePerso
		 * est dans la premi�re case du tableau.
		 * 
		 * @return [] d'objets de la ListePerso
		 */
	public Formes[] retournerUnTableauDobjet() {
		//Le tableau � retourner
		Formes[] tab = new Formes[nbElement];

		//R�f�rence temporaire pour parourir la liste du debut a la fin
		Noeud tmp = debut;

			//Indice du tableau
			int i = 0;

			//Tant qu'on a pas atteint la fin de la liste on boucle
			while(tmp != null){
				
				
				//On retient l element dans le tableau
				tab[i] = tmp.element;				
				//On passe � l'�l�ment suivant dans la pile
				tmp = tmp.suivant;	

				//On place l'it�rateur pour le prochain ajout
				i++;
			}
			return tab.clone();
			
	} 

	
	/**
	 * Ajoute element dans la liste
	 * antecedent : le mode d'insertion AVANT OU APRES
	 * @param element element a ajoute par rapport a la positon courante
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
	
	public boolean estVide(){
		System.out.println(" Voici le nombre d'elements : "+nbElement);
		if(nbElement==0)
			return true;
		return false;
	}

	public int getNbElementListe(){
		return nbElement;
	}
	
	
	/**
	 * Parcours la liste pour faire des ajout par ordre croissant selon NumSequence ou Aire
	 * @param chiffreAcomparer (La forme a comparer)
	 * @param type (0=Sequence , 1=Aire)
	 * @return boolean
	 */
	 public boolean ParcourirTriCroissant(int chiffreAcomparer,int type){
			
			boolean insereAvant =false;
			
			//R�f�rence temporaire pour parourir la liste du debut a la fin
			Noeud tmp = debut;
			position=debut;
			int nbsuperieur=0;
			
				while(tmp != null ){
					
					if (type==0){
						if((tmp.element).getIDLogger()< chiffreAcomparer){
							insereAvant=true;
							position=tmp;
						}
						else if((tmp.element).getIDLogger()> chiffreAcomparer && nbsuperieur<1) {
							nbsuperieur++;
							insereAvant=false;
							position=tmp;
						}
					}
					if(type==1){
						
						if((tmp.element).getAir()< (double)chiffreAcomparer){
							insereAvant=true;
							position=tmp;
						}
						else if((tmp.element).getAir()> (double)chiffreAcomparer && nbsuperieur<1) {
							nbsuperieur++;
							insereAvant=false;
							position=tmp;
						}
						
					}
					tmp = tmp.suivant;
					
				}
			return	insereAvant;
		 
	 }
	 
	 
	 public boolean ParcourirTriDecroissant(int chiffreAcomparer, int type){
			
			boolean insereAvant =true;
			
			//R�f�rence temporaire pour parourir la liste du debut a la fin
			Noeud tmp = debut;
			position=debut;
			int nbsuperieur=0;
			
				while(tmp != null ){
					//System.out.println("Les �lements a comparer sont  Noeud existant" +(tmp.element).getIDLogger()+  "Forme a ajouter "+chiffreAcomparer);
					
					if (type==0){
						if((tmp.element).getIDLogger()> chiffreAcomparer) {
							insereAvant=true;
							position=tmp;
						}
						if((tmp.element).getIDLogger()< chiffreAcomparer && nbsuperieur<1){
							nbsuperieur++;
							insereAvant=false;
							position=tmp;
					}
					if(type==1){
							if((tmp.element).getAir()>(double) chiffreAcomparer) {
								insereAvant=true;
								position=tmp;
							}
							if((tmp.element).getAir()<(double) chiffreAcomparer && nbsuperieur<1){
								nbsuperieur++;
								insereAvant=false;
								position=tmp;
							}
						}
						
					}
				
					
					tmp = tmp.suivant;
				}	
			return	insereAvant;
		 
	 }

    public void supprimeListe() throws ListeVideException {

        for(int i =0;i<10;i++)
        supprime();



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
		
		
		//Unit� de test3
		public void afficheAireDeLaLIste() throws ListeVideException{
				premier();
				int i=0;
				//R�f�rence temporaire pour parourir la liste du debut a la fin
				Noeud tmp = debut;
				
					while(tmp != null){
					
						//aFFICHE
					System.out.println((tmp.element).getAir() + "indice : "+i);
								
					//On passe � l'�l�ment suivant dans la pile
					tmp = tmp.suivant;	
					i++;

				}
		}

		
	
	
}