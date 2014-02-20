import Formes.Formes;

/**
 * Classe : Triage
 *	Permet d'effectuer les differents
 *	triage 
 */
public abstract class Triage {

   
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre croissant
	/**
	 * 
	 * @param lt
	 * @throws ListeVideException
	 * @throws Exception
	 */
    public static void triBulleIDLoggerCroissant(ListePerso lt) throws Exception{
        boolean trie = true;
        do{
            lt.premier(); // On part du debut de la liste
            trie=true;
            for(int i=0;i<9;i++){ // On parcours chaque element de la liste

                Formes tmp = lt.getElement(); //On enregistre la forme precedente
                lt.suivant();
                if(tmp.getIDLogger() > lt.getElement().getIDLogger()){ // Si l'ID de la forme precedente est superieur à l'actuel
                    lt.precedent();                                    // On les permutes
                    lt.supprime();
                    lt.ajoute(tmp, 1);
                    lt.suivant();
                    trie=false; // On indique qu'il y a eu une permutation (= liste non trié)
                }
            }

        }while(!trie); // Tant que la liste n'est pas triee, on continue
    }
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre decroissant
    /**
     * 
     * @param lt
     * @throws ListeVideException
     * @throws Exception
     */
    public static void triBulleIDLoggerDecroissant(ListePerso lt) throws Exception{
            for(int i=0;i<10;i++){
            	lt.premier();
            	for(int j=10;j>i;j--){
            		 Formes tmp = lt.getElement();
                     lt.suivant();
                     if(tmp.getIDLogger() < lt.getElement().getIDLogger()){
                    	 //System.out.println("AVANT le suivant"+lt.getPosition());
                     	lt.precedent();
                     	lt.supprime();
                     	lt.ajoute(tmp, 1);
                     }
               
                }
            }    	
            
    }
    
    // Trie à bulle en fonction de l'air, dans l'ordre croissant
    /**
     * 
     * @param lt
     * @throws ListeVideException
     * @throws Exception
     */
    public static void triBulleAireCroissant(ListePerso lt) throws Exception{
        boolean trie = true;
        do{
            lt.premier();
            trie=true;
            for(int i=0;i<10;i++){

                Formes tmp = lt.getElement();
                lt.suivant();
                if(tmp.getAire() > lt.getElement().getAire()){
                    lt.precedent();
                    lt.supprime();
                    lt.ajoute(tmp, 1);
                    lt.suivant();
                    trie=false;
                }
            }

        }while(!trie);
    }
    
    
    // Trie à bulle en fonction de l'air, dans l'ordre decroissant
    /**
     * 
     * @param lt
     * @throws ListeVideException
     * @throws Exception
     */
    public static void triBulleAireDecroissant(ListePerso lt) throws Exception{
    	 for(int i=0;i<10;i++){
         	lt.premier();
         	for(int j=10;j>i;j--){
         		 Formes tmp = lt.getElement();
                  lt.suivant();
                  if(tmp.getAire() < lt.getElement().getAire()){
                  	lt.precedent();
                  	lt.supprime();
                  	lt.ajoute(tmp, 1);
                  }
            
             }
         }    	
    }
    
    
    //carr�, rectangle, cercle, ovale, ligne
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triParFormes(ListePerso lt) throws Exception{
    	 boolean trie = true;
         do{
             lt.premier();
             trie=true;
             for(int i=0;i<10;i++){

                 Formes tmp = lt.getElement();
                 lt.suivant();
                 if(tmp.getNumeroClassement1() > lt.getElement().getNumeroClassement1()){
                     lt.precedent();
                     lt.supprime();
                     lt.ajoute(tmp, 1);
                     lt.suivant();
                     trie=false;
                 }
             }

         }while(!trie);
     }
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triParFormesInverse(ListePerso lt) throws Exception{
    	for(int i=0;i<10;i++){
         	lt.premier();
         	for(int j=10;j>i;j--){
         		 Formes tmp = lt.getElement();
                  lt.suivant();
                  if(tmp.getNumeroClassement1() < lt.getElement().getNumeroClassement1()){
                  	lt.precedent();
                  	lt.supprime();
                  	lt.ajoute(tmp, 1);
                  }
            
             }
    	}
    	
    }
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triParDistanceMax2points(ListePerso lt) throws Exception{
    	 boolean trie = true;
         do{
             lt.premier();
             trie=true;
             for(int i=0;i<10;i++){

                 Formes tmp = lt.getElement();
                 lt.suivant();
                 if(tmp.getDistanceMax() > lt.getElement().getDistanceMax()){
                     lt.precedent();
                     lt.supprime();
                     lt.ajoute(tmp, 1);
                     lt.suivant();
                     trie=false;
                 }
             }

         }while(!trie);
    	
    }
    
