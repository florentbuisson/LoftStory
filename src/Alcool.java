public class Alcool extends Nonneuneu {

	public Alcool(Case maCase) {
		super(5, maCase);
		this.masse = (int) (Math.random() * 9) + 1;
	}

	public Alcool(int m, Case maCase) {
		super(5, maCase);
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}
}
