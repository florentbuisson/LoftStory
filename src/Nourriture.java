import java.awt.Graphics;
import java.lang.String;

public abstract class Nourriture implements ObjetDessinable{
	
	private int valeurEnergetique;
	private Case maCase;
	public String nom;
	
	public Nourriture(){
		this.setValeurEnergetique(0);
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

	public Case getLaCase() {
		return maCase;
	}

	protected void setMaCase(Case maCase) {
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
	public int distanceAMaCase(Case cetteCase){
		return Math.max(Math.abs(getLaCase().getWPosition() - cetteCase.getWPosition()), Math.abs(getLaCase().getHPosition() - cetteCase.getHPosition()));
	}
	abstract boolean estUnNeuneu();
	abstract void estConsomme();
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
