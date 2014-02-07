package LaFabrique;

import Formes.*;
import ca.etsmtl.log.util.IDLogger;
/**
 * Cette classe permet de générer les formes (Rectangle, Carré, Cercle, Ligne, Ovale)
 * Created by Alexis on 18/01/14.
 * @author Alexis Vuillaume
 */


public class FabriqueForme {

    public FabriqueForme(){

    }

    /**
     * Permet de créer des formes, en fonction du texte fournit en entré
     * @param forme Chaîne de caractère représentant la forme
     *
     * @return Retourne la forme décrite par la chaîne de caractère
     */
    public static Forme creerForme(String forme){
        String shape[] = FormeParser.parse(forme); //On envoi la chaîne de caractère décrivant la forme au parseur qui nous retourne un tableau
        IDLogger logger = IDLogger.getInstance();
        logger.logID(Integer.parseInt(shape[0])); // On envoi l'ID au logger
        System.out.println("ID :"+shape[0]);
        if(!(shape == null)){ // On appel le constructeur adéquate en fonction de la forme décrite
            if(shape[1].equalsIgnoreCase("<RECTANGLE>"))
                    return new Rectangle(Integer.parseInt(shape[2]), Integer.parseInt(shape[3]), Integer.parseInt(shape[4]), Integer.parseInt(shape[5]));
            else if(shape[1].equalsIgnoreCase("<CARRE>"))
                    return new Carre(Integer.parseInt(shape[2]), Integer.parseInt(shape[3]), Integer.parseInt(shape[4]), Integer.parseInt(shape[5]));
            else if(shape[1].equalsIgnoreCase("<LIGNE>"))
                    return new Ligne(Integer.parseInt(shape[2]), Integer.parseInt(shape[3]), Integer.parseInt(shape[4]), Integer.parseInt(shape[5]));
            else if(shape[1].equalsIgnoreCase("<OVALE>"))
                    return new Ovale(Integer.parseInt(shape[2]), Integer.parseInt(shape[3]), Integer.parseInt(shape[4]), Integer.parseInt(shape[5]));
            else if(shape[1].equalsIgnoreCase("<CERCLE>"))
                    return new Cercle(Integer.parseInt(shape[2]), Integer.parseInt(shape[3]), Integer.parseInt(shape[4]));
        }
        else
            System.err.println("Aucun paramètre reçu"); // Si on ne détecte pas le nom de la forme, on affiche une erreur
        return null;
    }

}