   //*****************************************************************************
    //LES POINTS BONIS
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triLargeurCroissante(ListePerso lt) throws Exception {
    	 boolean trie = true;
         do{
             lt.premier();
             trie=true;
             for(int i=0;i<10;i++){

                 Formes tmp = lt.getElement();
                 lt.suivant();
                 if(tmp.getLargeur() > lt.getElement().getLargeur()){
                     lt.precedent();
                     lt.supprime();
                     lt.ajoute(tmp, 1);
                     lt.suivant();
                     trie=false;
                 }
             }

         }while(!trie);
    	
    }
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triLargeurDecroissante(ListePerso lt) throws Exception{
    	for(int i=0;i<10;i++){
         	lt.premier();
         	for(int j=10;j>i;j--){
         		 Formes tmp = lt.getElement();
                  lt.suivant();
                 if(tmp.getLargeur() < lt.getElement().getLargeur()){
                  	lt.precedent();
                  	lt.supprime();
                  	lt.ajoute(tmp, 1);
                  }
            
             }
    	}
    	
    }
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triParhauteurCroissante(ListePerso lt) throws Exception {
    	boolean trie = true;
    do{
        lt.premier();
        trie=true;
        for(int i=0;i<10;i++){

            Formes tmp = lt.getElement();
            lt.suivant();
            if(tmp.getHauteur() > lt.getElement().getHauteur()){
                lt.precedent();
                lt.supprime();
                lt.ajoute(tmp, 1);
                lt.suivant();
                trie=false;
            }
        }

    }while(!trie);
    	
    }
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triParHauteurDecroissante(ListePerso lt) throws Exception{
    	for(int i=0;i<10;i++){
         	lt.premier();
         	for(int j=10;j>i;j--){
         		 Formes tmp = lt.getElement();
                  lt.suivant();
                  if(tmp.getHauteur()< lt.getElement().getHauteur()){
                  	lt.precedent();
                  	lt.supprime();
                  	lt.ajoute(tmp, 1);
                  }
            
             }
    	}
    	
    }
    
    
    /**
     * 
     * @param lt
     * @throws Exception
     */
    public static void triParOrdreOriginal(ListePerso lt) throws Exception{
      	boolean trie = true;
        do{
            lt.premier();
            trie=true;
            for(int i=0;i<10;i++){

                Formes tmp = lt.getElement();
                lt.suivant();
                if(tmp.getOrdreArriveForme() > (lt.getElement()).getOrdreArriveForme()){
                    lt.precedent();
                    lt.supprime();
                    lt.ajoute(tmp, 1);
                    lt.suivant();
                    trie=false;
                }
            }

        }while(!trie);
        	
        }
    	
 
    /**
     * Methode reorganize(ListePerso liste)
     * Cette methode permet de modifier laffichage en ajout 40 pixel
     * @param liste ListePerso chainee
     * @throws Exception
     */
    public static void reorganize(ListePerso liste) throws Exception{
        liste.premier();
        Formes tmp;
        liste.getElement().newPosition(0, 0);
       // liste.suivant();
        for(int i=0;i<10;i++){
        	tmp = liste.getElement();
            liste.suivant();
            liste.getElement().newPosition(tmp.firstx() + 40, tmp.firsty() + 40);
        }
    }
    


}
