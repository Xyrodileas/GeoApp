/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: MenuFenetre.java
Date créé: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/ 

/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: MenuFenetre.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Crée le menu de la fenêtre de l'applicationé
 */
public class MenuFenetre extends JMenuBar{
	
	private static final long serialVersionUID = 1536336192561843187L;
	private static final int  MENU_DESSIN_ARRETER_TOUCHE_MASK  = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC  = KeyEvent.VK_A;
	private static final int  MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int  MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final String
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
			MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about"; 
	
	
	private JMenuItem arreterMenuItem, demarrerMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200;
	private static FenetrePrincipale fenetrePrincipale;
 	   
	CommBase comm; // Pour activer/désactiver la communication avec le serveur
	
	/**
	 * Constructeur : MenuFenetre
	 * permet d'initaliser le menu
	 * @param (CommBase)comm
	 */
	public MenuFenetre(CommBase commRecu) {
		comm = commRecu;
		addMenuDessiner();
		addMenuRechercheFormes();
		addMenuClasser();
		addMenuFichier();
		addMenuAide();
	}

	/**
	 *  Cree le menu "Draw". 
	 */
	protected void addMenuDessiner() {
		JMenu menu = creerMenu(MENU_DESSIN_TITRE,new String[] { MENU_DESSIN_DEMARRER, MENU_DESSIN_ARRETER });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent arg0) {
			try {
				//FENETRE
				JTextField adresse_ip = new JTextField();
				JTextField num_port = new JTextField();
				
				
				int validation = JOptionPane.showConfirmDialog(fenetrePrincipale, 
					      new Object[] {"L'hote de connexion :", adresse_ip, "Numero de port :", num_port},
					      "Hote de connexion distant",
					      JOptionPane.OK_CANCEL_OPTION); 
				
				
							    
			    try{
			    	if (validation == JOptionPane.OK_OPTION){
			    		comm.recupereJFrame(fenetrePrincipale);
			    		comm.start(adresse_ip.getText(),Integer.parseInt(num_port.getText()));	
			    	}
			    	
			    }
			    catch(NumberFormatException e){
			    	int i=0;
			    	if(i==0){
			    		comm.start("127.0.0.1",10000);
			    	}
			    	else{
			    	JOptionPane.showMessageDialog(fenetrePrincipale, 
							"Format incorrect", 
							"Fin",
							JOptionPane.INFORMATION_MESSAGE);
			    	}
				}
			    	
			    }
			    	 
			catch (IOException e) {
				e.printStackTrace();
			}
			rafraichirMenus();
		  }
		});
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			try {
				fenetrePrincipale.videListeEtRedemarre();
			} catch (ListeVideException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comm.stop();
			rafraichirMenus();
		    }
	    });
		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_ARRETER_TOUCHE_RACC,
				MENU_DESSIN_ARRETER_TOUCHE_MASK));
		add(menu);
	}
	
	
