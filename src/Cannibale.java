
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
		Cannibale bebeNeuneu = new Cannibale(this.maison, this.maCase.getWPosition(), this.maCase. getHPosition(), new String("Cannibale" + this.maison.donnerNumeroPourNomNeuneu()));
		return bebeNeuneu;
	}
}
