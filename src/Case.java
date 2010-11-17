import java.util.LinkedList;

public class Case {
	private int wPosition;
	private int hPosition;
	private LinkedList<Nourriture> occupants;

	public Case(int w, int h) {
		this.wPosition = w;
		this.hPosition = h;
		occupants = new LinkedList<Nourriture>();
	}

	public int getWPosition() {
		return wPosition;
	}

	public int getHPosition() {
		return hPosition;
	}

	public LinkedList<Nourriture> getOccupants() {
		return occupants;
	}

	public void addOccupant(Nourriture miam) {
		occupants.add(miam);
	}

	public void removeOccupant(Nourriture miam) {
		try {
			occupants.remove(miam);
		} catch (NullPointerException npe) {
		}
	}
}
