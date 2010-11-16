
public class Vorace extends Erratique{

	public Vorace(Loft loft, int wPosition, int hPosition, String nom){
		super(loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		if(maison.getAliments().size() > 0){
			Nonneuneu lePlusRentable = maison.getAliments().get(0);
			for(int i = 1; i < maison.getAliments().size(); ++i){
			lePlusRentable.getLaCase();
			
			}
		}
		else{
			int deplacement = (int)Math.random()*9;
			this.setMaCase(maison.getCase( getLaCase().getWPosition() + deplacement/3, getLaCase().getHPosition() + deplacement%3));
		}
	}
	Neuneu accouplement(Neuneu partenaire){
		Vorace bebeNeuneu = new Vorace( maison, getLaCase().getWPosition(), getLaCase().getHPosition(), new String("Vorace" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance ˆ " + bebeNeuneu.getNom());
		return bebeNeuneu;
	}
}
