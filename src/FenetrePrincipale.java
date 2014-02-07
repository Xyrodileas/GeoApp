/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import Formes.*;
import LaFabrique.FabriqueForme;
import ca.etsmtl.log.util.IDLogger;

import javax.swing.*;

/**
 * Cette classe représente la fenêtre principale de x2'application
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	
	private static final long serialVersionUID = -1210804336046370508L;
    IDLogger logger;
	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm){


		MenuFenetre menu = new MenuFenetre(comm);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);
		FenetreFormes fenetreFormes = new FenetreFormes();
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            { // On créé un listener qui écoute l'événement "windowClosing"
                closeall();                                     // Si cet événement est appelé, on appel notre fonction qui ferme le programme correctement
                e.getWindow().dispose();
            }
        });
	}

    /**
     * La méthode s'occupe de fermer correctement le thread, en appelant la méthode stop()
     */
    public void closeall(){
        ((MenuFenetre)this.getContentPane().getComponent(0)).comm.stop();
        System.out.println("Closed");
    }
	// Appelé lorsque le sujet lance "firePropertyChanger"
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

        Forme forme = null;
		if(arg0.getPropertyName().equals("ENVOIE-TEST")){
			System.out.println((String) arg0.getNewValue());
            forme = FabriqueForme.creerForme((String) arg0.getNewValue());
		}
        if(arg0.getPropertyName().equals("Err")){
            closeall();
            ((MenuFenetre)this.getContentPane().getComponent(0)).rafraichirMenus();
            this.update(this.getGraphics());
            JOptionPane.showMessageDialog(null, arg0.getNewValue());
        }

        if(!(forme == null)){
            ((FenetreFormes)this.getContentPane().getComponent(1)).addForme(forme);
            this.update(this.getGraphics());
        }
	}
}
