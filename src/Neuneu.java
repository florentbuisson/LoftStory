

public abstract class Neuneu extends Nourriture{
	protected int membres;
	protected Loft maison;
	private int energie;
	protected String nom;
	protected Neuneu(){
		this.setEnergie(0);
	}
	protected Neuneu( Loft loft, int wPosition, int hPosition, String nom){
		this.maison = loft;
		this.setMaCase(maison.getCase( wPosition, hPosition));
		this.membres = 5;
		this.nom = nom;
		this.setEnergie(10);
	}
	abstract void bougeDeLa();
	abstract void mange();
	abstract void fornique();
	abstract void tour();
	abstract Neuneu accouplement(Neuneu partenaire);
	void toujoursLa(){
		
	}
	public int getEnergie(){
		return energie;
	}
	public void setEnergie(int nouvelleEnergie){
		this.energie = nouvelleEnergie;
		this.setValeurEnergetique(energie)
;	}
	String getNom(){
		return nom;
	}
	public void tesToujoursLa(){
		if(getEnergie() <= 0 || membres <= 0){
			maison.jeSuisMort(this);
		}
	}
	public boolean estUnNeuneu(){
		return true;
	}
}
