import java.awt.Graphics;
import java.util.LinkedList;

public class Loft implements ObjetDessinable {

	/**
	 * @param args
	 */
	protected int taille;
	protected int jour = 0;
	protected Case[][] plateau;
	protected LinkedList<Neuneu> participants;
	protected LinkedList<Nonneuneu> aliments;
	protected LinkedList<Neuneu> morts;
	protected LinkedList<Neuneu> nes;
	protected Integer nombreNeuneuTotal = 0;
	protected ZoneGraphique maZone;

	public Loft(int tailleLoft, ZoneGraphique zone) {
		this.taille = tailleLoft;
		plateau = new Case[taille][taille];
		participants = new LinkedList<Neuneu>();
		aliments = new LinkedList<Nonneuneu>();
		morts = new LinkedList<Neuneu>();
		nes = new LinkedList<Neuneu>();
		// aliments = new List<Nonneuneu>;
		for (int i = 0; i <= taille - 1; i++) {
			for (int j = 0; j <= taille - 1; j++) {
				plateau[i][j] = new Case(i, j);
			}
		}
		maZone = zone;
	}

	public Case getCase(int w, int h) {
		// Prise en compte des limites du loft dans le cas du deplacement du
		// neuneu erratique
		if (w <= 0) {
			w = 0;
		} else if (w >= taille) {
			w = taille - 1;
		}
		if (h <= 0) {
			h = 0;
		} else if (h >= taille) {
			h = taille - 1;
		}
		return plateau[w][h];
	}

	public LinkedList<Neuneu> getParticipants() {
		return this.participants;
	}

	public LinkedList<Nonneuneu> getAliments() {
		return this.aliments;
	}

	public void remplissageAleatoire(float ratio) {
		int nombreNonneuneu = (int) (taille * taille * ratio);
		Nonneuneu nonneuneu;
		for (int i = 0; i <= nombreNonneuneu - 1; i++) {
			int w = (int) (Math.random() * taille);
			int h = (int) (Math.random() * taille);
			int a = (int) (Math.random() * 3);
			switch (a) {
			case 0:
				nonneuneu = new Carotte(this, plateau[w][h]);
				break;
			case 1:
				nonneuneu = new Viande(this, plateau[w][h]);
				break;
			case 2:
				nonneuneu = new Alcool(this, plateau[w][h]);
				break;
			default:
				nonneuneu = new Alcool(this, plateau[w][h]);
				break;
			}
			aliments.add(nonneuneu);
			plateau[w][h].addOccupant(nonneuneu);
			maZone.ajouterObjet(nonneuneu);
		}

	}

	public void add(Neuneu neuneu) {
		participants.add(neuneu);
		int w = neuneu.getLaCase().getWPosition();
		int h = neuneu.getLaCase().getHPosition();
		plateau[w][h].addOccupant(neuneu);
		maZone.ajouterObjet(neuneu);
	}

	protected void selectionNaturelle() {
		if (jour <= 3) {
			System.out
					.println("Pas d'elimination le jour numero " + jour + ".");
		} else {
			Neuneu plusFaible = participants.get(0);
			for (Neuneu neuneu : participants) {
				if (neuneu.getEnergie() < plusFaible.getEnergie())
					plusFaible = neuneu;
			}
			System.out.println("A la fin du jour " + jour + ", "
					+ plusFaible.getNom()
					+ " a ete declare le Neuneu le plus faible du Loft.");
			System.out.println("Pour cette raison, " + plusFaible.getNom()
					+ " est invite a quitter le Loft.");
			participants.remove(plusFaible);
			int w = plusFaible.getLaCase().getWPosition();
			int h = plusFaible.getLaCase().getHPosition();
			plateau[w][h].removeOccupant(plusFaible);
			maZone.retirerObjet(plusFaible);
		}
	}

	public String donnerNumeroPourNomNeuneu() {
		nombreNeuneuTotal = nombreNeuneuTotal + 1;
		return nombreNeuneuTotal.toString();
	}

	public void go(int nbJour) {
		for (int i = 0; i <= nbJour - 1; i++) {

			if (participants.size() >= 1) {
				jour = jour + 1;
				System.out.println("Debut du jour numero" + jour + ".");
				for (Neuneu neuneu : participants) {
					try {
						System.out.print(neuneu.getNom() + " ("
								+ neuneu.getEnergie() + ") [" + neuneu.getMembres() + "] $ ");
						neuneu.tour();
						maZone.repaint();
						Thread.sleep(50);
					} catch (InterruptedException ie) {
						// If this thread was intrrupted by nother thread
					}
				}
				System.out.println();
				// this.selectionNaturelle();
			}
			this.decesEtNaissances();
		}
	}

	public Case jeMeDeplace(Neuneu neuneuQuiBouge, int x, int y) {
		Case caseNeuneu = neuneuQuiBouge.getLaCase();
		int w = caseNeuneu.getWPosition();
		int h = caseNeuneu.getHPosition();
		Case nouvelleCase = getCase(w + x, h + y);
		caseNeuneu.removeOccupant(neuneuQuiBouge);
		nouvelleCase.addOccupant(neuneuQuiBouge);
		return nouvelleCase;
	}

	public void jeSuisMort(Neuneu neuneuMort) {
		morts.add(neuneuMort);
	}

	public void jeSuisNe(Neuneu jeuneNeuneu) {
		nes.add(jeuneNeuneu);
	}

	public void jeSuisConsomme(Nonneuneu aliment) {
		aliments.remove(aliment);
		plateau[aliment.getLaCase().getWPosition()][aliment.getLaCase()
				.getHPosition()].removeOccupant(aliment);
		maZone.retirerObjet(aliment);
	}

	// Methode qui affiche la liste des Neuneu morts et des Neuneu nes durant la
	// journee et reinitialise les listes associees
	protected void decesEtNaissances() {
		// Gestion des Neuneus morts
		System.out.println("Le(s) neuneu(s) mort(s) durant le jour " + jour
				+ " sont:");
		for (Neuneu neuneuMort : morts) {
			System.out.print(neuneuMort.getNom() + " ");
			participants.remove(neuneuMort);
			int w = neuneuMort.getLaCase().getWPosition();
			int h = neuneuMort.getLaCase().getHPosition();
			plateau[w][h].removeOccupant(neuneuMort);
			maZone.retirerObjet(neuneuMort);
		}
		System.out.println();
		morts.clear();

		// Gestion des Neuneus nes
		System.out.println("Le(s) neuneu(s) ne(s) durant le jour " + jour
				+ " sont:");
		for (Neuneu jeuneNeuneu : nes) {
			participants.add(jeuneNeuneu);
			int w = jeuneNeuneu.getLaCase().getWPosition();
			int h = jeuneNeuneu.getLaCase().getHPosition();
			plateau[w][h].addOccupant(jeuneNeuneu);
			System.out.print(jeuneNeuneu.getNom() + " ");
			maZone.ajouterObjet(jeuneNeuneu);
		}
		System.out.println();
		nes.clear();
	}

	public void dessinerObjet(Graphics g) {

	}
}
