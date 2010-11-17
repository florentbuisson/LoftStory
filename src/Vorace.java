import java.awt.Color;
import java.awt.Graphics;


public class Vorace extends Erratique{

	public Vorace(Loft loft, int wPosition, int hPosition, String nom){
		super(loft, wPosition, hPosition, nom);
	}
	
	void bougeDeLa(){
		if(maison.getAliments().size() > 0){
			Nonneuneu lePlusProche = maison.getAliments().get(0);
			for(int i = 1; i < maison.getAliments().size(); ++i){
				if(lePlusProche.distanceAMaCase(getLaCase()) > maison.getAliments().get(i).distanceAMaCase(getLaCase())){
					lePlusProche = maison.getAliments().get(i);
				}
			}
			int deplacementX=getLaCase().getWPosition() - lePlusProche.getLaCase().getWPosition();
			int deplacementY=getLaCase().getHPosition() - lePlusProche.getLaCase().getHPosition();
			deplacementX = (int) Math.signum(deplacementX);
			deplacementY = (int) Math.signum(deplacementY);
			setMaCase(maison.getCase( getLaCase().getWPosition() + deplacementX, getLaCase().getHPosition() + deplacementY));
		}
		else{
			int deplacement = (int)Math.random()*9;
			setMaCase(maison.getCase( getLaCase().getWPosition() + deplacement/3, getLaCase().getHPosition() + deplacement%3));
		}
	}
	Neuneu accouplement(Neuneu partenaire){
		Vorace bebeNeuneu = new Vorace( maison, getLaCase().getWPosition(), getLaCase().getHPosition(), new String("Vorace" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance ˆ " + bebeNeuneu.getNom());
		return bebeNeuneu;
	}
	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(20*getLaCase().getWPosition()+4, 20*getLaCase().getHPosition()+4, 12, 12);
		g.setColor(c);
	}
}
