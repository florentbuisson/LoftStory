
public abstract class Nonneuneu extends Nourriture{
	protected int masse;
	
	public Nonneuneu(int valeurE, Case maCase){
		super(valeurE, maCase);
	}
	public void estConsomme(){
		masse = masse - 1;
	}
	public boolean estUnNeuneu(){
		return false;
	}
}
