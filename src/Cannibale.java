
public class Cannibale extends Vorace{

	public Cannibale(Loft loft, int wPosition, int hPosition, String nom){
		super(loft, wPosition, hPosition, nom);
	}
		
	void bougeDeLa(){
		if(maison.getAliments().size() > 0){
			Nourriture lePlusProche = maison.getAliments().get(0);
			for(int i = 1; i < maison.getAliments().size(); ++i){
				if(lePlusProche.distanceAMaCase(getLaCase()) > maison.getAliments().get(i).distanceAMaCase(getLaCase())){
					lePlusProche = maison.getAliments().get(i);
				}
			}
			for(int i = 0; i < maison.getParticipants().size(); ++i){
				if(lePlusProche.distanceAMaCase(getLaCase()) > maison.getParticipants().get(i).distanceAMaCase(getLaCase()) &&  maison.getParticipants().get(i).getNom() != getNom()){
					lePlusProche = maison.getParticipants().get(i);
				}
			}
			int deplacementX=getLaCase().getWPosition() - lePlusProche.getLaCase().getWPosition();
			int deplacementY=getLaCase().getHPosition() - lePlusProche.getLaCase().getHPosition();
			deplacementX = (int) Math.signum(deplacementX);
			deplacementY = (int) Math.signum(deplacementY);
			setMaCase(maison.getCase( getLaCase().getWPosition() + deplacementX, getLaCase().getHPosition() + deplacementY));
		}
		else if(maison.getParticipants().size() > 1){
			Nourriture lePlusProche = new Carotte();
			lePlusProche.setValeurEnergetique(0);
			if(maison.getParticipants().get(0).getNom() != getNom()){
				lePlusProche = maison.getParticipants().get(0);
			}
			else{
				lePlusProche = maison.getParticipants().get(1);
			}
			for(int i = 1; i < maison.getParticipants().size(); ++i){
				if(lePlusProche.distanceAMaCase(getLaCase()) > maison.getParticipants().get(i).distanceAMaCase(getLaCase()) &&  maison.getParticipants().get(i).getNom() != getNom()){
					lePlusProche = maison.getParticipants().get(i);
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
	public void mange(){
		boolean premierTrouve = true;
		Nourriture lePlusBon = new Carotte();
		lePlusBon.setValeurEnergetique(0);
		for(int i = 0; i < getLaCase().getOccupants().size(); ++i){
			Nourriture ceTruc = getLaCase().getOccupants().get(i);
			if(premierTrouve){
				lePlusBon = ceTruc;
				premierTrouve = false;
			}
			else if(ceTruc.getValeurEnergetique() > lePlusBon.getValeurEnergetique()){
				lePlusBon = ceTruc;
			}			
		}
		if(lePlusBon.getValeurEnergetique() > 0){
			lePlusBon.estConsomme();
			setEnergie(getEnergie() + lePlusBon.getValeurEnergetique());
		}
	}
	Neuneu accouplement(Neuneu partenaire){
		Cannibale bebeNeuneu = new Cannibale( maison, getLaCase().getWPosition(), getLaCase().getHPosition(), new String("Cannibale" + this.maison.donnerNumeroPourNomNeuneu()));
		System.out.println(this.getNom() + " et " + partenaire.getNom() + " donnent naissance ˆ " + bebeNeuneu.getNom());
		return bebeNeuneu;
	}
}
