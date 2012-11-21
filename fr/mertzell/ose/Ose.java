package fr.mertzell.ose;
import fr.mertzell.ose.controleur.Controleur;
import fr.mertzell.ose.modele.PlanSalle;
import fr.mertzell.ose.vue.FenetrePrincipale;

public class Ose {
	public static void main(String [] args){
		PlanSalle modele = new PlanSalle("Sans Nom") ;
		FenetrePrincipale vue = new FenetrePrincipale(modele) ;
		new Controleur(vue,modele) ;
	}
}
