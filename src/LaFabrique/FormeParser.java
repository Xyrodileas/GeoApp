package LaFabrique; /**
 * Created by Alexis on 18/01/14.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe servant à parser une chaîne de caractère décrivant une forme
 * @author Alexis
 */
public class FormeParser {



    public static String[]  parse(String str){

        if(str.contentEquals("commande>")){ //Si ce n'est pas une forme, on retourne null
            return null;
        }
        String type = "";

        try{
            Pattern p = Pattern.compile("(?:<)[A-Z]*(?:>)"); //Regex reconnaissant une chaîne de caractère entre "<" et ">"
            Matcher m = p.matcher(str);
            System.out.println(m.find());
            type = m.group(0);
            System.out.println("Forme : "+ type);

            p = Pattern.compile("[0-9]{1,5}(?= )"); //Regex reconnaissant une suite de 1 à 5 chiffre (ID et paramètres de la forme)
            m = p.matcher(str);
            m.find();
            String id = m.group(0); // Premier paramètre (ID)
            m.find();
            String parm1 = m.group(0); // Deuxième paramètre
            m.find();
            String parm2 = m.group(0); // Troisième paramètre
            m.find();
            String parm3 = m.group(0); // Quatrième paramètre
            String result[];
            if(!type.contentEquals("<CERCLE>")){ //Si ce n'est pas un cercle, c'est qu'il y a un 5ème paramètre
                m.find();
                String parm4 = m.group(0);
                result = new String[]{id, type, parm1, parm2, parm3, parm4};
            }
            else{ // Sinon
                result = new String[]{id, type, parm1, parm2, parm3};
            }
            return result;
        }catch(IllegalStateException e){
            System.err.println("Erreur, impossible de trouver tous les paramètres");
        }

        return null;

    }

}
