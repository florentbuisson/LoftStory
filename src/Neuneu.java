
enum Corpulence {fin, normal, gros, Obese};

public abstract class Neuneu extends Aliment{
	protected int membres;
	protected Loft maison;
	protected Case maCase;
	protected int energie;
	protected Corpulence maCorpulence;
	protected String nom;
	
	protected Neuneu( Loft loft, int wPosition, int hPosition, String nom){
		this.maison = loft;
		this.maCase = loft.getCase( wPosition, hPosition);
		this.membres = 5;
		this.nom = nom;
	}
	abstract void bougeDeLa();
	abstract void mange();
	abstract void tour();
	abstract Neuneu accouplement(Neuneu partenaire);
	void toujoursLa(){
		
	}
	int getEnergie(){
		return energie;
	}
	void setEnergie(int nouvelleEnergie){
		this.energie = nouvelleEnergie;
	}
	String getNom(){
		return nom;
	}
}
