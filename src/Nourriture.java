import java.awt.Graphics;
import java.lang.String;

public abstract class Nourriture implements ObjetDessinable {

	private int valeurEnergetique;
	protected Loft maison;
	private Case maCase;
	public String nom;

	public Nourriture(int valeurE, Loft loft, int wPosition, int hPosition, String nom) {
		this.valeurEnergetique = valeurE;
		this.maison = loft;
		this.maCase = maison.getCase(wPosition, hPosition);
		this.nom = nom;
	}
	
	public Nourriture(int valeurE, Loft loft, Case cetteCase, String nom) {
		this.valeurEnergetique = valeurE;
		this.maison = loft;
		this.maCase = cetteCase;
		this.nom = nom;
	}

	public int getValeurEnergetique() {
		return valeurEnergetique;
	}

	public Case getLaCase() {
		return maCase;
	}

	protected void setMaCase(Case maCase) {
		this.maCase = maCase;
	}

	public void setValeurEnergetique(int valeurEnergetique) {
		if (valeurEnergetique > 50) {
			valeurEnergetique = 50;
		} else if (valeurEnergetique < 0) {
			valeurEnergetique = 0;
		}
		this.valeurEnergetique = valeurEnergetique;
	}

	public int distanceAMaCase(Case cetteCase) {
		return Math
				.max(Math.abs(getLaCase().getWPosition()
						- cetteCase.getWPosition()),
						Math.abs(getLaCase().getHPosition()
								- cetteCase.getHPosition()));
	}

	String getNom() {
		return nom;
	}

	abstract boolean estUnNeuneu();

	abstract void estConsomme();

	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub

	}
}
