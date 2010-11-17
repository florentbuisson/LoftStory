import java.awt.Color;
import java.awt.Graphics;

public class Viande extends Nonneuneu {

	public Viande(Loft loft, Case maCase) {
		super(7, loft, maCase, "Viande");
		this.masse = (int) (Math.random() * 4);
	}

	public Viande(int m, Loft loft, Case maCase) {
		super(7, loft, maCase, "Viande");
		if (m >= 1) {
			this.masse = m;
		} else {
			this.masse = 1;
		}
	}

	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(20 * getLaCase().getWPosition() + 4, 20 * getLaCase()
				.getHPosition() + 4, 12, 12);
		g.setColor(c);
	}
}
