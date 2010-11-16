
public class Vorace extends Erratique{

	public Vorace(Loft loft, int wPosition, int hPosition, String nom){
		super(loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		
	}
	void mange(){
		
	}
	void tour(){
		
	}
	Neuneu accouplement(Neuneu partenaire){
		Vorace bebeNeuneu = new Vorace(this.maison, this.maCase.getWPosition(), this.maCase. getHPosition(), new String("Vorace" + this.maison.donnerNumeroPourNomNeuneu()));
		return bebeNeuneu;
	}
}
