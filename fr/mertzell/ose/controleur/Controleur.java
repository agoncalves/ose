package fr.mertzell.ose.controleur;

import java.awt.event.* ;
import fr.mertzell.ose.modele.Orientation;
import fr.mertzell.ose.modele.PlanSalle;
import fr.mertzell.ose.modele.Position;
import fr.mertzell.ose.vue.FenetrePrincipale;
import fr.mertzell.ose.vue.Parametres;

public class Controleur implements MouseListener, ActionListener {

	private FenetrePrincipale vue ;
	private PlanSalle modele ;
	private Position position ;
	
	public Controleur(FenetrePrincipale vue,PlanSalle modele) {
		this.vue = vue ;
		this.modele = modele ;
		vue.getItemOuvrir().addActionListener(this) ;
		vue.getItemEnregistrer().addActionListener(this) ;
		vue.getItemQuitter().addActionListener(this) ;
		vue.getItemPlacerNord().addActionListener(this) ;
		vue.getItemPlacerEst().addActionListener(this) ;
		vue.getItemPlacerSud().addActionListener(this) ;
		vue.getItemPlacerOuest().addActionListener(this) ;
		vue.getItemModifierNord().addActionListener(this) ;
		vue.getItemModifierEst().addActionListener(this) ;
		vue.getItemModifierSud().addActionListener(this) ;
		vue.getItemModifierOuest().addActionListener(this) ;
		vue.getItemRetirer().addActionListener(this) ;
		vue.getLePlan().addMouseListener(this) ;
	}
	
	public void actionPerformed(ActionEvent evt){
		Object source = evt.getSource() ;
		if(source == vue.getItemOuvrir()){
			System.out.println("Ouvrir") ;
		}
		else if(source == vue.getItemEnregistrer()){
			System.out.println("Enregistrer") ;
		}
		else if(source == vue.getItemQuitter()){
			System.out.println("Quitter") ;
			System.exit(0) ;
		}
		else if(source == vue.getItemPlacerNord()){
			modele.ajouterPoste(this.position,Orientation.NORD) ;
		}
		else if(source == vue.getItemPlacerEst()){
			modele.ajouterPoste(this.position,Orientation.EST) ;
		}
		else if(source == vue.getItemPlacerSud()){
			modele.ajouterPoste(this.position,Orientation.SUD) ;
		}
		else if(source == vue.getItemPlacerOuest()){
			modele.ajouterPoste(this.position,Orientation.OUEST) ;
		}
		else if(source == vue.getItemRetirer()){
			modele.retirerPoste(this.position) ;
		}
		else if(source == vue.getItemModifierNord()){
			modele.modifierPoste(this.position,Orientation.NORD) ;
		}
		else if(source == vue.getItemModifierEst()){
			modele.modifierPoste(this.position,Orientation.EST) ;
		}
		else if(source == vue.getItemModifierSud()){
			modele.modifierPoste(this.position,Orientation.SUD) ;
		}
		else if(source == vue.getItemModifierOuest()){
			modele.modifierPoste(this.position,Orientation.OUEST) ;
		}
		vue.visualiserPlan() ;
	}
	
	public void mouseClicked(MouseEvent evt){
	}
	
	public void mousePressed(MouseEvent evt){
		Object source = evt.getSource() ;
		if(source == vue.getLePlan()){
			if(evt.isPopupTrigger()){
				int rangee = evt.getY() / Parametres.HAUTEUR_RANGEE ;
				int travee = evt.getX() / Parametres.LARGEUR_TRAVEE ;
				this.position = new Position(rangee,travee) ;
				vue.afficherMenuContextuel(evt.getX(),evt.getY()) ;
			}
		}
	}
	
	public void mouseReleased(MouseEvent evt){
	}
	
	public void mouseEntered(MouseEvent evt){
	}
	
	public void mouseExited(MouseEvent evt){
	}
}