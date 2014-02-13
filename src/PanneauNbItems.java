/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: PanneauNbItems.java
Date crÃ©Ã©: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/ 

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class PanneauNbItems extends JPanel implements Observer{
	
    /**
     * STRATÉGIE :  On utilise  le principe Observer/Observable
     * 				On est aviser de l'incrémentation du nombre de Formes par CommBase
     * 
     * 				Dans ce cas:
     *				CommBase est Observable
     *				PanneauNbItems est l'Observer
     *
     *			    Cela va permettre de modifier le nombre d'élements selon le nombre de formes recu
     *				 
     *              On recoit par notification le nombre de Formes total
     *                
     */
    //Sert pour la persistence (enlève un warning)
	private static final long serialVersionUID = 1L;
	
	//ATTRIBUTS
	//L'étiquette et le nombre
	private JLabel etiqNbElements;
	private  JLabel nbElements;
	

	/**
	 * Constructeur par défaut
	 */
	public PanneauNbItems(){
		
		//Utilisation d'une procédure locale
		initComposants();			
	}
	
	/**
	 * Crée les deux étiquettes et définit la taille du panneau
	 * avant d'y ajouter les composants
	 * Conséquent :
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
	 * Modifie l'étiquette représentant le nombre de Formes.
	 * @param nb Le nombre à afficher
	 * 
	 *  Conséquent :
	 * 			nbElement se voit attribuer la valeur recue
	 */
	 
	public void setNbElements(int nb){
		nbElements.setText(String.valueOf(nb));			
	}

	/**
	 * Procédure Update
	 * va permettre de recevoir la notification du 
	 * CommBase avisant d'une modification
	 * puis  Modifie l'étiquette représentant le nombre d'élément présent.
	 * 
	 * @param Observable (Par qui la notification a été envoyé)
	 * @param arg (le nombre de formes)
	 * 
	 * Conséquent :
	 * 			Modication du label nombre de formes
	 */
	public void update(Observable o, Object arg) {
		
		setNbElements((int) arg);
		
	}
	
}

