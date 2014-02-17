import Formes.Formes;

/**
 * Classe pour les diff�rents tris
 * @author i7
 *
 */
public abstract class Triage {

   
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre croissant
    public static void triBulleIDLoggerCroissant(ListePerso lt) throws ListeVideException, Exception{
        boolean trie = true;
        do{
            lt.premier(); // On part du début de la liste
            trie=true;
            for(int i=0;i<9;i++){ // On parcours chaque élément de la liste

                Formes tmp = lt.getElement(); //On enregistre la forme précédente
                lt.suivant();
                if(tmp.getIDLogger() > lt.getElement().getIDLogger()){ // Si l'ID de la forme précédente est supérieur à l'actuel
                    lt.precedent();                                    // On les permutes
                    lt.supprime();
                    lt.ajoute(tmp, 1);
                    lt.suivant();
                    trie=false; // On indique qu'il y a eu une permutation (= liste non trié)
                }
            }

        }while(!trie); // Tant que la liste n'est pas triée, on continue
    }
    // Trie à bulle en fonction de l'IDLogger, dans l'ordre decroissant
    public static void triBulleIDLoggerDecroissant(ListePerso lt) throws ListeVideException, Exception{
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
    public static void triBulleAireCroissant(ListePerso lt) throws ListeVideException, Exception{
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
    public static void triBulleAireDecroissant(ListePerso lt) throws ListeVideException, Exception{
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
    //LES POINTS BONIS
    public static void triLargeurCroissante(ListePerso lt) throws ListeVideException{
    	 boolean trie = true;
         do{
             lt.premier();
             trie=true;
             for(int i=0;i<10;i++){

                 Formes tmp = lt.getElement();
                 lt.suivant();
                 /**if(tmp.getLargeur() > lt.getElement().getLargeur()()){
                     lt.precedent();
                     lt.supprime();
                     lt.ajoute(tmp, 1);
                     lt.suivant();
                     trie=false;
                 }**/
             }

         }while(!trie);
    	
    }
    public static void triLargeurDcroissante(ListePerso lt) throws Exception{
    	for(int i=0;i<10;i++){
         	lt.premier();
         	for(int j=10;j>i;j--){
         		 Formes tmp = lt.getElement();
                  lt.suivant();
                 /** if(tmp.getLargeur() < lt.getElement().getLargeur()){
                  	lt.precedent();
                  	lt.supprime();
                  	lt.ajoute(tmp, 1);
                  }**/
            
             }
    	}
    	
    }
                                   
    public static void triParhauteurCroissante(ListePerso lt) throws ListeVideException{ 
    	boolean trie = true;
    do{
        lt.premier();
        trie=true;
        for(int i=0;i<10;i++){

            Formes tmp = lt.getElement();
            lt.suivant();
            /**if(tmp.getHauteur() > lt.getElement().getHauteur()){
                lt.precedent();
                lt.supprime();
                lt.ajoute(tmp, 1);
                lt.suivant();
                trie=false;
            }**/
        }

    }while(!trie);
    	
    }
    public static void triParHauteurDecroissante(ListePerso lt) throws Exception{
    	for(int i=0;i<10;i++){
         	lt.premier();
         	for(int j=10;j>i;j--){
         		 Formes tmp = lt.getElement();
                  lt.suivant();
                 /** if(tmp.getHauteur()< lt.getElement().getHauteur()){
                  	lt.precedent();
                  	lt.supprime();
                  	lt.ajoute(tmp, 1);
                  }**/
            
             }
    	}
    	
    }
    public static void triParOrdreOriginal(ListePerso lt){
    	
    }

    
    public static void reorganize(ListePerso lt) throws Exception{
        lt.premier();
        ((Formes)lt.getElement()).newPosition(1,1);
        for(int i=0;i<10;i++){
            Formes tmp = (Formes) lt.getElement();
            lt.suivant();
            ((Formes)lt.getElement()).newPosition(tmp.firstx()+40, tmp.firsty()+40);
        }
    }
    


}
