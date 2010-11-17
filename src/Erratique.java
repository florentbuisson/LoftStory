import java.awt.Graphics;


public class Erratique extends Neuneu implements ObjetDessinable{

	public Erratique(){
	}
	public Erratique(Loft loft, int wPosition, int hPosition, String nom){
		super( loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		int deplacement = (int)Math.random()*9;
		this.setMaCase(maison.getCase( getLaCase().getWPosition() + deplacement/3, getLaCase().getHPosition() + deplacement%3));
	}
	void tour(){
		bougeDeLa();
		setEnergie(getEnergie() - 1);
		mange();
		tesToujoursLa();
		if(getEnergie() >= 3){
			fornique();
		}
	}
	Neuneu accouplement(Neuneu partenaire){
		Erratique bebeNeuneu = new Erratique(maison, getLaCase().getWPosition(), getLaCase(). getHPosition(), new String("Erratique" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance  " + bebeNeuneu.getNom());
		return bebeNeuneu;
	}
	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
