
public class Erratique extends Neuneu{

	public Erratique(Loft loft, int wPosition, int hPosition, String nom){
		super( loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		
	}
	void mange(){
		
	}
	void tour(){
		
	}
	Neuneu accouplement(Neuneu partenaire){
		Erratique bebeNeuneu = new Erratique(this.maison, this.maCase.getWPosition(), this.maCase. getHPosition(), new String("Erratique" + this.maison.donnerNumeroPourNomNeuneu()));
		return bebeNeuneu;
	}
}
