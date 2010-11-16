
public class Erratique extends Neuneu{

	public Erratique(){
	}
	public Erratique(Loft loft, int wPosition, int hPosition, String nom){
		super( loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		int deplacement = (int)Math.random()*9;
		this.setMaCase(maison.getCase( getLaCase().getWPosition() + deplacement/3, getLaCase().getHPosition() + deplacement%3));
	}
	void mange(){
		boolean premierTrouve = true;
		Nonneuneu lePlusBon = new Carotte();
		lePlusBon.setValeurEnergetique(0);
		for(int i = 0; i < getLaCase().getOccupants().size(); ++i){
			if(!getLaCase().getOccupants().get(i).estUnNeuneu()){
				Nonneuneu ceNonNeuneu = (Nonneuneu) getLaCase().getOccupants().get(i);
				if(premierTrouve){
					lePlusBon = ceNonNeuneu;
					premierTrouve = false;
				}
				else if(ceNonNeuneu.getValeurEnergetique() > lePlusBon.getValeurEnergetique()){
					lePlusBon = ceNonNeuneu;
				}
			}
		}
		if(lePlusBon.getValeurEnergetique() > 0){
			lePlusBon.estConsomme();
			setEnergie(getEnergie() + lePlusBon.getValeurEnergetique());
		}
	}
	void fornique(){
		boolean premierTrouve = true;
		// S'accoupler doit être plus intérressant que la nécrophilie: on crée donc un erratique mort.
		// Ceci est du au manque de souplesse de java quant à la non-initialisation.
		Neuneu lePlusBeau = new Erratique();
		for(int i = 0; i < getLaCase().getOccupants().size(); ++i){
			if(getLaCase().getOccupants().get(i).estUnNeuneu()){
				Neuneu ceNeuneu = (Neuneu) getLaCase().getOccupants().get(i);
				if(premierTrouve){
					lePlusBeau = ceNeuneu;
					premierTrouve = false;
				}
				else if(ceNeuneu.getEnergie() > lePlusBeau.getEnergie()){
					lePlusBeau = ceNeuneu;
				}
			}
		}
		if(lePlusBeau.getEnergie() >= 3){
			maison.jeSuisNe(this.accouplement(lePlusBeau));
			setEnergie(getEnergie() - 2);
			lePlusBeau.setEnergie(lePlusBeau.getEnergie() - 2);
		}
	}
	void tour(){
		bougeDeLa();
		setEnergie(getEnergie() - 1);
		mange();
		tesToujoursLa();
		if(getEnergie() >= 3){
			fornique();
		}
	}
	Neuneu accouplement(Neuneu partenaire){
		Erratique bebeNeuneu = new Erratique(maison, getLaCase().getWPosition(), getLaCase(). getHPosition(), new String("Erratique" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance à " + bebeNeuneu.getNom());
		return bebeNeuneu;
	}
}
