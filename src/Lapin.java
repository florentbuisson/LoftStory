
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
	Neuneu accouplement(Neuneu partenaire){
		Lapin bebeNeuneu = new Lapin(this.maison, this.maCase.getWPosition(), this.maCase. getHPosition(),  String("Lapin" + this.maison.donnerNumeroPourNomNeuneu()));
		return bebeNeuneu;
}
}
