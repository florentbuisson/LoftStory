import java.util.List;


public class Case {
	private int wPosition;
	private int hPosition;
	private List<Nourriture> occupants;
	
	public Case( int w, int h){
		this.wPosition = w;
		this.hPosition = h;
	}
	public int getWPosition(){
		return wPosition;
	}
	public int getHPosition(){
		return hPosition;
	}
	public List<Nourriture> getOccupants(){
		return occupants;
	}
}
