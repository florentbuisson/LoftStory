import java.awt.Graphics;
import java.util.LinkedList;

public class Loft implements ObjetDessinable{

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

	public Loft(int tailleLoft, ZoneGraphique Zone) {
		this.taille = tailleLoft;
		plateau = new Case[taille][taille];
		participants = new LinkedList<Neuneu>();
		aliments = new LinkedList<Nonneuneu>();
		morts = new LinkedList<Neuneu>();
		nes = new LinkedList<Neuneu>();
		//aliments = new List<Nonneuneu>;
		for (int i = 0; i <= taille - 1; i++) {
			for (int j = 0; j <= taille - 1; j++) {
				plateau[i][j] = new Case(i,j);
			}
		}
	}

	public Case getCase(int w, int h) {
		// Prise en compte des limites du loft dans le cas du deplacement du
		// neuneu erratique
		if (w <= 0) {
			w = 0;
		} else if (w >= taille) {
			w = taille - 1;
		}
		if (w <= 0) {
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
			int w = (int) (Math.random() * (taille - 1));
			int h = (int) (Math.random() * (taille - 1));
			int a = (int) (Math.random() * 2);
			switch (a) {
			case 0:
				nonneuneu = new Carotte(plateau[w][h]);
				break;
			case 1:
				nonneuneu = new Viande(plateau[w][h]);
				break;
			case 2:
				nonneuneu = new Alcool(plateau[w][h]);
				break;
			default:
				nonneuneu = new Alcool(plateau[w][h]);
				break;
			}
			aliments.add(nonneuneu);
			plateau[w][h].addOccupant(nonneuneu);
		}
		
	}

	public void add(Neuneu neuneu) {
		participants.add(neuneu);
		int w = neuneu.getLaCase().getWPosition();
		int h = neuneu.getLaCase().getHPosition();
		plateau[w][h].addOccupant(neuneu);
	}

	protected void selectionNaturelle() {
		Neuneu plusFaible = participants.get(0);
		for (Neuneu neuneu : participants) {
			if (neuneu.getEnergie() < plusFaible.getEnergie())
				plusFaible = neuneu;
		}
		System.out.println("A la fin du jour numero" + jour + ", "
				+ plusFaible.getNom()
				+ " a ete declare le Neuneu le plus faible du Loft.");
		System.out.println("Pour cette raison, " + plusFaible.getNom()
				+ " est invite a quitter le Loft.");
		participants.remove(plusFaible);
		int w = plusFaible.getLaCase().getWPosition();
		int h = plusFaible.getLaCase().getHPosition();
		plateau[w][h].removeOccupant(plusFaible);
	}

	public String donnerNumeroPourNomNeuneu() {
		nombreNeuneuTotal = nombreNeuneuTotal + 1;
		return nombreNeuneuTotal.toString();
	}

	public void go(int nbJour) {
		for (int i = 0; i <= nbJour - 1; i++) {
			jour = jour + 1;
			System.out.println("Debut du jour numero" + jour + ".");
			for (Neuneu neuneu : participants) {
				neuneu.tour();
			}
			this.selectionNaturelle();
		}
	}

	public void jeSuisMort(Neuneu neuneuMort) {
		participants.remove(neuneuMort);
		int w = neuneuMort.getLaCase().getWPosition();
		int h = neuneuMort.getLaCase().getHPosition();
		plateau[w][h].removeOccupant(neuneuMort);
		morts.add(neuneuMort);
	}

	public void jeSuisNe(Neuneu jeuneNeuneu) {
		participants.add(jeuneNeuneu);
		int w = jeuneNeuneu.getLaCase().getWPosition();
		int h = jeuneNeuneu.getLaCase().getHPosition();
		plateau[w][h].addOccupant(jeuneNeuneu);
		nes.add(jeuneNeuneu);
	}

	public void dessinerObjet(Graphics g) {
		
		
	}
}
