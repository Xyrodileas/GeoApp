import Formes.Formes;

/**
 * Classe pour les diff�rents tris
 * @author i7
 *
 */
public abstract class Triage {

    public static void SelfSort(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = false;
        Formes pivot;


        do{
            lt.premier();
            pivot = (Formes)lt.getElement();
            for(int i=0;i<10;i++){
                trie=true;
                lt.suivant();
                if(pivot.getIDLogger() <= ((Formes) lt.getElement()).getIDLogger()){
                    Formes tmp = (Formes)lt.getElement();
                    lt.supprime();
                    lt.insererDebut(tmp);
                    trie=false;
                }
            }

        }while(!trie);

    }
    
    /**
     * 
     * @param listeRecu
     * @throws Exception
     */
    public static void sequenceCroissant(ListePerso listeRecu) throws Exception{
		boolean avant;
	   
	    ListePerso tmp=new ListePerso();
	 
		for(int i=0;i<10;i++){
			
				if(i ==0){
					//ON AJOUTE SIMPLEMENT L ELEMENT CAR CEST LE PREMIER
					tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
				}
				else if(i !=0) {
					avant= tmp.ParcourirTriCroissant(listeRecu.retournerUnTableauDobjet()[i].getIDLogger(),0);
					//cas ou le choix d'insertion est AVANT = 0    APRES=1
					if(avant==true){
						//AJOUTE APRES
						tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 1);
				
					}
					else if (avant==false){
						//AJOUTE AVANT
						tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
					} 
				}
		}
		
		
		
		// copie de la nouvelle liste Dans la liste g�n�rale
		listeRecu = new ListePerso(tmp);
		//UNITE DE TEST
		System.out.println("\n"+"Voici a liste trier par ID croissant");
		listeRecu.afficheIdDeLaLIste();
			
}

  //***************************************************************************	
	
	/**
	 * 
	 * @param listeRecu
	 * @throws Exception
	 */
  	public static void sequenceDecroissant(ListePerso listeRecu) throws Exception{
  		boolean avant;
 
	    ListePerso tmp=new ListePerso();
	    
	    for(int i=0;i<10;i++){
			    if(i ==0){
			    	//ON AJOUTE SIMPLEMENT L ELEMENT CAR CEST LE PREMIER
		  			tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
		  		}
		  		else if(i !=0) {
		  			avant=tmp.ParcourirTriDecroissant(listeRecu.retournerUnTableauDobjet()[i].getIDLogger(),0);
		  			//cas ou le choix d'insertion est AVANT = 0    APRES=1
		  			if(avant==true){
		  				tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 1);
		  				
		  			}
		  			else if (avant==false){
		  				tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
		  				
		  			}	 
		  			
		  		}

	    }
  	
	 
		// copie de la nouvelle liste Dans la liste g�n�rale
		listeRecu = new ListePerso(tmp);
		
		 /// copie de la nouvelle liste Dans la liste g�n�rale
		System.out.println("\n"+"Voici a liste trier par ID decroissant");
		listeRecu.afficheIdDeLaLIste();
  	}
  		
  	
  //***************************************************************************		
  	
 	/**
 	 * 
 	 * @param listeRecu
 	 * @throws Exception
 	 */
  	 public static void AireFormeCroissante(ListePerso listeRecu) throws Exception{
 		boolean avant;
 		 
	    ListePerso tmp=new ListePerso();
	    
  		for(int i=0;i<10;i++){
	  		if(i ==0){
	  		//ON AJOUTE SIMPLEMENT L ELEMENT CAR CEST LE PREMIER
	  			tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
	  		}
	  		else if(i !=0) {
	  			//TEST DE L AIRE
	  			avant=tmp.ParcourirTriCroissant((int)listeRecu.retournerUnTableauDobjet()[i].getAir(),1);
	  			
	  			//cas ou le choix d'insertion est AVANT = 0    APRES=1
	  			if(avant==true){
	  				//AJOUTE APRES
	  				tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 1);
	  			
	  			}
	  			else if (avant==false){
	  				//AJOUTE AVANT
	  				tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
	  				
	  			}
	  				 
	  			
	  		}
  		}
  
  	
		// copie de la nouvelle liste Dans la liste g�n�rale
		listeRecu = new ListePerso(tmp);
		//UNITE DE TEST
		
  		System.out.println("\n"+"Voici a liste TRIER  par Aire Croissant");
		listeRecu.afficheAireDeLaLIste();
  		}
  		
  		
  
  	
  	
  //***************************************************************************
  	
  	/**
  	 * 
  	 * @param listeRecu
  	 * @throws Exception
  	 */
  	 public static void AireFormeDecroissante(ListePerso listeRecu) throws Exception{
  		boolean avant;
  		
  		ListePerso tmp=new ListePerso();
		  	for(int i=0;i<10;i++)
		  		if(i ==0){
		  		//ON AJOUTE SIMPLEMENT L ELEMENT CAR CEST LE PREMIER
		  			tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
		  		}
		  		else if(i !=0) {
		  			//TEST DE L AIRE
		  			avant=tmp.ParcourirTriDecroissant((int)listeRecu.retournerUnTableauDobjet()[i].getAir(),1);
		  			
		  			//cas ou le choix d'insertion est AVANT = 0    APRES=1
		  			if(avant==true){
		  				//AJOUTE APRES
		  				tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 1);
		  				
		  			}
		  			else if (avant==false){
		  				//AJOUTE AVANT
		  				tmp.ajoute(listeRecu.retournerUnTableauDobjet()[i], 0);
		  			}
		  				 
		  			
		  		}
		  	
		  
			// copie de la nouvelle liste Dans la liste g�n�rale
			listeRecu = new ListePerso(tmp);
			//UNITE DE TEST
	  		System.out.println("\n"+"Voici a liste TRIER  par Aire Decroissant");
			listeRecu.afficheAireDeLaLIste();
  	
  		}
  		


    
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre croissant
    public static void bubbleSortByIDLogger(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            trie=true;
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getIDLogger() > ((Formes) lt.getElement()).getIDLogger()){
                    lt.precedent();
                    lt.supprime();
                    lt.ajoute(tmp, 1);
                    lt.suivant();
                    trie=false;
                }
            }

        }while(!trie);
    }
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre decroissant
    public static void bubbleSortByIDLoggerInverted(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getIDLogger() < ((Formes) lt.getElement()).getIDLogger()){
                    lt.supprime();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    // Trie à bulle en fonction de l'air, dans l'ordre croissant
    public static void bubbleSortByAir(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getAir() > ((Formes) lt.getElement()).getAir()){
                    lt.supprime();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    // Trie à bulle en fonction de l'air, dans l'ordre decroissant
    public static void bubbleSortByAirInverted(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier();
            for(int i=0;i<9;i++){

                Formes tmp = (Formes) lt.getElement();
                lt.suivant();
                if(tmp.getAir() < ((Formes) lt.getElement()).getAir()){
                    lt.supprime();
                    lt.precedent();
                    lt.ajoute(tmp, 0);
                    trie=false;
                }
            }

        }while(!trie);
    }
    public static void reorganize(ListePerso lt) throws Exception{
        lt.premier();
        ((Formes)lt.getElement()).newPosition(1,1);
        for(int i=0;i<10;i++){
            Formes tmp = (Formes) lt.getElement();
            lt.suivant();
            ((Formes)lt.getElement()).newPosition(tmp.lastx(), tmp.lasty());
        }
    }


}
