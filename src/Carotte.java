
public class Carotte extends Nonneuneu {
	
	public Carotte(Case maCase) {
		super(3, maCase);
		this.masse = (int) (Math.random() * 9) + 1;
	}
	
	public Carotte(int m, Case maCase) {
		super(3, maCase);
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}
}
