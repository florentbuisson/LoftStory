import java.lang.String;

public class Nourriture {
	
	private int valeurEnergetique;
	protected Case maCase;
	public String nom;
	
	public Nourriture(){
		this.setValeurEnergetique(0);
		this.maCase = new Case();
	}
	
	public Nourriture(int valeurEnergetique){
		this();
		this.setValeurEnergetique(valeurEnergetique);
	}
	
	public Nourriture( int valeurEnergetique, Case cetteCase){
		this(valeurEnergetique);
		this.maCase = cetteCase;
	}
	
	public int getValeurEnergetique(){
		return valeurEnergetique;
	}

	public Case getMaCase() {
		return maCase;
	}

	public void setMaCase(Case maCase) {
		this.maCase = maCase;
	}

	public void setValeurEnergetique(int valeurEnergetique) {
		if(valeurEnergetique > 50){
			valeurEnergetique = 50;
		}
		else if(valeurEnergetique < 0){
			valeurEnergetique = 0;
		}
		this.valeurEnergetique = valeurEnergetique;
	}
	
	

}
