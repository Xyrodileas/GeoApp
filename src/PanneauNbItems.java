/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: PanneauNbItems.java
Date créé: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/ 

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;



public class PanneauNbItems extends JPanel implements Observer{
	
    /**
     * STRAT�GIE :  On utilise  le principe Observer/Observable
     * 				On est aviser de l'incr�mentation du nombre de Formes par CommBase
     * 
     * 				Dans ce cas:
     *				CommBase est Observable
     *				PanneauNbItems est l'Observer
     *
     *			    Cela va permettre de modifier le nombre d'�lements selon le nombre de formes recu
     *				 
     *              On recoit par notification le nombre de Formes total
     *                
     */
    //Sert pour la persistence (enl�ve un warning)
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTS
	//L'�tiquette et le nombre
	private JLabel etiqNbElements;
	private  JLabel nbElements;
	

	/**
	 * Constructeur par d�faut
	 */
	public PanneauNbItems(){
		
		//Utilisation d'une proc�dure locale
		initComposants();			
	}
	
	/**
	 * Cr�e les deux �tiquettes et d�finit la taille du panneau
	 * avant d'y ajouter les composants
	 * Cons�quent :
	 * 			On instancie un objet etiqNbElements Jlabel (Titre)
	 * 			On instancie un objet nbElements JLabel 	(NombreDeFormes)
	 */
	private void initComposants(){

		etiqNbElements = new JLabel("Nombre de Formes");
		nbElements = new JLabel("0");
		
		setPreferredSize(new Dimension(120,30));
		
		add(etiqNbElements);
		add(nbElements);
	}
	
	/**
	 * Modifie l'�tiquette repr�sentant le nombre de Formes.
	 * @param nb Le nombre � afficher
	 * 
	 *  Cons�quent :
	 * 			nbElement se voit attribuer la valeur recue
	 */
	 
	public void setNbElements(int nb){
		nbElements.setText(String.valueOf(nb));			
	}

	/**
	 * Proc�dure Update
	 * va permettre de recevoir la notification du 
	 * CommBase avisant d'une modification
	 * puis  Modifie l'�tiquette repr�sentant le nombre d'�l�ment pr�sent.
	 * 
	 * @param "Observable" (Par qui la notification a �t� envoy�)
	 * @param arg (le nombre de formes)
	 * 
	 * Cons�quent :
	 * 			Modication du label nombre de formes
	 */
	public void update(Observable o, Object arg) {
		
		setNbElements(Integer.parseInt((String)arg));
		
	}
	
}