//************************************************************************************

	/** 
	 * Créer le menu "File". 
	 */
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_QUITTER });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comm.stop();
			    try {
						Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	
	//*********************************************************************************************
	/**
	 *  Créer le menu "Help". 
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS), 
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}
	
	
<<<<<<< HEAD
	//  *******************************************************************************************
		
		/**
		 * Methode : addMenuRechercheFormes()
		 * Permet de creer le menu Recuperer 10 formes
		 */
=======
	//*******************************************************************************************
		
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
		private void addMenuRechercheFormes(){
			
			JMenu demandeFormeMenuItems = new JMenu("Relancer 10 Formes ");
			JMenuItem item = new JMenuItem("10 nouvelles formes");
<<<<<<< HEAD
			
			//Ecouteur du menu 10 nouvelles formes
			item .addActionListener(new ActionListener(){
				/**
				 * ActionListener :
				 * 					-Va vider la liste
				 * 					-Relancer la communication avec le serveur
				 */
=======
			item .addActionListener(new ActionListener(){
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
				public void actionPerformed(ActionEvent arg0) {
					
					comm.setNbElementZero();
					try {
						fenetrePrincipale.videListeEtRedemarre();
						
					} catch (ListeVideException e) {
<<<<<<< HEAD
					
=======
						// TODO Auto-generated catch block
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
						fenetrePrincipale.nouvelleListe();
					}
					repaint();
					comm.creerCommunication();
				

			    }
		    });
			
			demandeFormeMenuItems.add(item);
			add(demandeFormeMenuItems);
		}
		
		

	
	
	
<<<<<<< HEAD
//  ***************************************************************************************************************
	/**
	* Methode : addMenuClasser()
	* Permet d'initaliser le menu classer ( triage )
	 */
=======
	//***************************************************************************************************************
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	private void addMenuClasser() {
		   		
		//Menu Classer_Formes
				//Onglet principale
		   		JMenu menuClasser = new JMenu("Classer_Formes");
		   		
		   		//Cr�ation du groupe de boutons qui va englober tous les tis
		   		ButtonGroup groupeboutton = new ButtonGroup();
		   		
		   		//Cr�ation de l'ecouteur des boutons
		   		EcouteurClasser ecouteur= new EcouteurClasser();
		   		
		   	   // Creation des sous menus
			   
			   /**
			    * Les boutons du menu de tri
			    */
		   	   JRadioButtonMenuItem sequenceCroissant = new JRadioButtonMenuItem("Sequence_Croissant");//num�ro de s�quence croissant
			   JRadioButtonMenuItem sequenceDecroissant = new JRadioButtonMenuItem("Sequence_Decroissant");//num�ro de s�quence d�croissant
			   JRadioButtonMenuItem aireFormeCroissante = new JRadioButtonMenuItem("Aire_Forme_Croissante");//Aire croissante
			   JRadioButtonMenuItem aireFormeDecroissante = new JRadioButtonMenuItem("Aire_Forme_Decroissante");//Aire d�croissante
			   JRadioButtonMenuItem parTypeDeFormes = new JRadioButtonMenuItem("Par_type_De_formes");//carr�, rectangle, cercle, ovale, ligne
			   JRadioButtonMenuItem parTypeDeFormesInverse = new JRadioButtonMenuItem("Par_type_De_formes_inverse");//ligne, ovale, cercle, rectangle, carr�**/
			   JRadioButtonMenuItem parDistanceMax2points = new JRadioButtonMenuItem("parDistanceMax2points");//ligne, ovale, cercle, rectangle, carr�**/
			   JRadioButtonMenuItem triLargeurCroissante = new JRadioButtonMenuItem("triLargeurCroissante");//triLargeurCroissante
			   JRadioButtonMenuItem triLargeurDecroissante = new JRadioButtonMenuItem("triLargeurDecroissante");//triLargeurDecroissante
			   JRadioButtonMenuItem triParhauteurCroissante = new JRadioButtonMenuItem("triParhauteurCroissante");//triParhauteurCroissante
			   JRadioButtonMenuItem triParHauteurDecroissante = new JRadioButtonMenuItem("triParHauteurDecroissante");//triParHauteurDecroissante
			   JRadioButtonMenuItem triParOrdreOriginal = new JRadioButtonMenuItem("triParOrdreOriginal");//triParOrdreOriginal
			   
			   //Ajout de l �couteur aux boutons
			   sequenceCroissant.addActionListener(ecouteur);
			   sequenceDecroissant.addActionListener(ecouteur);
			   aireFormeCroissante.addActionListener(ecouteur);
			   aireFormeDecroissante.addActionListener(ecouteur);
			   parTypeDeFormes.addActionListener(ecouteur);
			   parTypeDeFormesInverse.addActionListener(ecouteur);
			   parDistanceMax2points.addActionListener(ecouteur);
			   triLargeurCroissante.addActionListener(ecouteur);
			   triLargeurDecroissante.addActionListener(ecouteur);
			   triParhauteurCroissante.addActionListener(ecouteur);
			   triParHauteurDecroissante.addActionListener(ecouteur);
			   triParOrdreOriginal.addActionListener(ecouteur);
			   
			   //Ajout des boutons au groupe
			   groupeboutton.add(sequenceCroissant);
			   groupeboutton.add(sequenceDecroissant);
			   groupeboutton.add(aireFormeCroissante);
			   groupeboutton.add(aireFormeDecroissante);
			   groupeboutton.add(parTypeDeFormes);
			   groupeboutton.add(parTypeDeFormesInverse);
			   groupeboutton.add(parDistanceMax2points);
			   groupeboutton.add(triLargeurCroissante);
			   groupeboutton.add(triLargeurDecroissante);
			   groupeboutton.add(triParhauteurCroissante);
			   groupeboutton.add(triParHauteurDecroissante);
			   groupeboutton.add(triParOrdreOriginal);
		
			   //Ajout des boutons au super menu
			   menuClasser.add(sequenceCroissant);
			   menuClasser.add(sequenceDecroissant);
			   menuClasser.add(aireFormeCroissante);
			   menuClasser.add(aireFormeDecroissante);
			   menuClasser.add(parTypeDeFormes);
			   menuClasser.add(parTypeDeFormesInverse);
			   menuClasser.add(parDistanceMax2points);
			   menuClasser.add(triLargeurCroissante);
			   menuClasser.add(triLargeurDecroissante);
			   menuClasser.add(triParhauteurCroissante);
			   menuClasser.add(triParHauteurDecroissante);
			   menuClasser.add(triParOrdreOriginal);
			   
			   menuClasser.addSeparator();
			   
			   //Ajout du menuClasser Globale
			   add(menuClasser);
		   
	}
	
	
/**
 * Classe : Ecouteur de tri	
<<<<<<< HEAD
 *Permet d'impl�menter l'interface
 * ActionListener selon les boutons activ�s
 * du menu de tri
=======
 *Permet d'impl�menter l'interface ActionListener selon
 *les boutons activ�s
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
 */
public class EcouteurClasser  implements ActionListener{
		
	
		public EcouteurClasser(){ }

		
	/**
<<<<<<< HEAD
	 * ActionListener :
	 * Evenement qui se produira selon le bouton pr�ss�
	 * 			-Permet de Trier selon le bouton
=======
	 * Evenement qui se produira selon le bouton pr�ss�
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	 */
	 public void actionPerformed(ActionEvent e) {
		 
		 /*
		  * (sequenceCroissant = 0)			(sequenceDecroissant = 1)
		  * (aireFormeCroissante = 2)		(aireFormeDecroissante = 3)
		  * (parTypeDeFormes = 4)			(parTypeDeFormesInverse = 5)
		  * (triParDistanceMax2points = 6)	(triLargeurCroissante = 7)
		  * (triLargeuDeroissante = 8)		(triParhauteurCroissante = 9)
		  * (triParhauteurCroissante = 10)	(triParOrdreOriginal = 11)
		  */
		try{
		   if(e.getActionCommand().equals("Sequence_Croissant")){
			   MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(0);
			  
		   }
		   		else
		   				if(e.getActionCommand().equals( "Sequence_Decroissant")){
		   				    MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(1);

		   				
		   				}
		   
		   				else 
		   					if(e.getActionCommand().equals( "Aire_Forme_Croissante")){
		   						MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(2);
		   					
		   					}
		   					else 
			   					if(e.getActionCommand().equals("Aire_Forme_Decroissante")){
			   					MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(3);
			   					
			   					}
		   					else 
		   						if(e.getActionCommand().equals("Par_type_De_formes")){
		   						MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(4);
		   						
				   		
		   						}
		   						else 
		   							if(e.getActionCommand().equals( "Par_type_De_formes_inverse")){
		   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(5);
		   							
					   		
		   							}
		   							else 
			   							if(e.getActionCommand().equals( "parDistanceMax2points")){
<<<<<<< HEAD
=======
			   							System.out.println("tri TypeDeFormesInverse appel de fenetrePrincipale.aiguilleurDeTraitement(6)");
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
			   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(6);
			   							
						   		
			   							}
			   							else 
				   							if(e.getActionCommand().equals( "triLargeurCroissante")){
<<<<<<< HEAD
=======
				   							System.out.println("tri TypeDeFormesInverse appel de fenetrePrincipale.aiguilleurDeTraitement(7)");
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
				   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(7);
				   							
							   		
				   							}
				   							else 
					   							if(e.getActionCommand().equals( "triLargeurDecroissante")){
<<<<<<< HEAD
=======
					   							System.out.println("tri TypeDeFormesInverse appel de fenetrePrincipale.aiguilleurDeTraitement(8)");
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
					   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(8);
					   							
								   		
					   							}
					   							else 
						   							if(e.getActionCommand().equals( "triParhauteurCroissante")){
<<<<<<< HEAD
=======
						   							System.out.println("tri TypeDeFormesInverse appel de fenetrePrincipale.aiguilleurDeTraitement(9)");
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
						   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(9);
						   							
									   		
						   							}
						   							else 
							   							if(e.getActionCommand().equals( "triParHauteurDecroissante")){
<<<<<<< HEAD
=======
							   							System.out.println("tri TypeDeFormesInverse appel de fenetrePrincipale.aiguilleurDeTraitement(10)");
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
							   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(10);
							   							
										   		
							   							}
							   							else 
								   							if(e.getActionCommand().equals( "triParOrdreOriginal")){
<<<<<<< HEAD
=======
								   							System.out.println("tri TypeDeFormesInverse appel de fenetrePrincipale.aiguilleurDeTraitement(11)");
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
								   							MenuFenetre.fenetrePrincipale.aiguilleurDeTraitement(11);
								   							
											   		
								   							}
				   
			   
		   rafraichirMenus();
		   
		   
		   
		   
        }catch(Exception e1){}
		   }
	}

<<<<<<< HEAD
//  ********************************************************************************************************************
=======
//********************************************************************************************************************
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e

	/**
	 *  Activer ou désactiver les items du menu selon la sélection. 
	 */
	private  void rafraichirMenus() {
		demarrerMenuItem.setEnabled(!comm.isActif());
		arreterMenuItem.setEnabled(comm.isActif());
	}
	
<<<<<<< HEAD
//  ********************************************************************************************************************
=======
	//********************************************************************************************************************
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	
	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey,String[] itemKeys) {
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
           menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
        }
        return menu;
   }
	
	/**
<<<<<<< HEAD
	 * Methode : setJFrame
	 * Permet de r�cup�rer la r�f�rence de la fenetre principale
=======
	 * Permet de r�cup�rer la r�f�rence de la fenetre principale
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	 * @param fenetre
	 */
	public void setJFrame(FenetrePrincipale fenetre){
		fenetrePrincipale=fenetre;
		
	}
	
	
}
