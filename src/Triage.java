import Formes.Formes;

/**
 * Classe : Triage
 *	Permet d'effectuer les differents
 *	triage 
 */
public abstract class Triage {

   
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre croissant
	/**
<<<<<<< HEAD
	 * Methode : triBulleIDLoggerCroissant()
	 * Permet de trier la listePErso
	 * selon l'id logger croissant
	 * @param lt ListePerso
	 * @throws ListeVideException
	 * @throws Exception
	 * 				ListeVideException()
	 */
    public static void triBulleIDLoggerCroissant(ListePerso lt) throws ListeVideException, Exception{
=======
	 * 
	 * @param lt
	 * @throws ListeVideException
	 * @throws Exception
	 */
    public static void triBulleIDLoggerCroissant(ListePerso lt) throws Exception{
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triBulleIDLoggerDecroissant()
     * permet de trier la listePerso selon
     * un ordre d�croissant de id logger
     * @param lt ListePerso
     * @throws ListeVideException
     * @throws Exception
     * 			ListeVideException()
     */
    public static void triBulleIDLoggerDecroissant(ListePerso lt) throws ListeVideException, Exception{
=======
     * 
     * @param lt
     * @throws ListeVideException
     * @throws Exception
     */
    public static void triBulleIDLoggerDecroissant(ListePerso lt) throws Exception{
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
            for(int i=0;i<10;i++){
            	lt.premier();
            	for(int j=10;j>i;j--){
            		 Formes tmp = lt.getElement();
                     lt.suivant();
                     if(tmp.getIDLogger() < lt.getElement().getIDLogger()){
<<<<<<< HEAD
=======
                    	 //System.out.println("AVANT le suivant"+lt.getPosition());
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
                     	lt.precedent();
                     	lt.supprime();
                     	lt.ajoute(tmp, 1);
                     }
               
                }
            }    	
            
    }
    
    // Trie à bulle en fonction de l'air, dans l'ordre croissant
    /**
<<<<<<< HEAD
     * Methode : triBulleAireCroissant()
     * Permet de trier la listePerso l'aire 
     * decroissant 
     * selon l'aire croissant
     * @param lt ListePerso
     * @throws ListeVideException
     * @throws Exception
     * 				ListeVideException()
     */
    public static void triBulleAireCroissant(ListePerso lt) throws ListeVideException, Exception{
=======
     * 
     * @param lt
     * @throws ListeVideException
     * @throws Exception
     */
    public static void triBulleAireCroissant(ListePerso lt) throws Exception{
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triBulleAireDecroissant()
     * @param lt ListePerso
     * permet de trier la liste Person selon
     * l'aire d�croissant
     * @throws ListeVideException
     * @throws Exception
     * 				ListeVideException()
     */
    public static void triBulleAireDecroissant(ListePerso lt) throws ListeVideException, Exception{
=======
     * 
     * @param lt
     * @throws ListeVideException
     * @throws Exception
     */
    public static void triBulleAireDecroissant(ListePerso lt) throws Exception{
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
    
    
<<<<<<< HEAD
    //carre, rectangle, cercle, ovale, ligne
    /**
     * Methode : triParFormes()
     * carre, rectangle, cercle, ovale, ligne
     * @param lt ListePerso
     * @throws Exception
     * 				ListeVideException()
=======
    //carr�, rectangle, cercle, ovale, ligne
    /**
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode :triParFormesInverse()
     * ligne ovale cercle rectangle carre
     * @param lt ListePerso
     * @throws Exception
     * 			ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triParDistanceMax2points()
     * permet de trier la liste selon 
     * la distance max entre deux points
     * @param lt
     * @throws Exception
     * 				ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triLargeurCroissante()
     * permet de trier la liste selon
     * leur largeur croissante
     * @param lt
     * @throws Exception
     * 				ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triLargeurDeroissante()
     * Permet de trier la liste selon
     * la largeur decroissante
     * @param lt ListePerso
     * @throws Exception
     * 		ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triParhauteurCroissante()
     * Permet de trier la liste selon 
     * leur hauteur croissante
     * @param lt ListePerso
     * @throws Exception
     * 				ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triParhauteurDeroissante()
     * Permet de trier la liste selon 
     * leur hauteur decroissante
     * @param lt ListePerso
     * @throws Exception
     * 				ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode : triParOrdreOriginal()
     * Permet de trier la liste selon 
     * l'ordre d'arrive d'origine
     * @param lt ListePerso
     * @throws Exception
     * 				ListeVideException()
=======
     * 
     * @param lt
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode: reorganize(ListePerso liste)
     * Cette methode permet de modifier laffichage en ajout 40 pixel
     * @param liste ListePerso chainee
     * @throws Exception
     * 		ListeVideException()
=======
     * Methode reorganize(ListePerso liste)
     * Cette methode permet de modifier laffichage en ajout 40 pixel
     * @param liste ListePerso chainee
     * @throws Exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     */
    public static void reorganize(ListePerso liste) throws Exception{
        liste.premier();
        Formes tmp;
<<<<<<< HEAD
        ((Formes)liste.getElement()).newPosition(0,0);
       // liste.suivant();
        for(int i=0;i<10;i++){
        	tmp = (Formes) liste.getElement();
            liste.suivant();
            ((Formes)liste.getElement()).newPosition(tmp.firstx(), tmp.firsty());
=======
        liste.getElement().newPosition(0, 0);
       // liste.suivant();
        for(int i=0;i<10;i++){
        	tmp = liste.getElement();
            liste.suivant();
            liste.getElement().newPosition(tmp.firstx() + 40, tmp.firsty() + 40);
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
        }
    }
    


}
