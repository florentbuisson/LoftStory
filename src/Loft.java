import java.util.List;

public class Loft {

	/**
	 * @param args
	 */
	protected int taille;
	protected int jour = 0;
	protected Case[][] plateau;
	protected List<Neuneu> participants;
	protected List<Neuneu> morts;
	protected List<Neuneu> nes;
	protected Integer nombreNeuneuTotal;

	public Case getCase(int w, int h) {
		return plateau[w][h];
	}

	public void remplissageAleatoire(float ratio) {
		int nombreNonneuneu = (int) (taille*taille*ratio)
		for (int i = nombre)
	}

	public void regarderLeLoft() {

	}

	public void add(Neuneu neuneu) {
		participants.add(neuneu);
	}

	protected void selectionNaturelle() {
		Neuneu plusFaible = participants.get(0);
		for (Neuneu neuneu : participants) {
			if (neuneu.getEnergie() < plusFaible.getEnergie())
				plusFaible = neuneu;
		}
		System.out.println("A la fin du jour n°" + jour + ", "
				+ plusFaible.getNom()
				+ " a été déclaré le Neuneu le plus faible du Loft.");
		System.out.println("Pour cette raison, " + plusFaible.getNom()
				+ " est invité à quitter le Loft.");
		participants.remove(plusFaible);
	}

	public String donnerNumeroPourNomNeuneu() {
		++nombreNeuneuTotal;
		return nombreNeuneuTotal.toString();
	}

	public void go(int nbJour) {
		for (int i = 0; i <= nbJour - 1; i++) {
			jour = jour + 1;
			System.out.println("Début du jour n°" + jour + ".");
			for (Neuneu neuneu : participants) {
				neuneu.tour();
			}
			this.selectionNaturelle();
		}
	}

}
