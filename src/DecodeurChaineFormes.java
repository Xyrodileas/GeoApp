/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: DecodeurDeChaine.java
Date crÃ©Ã©: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/ 


//import ca.etsmtl.log.util.IDLogger;
import java.util.regex.*;
import ca.etsmtl.log.util.IDLogger;

public class DecodeurChaineFormes<Regex> {
		private static Pattern format;
		private static Formes formeAenvoyer ;
		private static IDLogger logger = IDLogger.getInstance();	//Methode Statique
    /**
     * Crée une nouvelle forme. Cette méthode reçoit la chaîne de
     * caractères provenant du serveur de formes, elle détermine de quelle
     * forme il s'agit et applique l'opérateur new sur le constructeur de
     * la forme désirée.
     *
     * @param chaineForme un objet String contenant la chaîne de caractères
     *                    qui décrit une forme et provenant du serveur de
     *                    formes.
     *
     * @return une instance d'une des sous-classes de la classe abstraite
     *         Forme avec les paramètres passés par la chaîne d'entrée.
     *         
     * Consequent: 
     * 			creation de la forme approprier
     */
    public static Formes creerForme(String chaineFormeDuServeur) {
    		
    		format = Pattern.compile(" ");
    		
    		// séparation en sous-chaînes par " " dans un tableau
    		String[] tab_items = format.split(chaineFormeDuServeur);
    		
    		
    		//COMPARAISON SELON LA TAille de l'élément tab[1] du split
    		switch(tab_items[1].length())
    		
    		{
    		
    		// CAS <OVALE> ou  <LIGNE> ou <CARRE>
    		case 7 :
    			 
    			//CAS LIGNE creer une forme LIGNE si la requete recus contient la chaine <LIGNE>
    			if(tab_items[1].equals("<LIGNE>")){
    				formeAenvoyer= new Formes.Ligne(Integer.parseInt(tab_items[0]),Integer.parseInt(tab_items[2]) ,Integer.parseInt(tab_items[3]) , Integer.parseInt(tab_items[4]), Integer.parseInt(tab_items[5]));
    			}
    			
    			
    			else if(tab_items[1].equals("<CARRE>")){
        			formeAenvoyer= new Formes.Carre(Integer.parseInt(tab_items[0]),Integer.parseInt(tab_items[2]) ,Integer.parseInt(tab_items[3]) , Integer.parseInt(tab_items[4]), Integer.parseInt(tab_items[5]));

    				
    			}
    			
    			//CAS OVALE creer une forme OVALE si la requete recus contient la chaine <OVALE>
    			else if(tab_items[1].equals("<OVALE>")){
    				//System.out.println("C'est un <OVALE>" + "\n");
    				formeAenvoyer= new Formes.Ovale(Integer.parseInt(tab_items[0]),Integer.parseInt(tab_items[2]) ,Integer.parseInt(tab_items[3]) , Integer.parseInt(tab_items[4]), Integer.parseInt(tab_items[5]));
    			}
    			
    			break;
    		
    		//CAS CERCLE creer une forme CERCLE si la requete recus contient la chaine <CERCLE>
    		case 8:
    			// <CERCLE>
    			formeAenvoyer= new Formes.Cercle(Integer.parseInt(tab_items[0]),Integer.parseInt(tab_items[2]) ,Integer.parseInt(tab_items[3]) , Integer.parseInt(tab_items[4]));
    			break;
    			
    		//CAS RECTANGLE creer une forme rectangle si la requete recus contient la chaine <RECTANGLE>
    		case 11:
    			formeAenvoyer= new Formes.Rectangle(Integer.parseInt(tab_items[0]),Integer.parseInt(tab_items[2]) ,Integer.parseInt(tab_items[3]) , Integer.parseInt(tab_items[4]), Integer.parseInt(tab_items[5]));
    			break;

    		}
    	logger.logID(Integer.parseInt(tab_items[0])); //le id étant un int représentant le numéro de séquence reçu
		return formeAenvoyer; //retourne la forme spécifique
        

    }

}
 

