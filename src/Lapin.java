
public class Lapin extends Neuneu{

	
	public Lapin(Loft loft, int wPosition, int hPosition, String nom){
		super( loft, wPosition, hPosition, nom);
		
	}
	
	void bougeDeLa(){
		if(maison.getParticipants().size() > 0){
			Nourriture lePlusProche = maison.getParticipants().get(0);
			for(int i = 1; i < maison.getParticipants().size(); ++i){
				if(lePlusProche.distanceAMaCase(getLaCase()) > maison.getParticipants().get(i).distanceAMaCase(getLaCase())){
					lePlusProche = maison.getParticipants().get(i);
				}
			}
			int deplacementX=getLaCase().getWPosition() - lePlusProche.getLaCase().getWPosition();
			int deplacementY=getLaCase().getHPosition() - lePlusProche.getLaCase().getHPosition();
			deplacementX = (int) Math.signum(deplacementX);
			deplacementY = (int) Math.signum(deplacementY);
			setMaCase(maison.getCase( getLaCase().getWPosition() + deplacementX, getLaCase().getHPosition() + deplacementY));
		}
		else if(maison.getAliments().size() > 0){
			Nourriture lePlusProche = maison.getAliments().get(0);
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
		Lapin bebeNeuneu = new Lapin(maison, getLaCase().getWPosition(), getLaCase().getHPosition(), new String("Lapin" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance  " + bebeNeuneu.getNom());
		return bebeNeuneu;
}
}
