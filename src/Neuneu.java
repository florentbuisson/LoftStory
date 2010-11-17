public abstract class Neuneu extends Nourriture {

	protected int membres;
	private int energie;

	protected Neuneu(Loft loft, int wPosition, int hPosition, String nom) {
		super(10, loft, wPosition, hPosition, nom);
		this.membres = 5;
		this.setEnergie(10);
	}

	abstract void bougeDeLa();

	protected void mange() {
		boolean premierTrouve = true;
		Nonneuneu lePlusBon = new Carotte(getLaCase());
		lePlusBon.setValeurEnergetique(0);
		for (int i = 0; i < getLaCase().getOccupants().size(); ++i) {
			if (!getLaCase().getOccupants().get(i).estUnNeuneu()) {
				Nonneuneu ceNonNeuneu = (Nonneuneu) getLaCase().getOccupants()
						.get(i);
				if (premierTrouve) {
					lePlusBon = ceNonNeuneu;
					premierTrouve = false;
				} else if (ceNonNeuneu.getValeurEnergetique() > lePlusBon
						.getValeurEnergetique()) {
					lePlusBon = ceNonNeuneu;
				}
			}
		}
		if (lePlusBon.getValeurEnergetique() > 0) {
			lePlusBon.estConsomme();
			setEnergie(getEnergie() + lePlusBon.getValeurEnergetique());
		}
	}

	void fornique() {
		boolean premierTrouve = true;
		// S'accoupler doit être plus intérressant que la nécrophilie: on crée
		// donc un erratique mort.
		// Ceci est du au manque de souplesse de java quant à la
		// non-initialisation.
		Neuneu lePlusBeau = this;
		for (int i = 0; i < getLaCase().getOccupants().size(); ++i) {
			if (getLaCase().getOccupants().get(i).estUnNeuneu()) {
				Neuneu ceNeuneu = (Neuneu) getLaCase().getOccupants().get(i);
				if (!ceNeuneu.getNom().equals(getNom())) {
					if (premierTrouve) {
						lePlusBeau = ceNeuneu;
						premierTrouve = false;
					} else if (ceNeuneu.getEnergie() > lePlusBeau.getEnergie()) {
						lePlusBeau = ceNeuneu;
					}
				}
			}
		}
		if (lePlusBeau.getEnergie() >= 6 && !lePlusBeau.getNom().equals(getNom())) {
			maison.jeSuisNe(this.accouplement(lePlusBeau));
			setEnergie(getEnergie() - 6);
			lePlusBeau.setEnergie(lePlusBeau.getEnergie() - 6);
		}
	}

	abstract void tour();

	abstract Neuneu accouplement(Neuneu partenaire);

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int nouvelleEnergie) {
		this.energie = nouvelleEnergie;
		this.setValeurEnergetique(energie);
	}

	public void tesToujoursLa() {
		if (getEnergie() <= 0 || membres <= 0) {
			maison.jeSuisMort(this);
		}
	}

	public boolean estUnNeuneu() {
		return true;
	}

	public void estConsomme() {
		membres = membres - 1;
		tesToujoursLa();
	}
}
