import java.awt.Graphics;


public class Viande extends Nonneuneu{
	
	public Viande(Case maCase) {
		super(7, maCase);
		this.masse = (int) (Math.random() * 9) + 1;

	}
	
	public Viande(Case maCase, int m) {
		super(7, maCase);
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}
	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
