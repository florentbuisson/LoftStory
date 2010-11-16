
public class Lapin extends Neuneu{

	
	public Lapin(Loft loft, int wPosition, int hPosition, String nom){
		super( loft, wPosition, hPosition, nom);
		
	}
	
	void bougeDeLa(){
		
	}
	void mange(){
		
	}
	void tour(){
		
	}
	void fornique(){
		
	}
	Neuneu accouplement(Neuneu partenaire){
		Lapin bebeNeuneu = new Lapin(maison, getLaCase().getWPosition(), getLaCase().getHPosition(), new String("Lapin" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance ˆ " + bebeNeuneu.getNom());
		return bebeNeuneu;
}
}
