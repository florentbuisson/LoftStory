import java.util.ArrayList;
import java.io.*;

import java.util.List;

public class Loft {

	/**
	 * @param args
	 */
	protected int taille;
	protected int jour;
	protected Case[][] plateau;
	protected List<Neuneu> participants;
	protected List<Neuneu> morts;
	protected List<Neuneu> nes;
	protected Integer nombreNeuneuTotal;
	
	public Case getCase(int w, int h){
		return plateau[w][h];
	}
	
	public void remplissageAleatoire(float ratio){
		
	}
	public void regarderLeLoft(){
		
	}
	public void add(Neuneu neuneu){
		participants.add(neuneu);
	}
	protected void selectionNaturelle(){
		Neuneu plusFaible = participants.get(0);
		for (Neuneu neuneu:participants){
			if (neuneu.getEnergie() < plusFaible.getEnergie())
				plusFaible = neuneu;
		}
		System.out.println("A la fin du jour n°"+jour+", "+plusfaible.getNom()+" a été déclaré le Neuneu le plus faible du Loft.");
		System.out.println("Pour cette raison, "+plusFaible.getNom()+" est invité à quitter le Loft.");
		participants.remove(plusFaible);
	}
	
	public String donnerNumeroPourNomNeuneu(){
		++nombreNeuneuTotal;
		return nombreNeuneuTotal.toString();
	}
	
}
