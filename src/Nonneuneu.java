public abstract class Nonneuneu extends Nourriture {
	protected int masse;
	
	public Nonneuneu(int valeurE, Loft loft, Case maCase, String nom) {
		super(valeurE, loft, maCase, nom);
	}

	public void estConsomme() {
		masse = masse - 1;
		if (masse <= 0) {
			maison.jeSuisConsomme(this);
		}
	}

	public boolean estUnNeuneu() {
		return false;
	}
}
