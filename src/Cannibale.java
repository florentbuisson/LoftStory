
public class Cannibale extends Vorace{

	public Cannibale(Loft loft, int wPosition, int hPosition, String nom){
		super(loft, wPosition, hPosition, nom);
	}
		
	void bougeDeLa(){
			
	}
	void mange(){
			
	}
	void tour(){
			
	}
	Neuneu accouplement(Neuneu partenaire){
		Cannibale bebeNeuneu = new Cannibale( maison, getLaCase().getWPosition(), getLaCase().getHPosition(), new String("Cannibale" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance ˆ " + bebeNeuneu.getNom());
		return bebeNeuneu;
	}
}
