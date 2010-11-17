import java.awt.Color;
import java.awt.Graphics;


public class Erratique extends Neuneu implements ObjetDessinable{

	public Erratique(Loft loft, int wPosition, int hPosition, String nom){
		super( loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		int deplacement = (int)(Math.random()*9);
		seDeplacer((int)(deplacement/3) - 1, (int)(deplacement%3) - 1);
	}
	void tour(){
		bougeDeLa();
		setEnergie(getEnergie() - 1);
		mange();
		tesToujoursLa();
		if(getEnergie() >= 6){
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
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(20*getLaCase().getWPosition()+4, 20*getLaCase().getHPosition()+4, 12, 12);
		g.setColor(c);
	}
}
