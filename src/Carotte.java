import java.awt.Color;
import java.awt.Graphics;

public class Carotte extends Nonneuneu {

	public Carotte(Loft loft, Case maCase) {
		super(3, loft, maCase, "Carotte");
		this.masse = (int) (Math.random() * 4);
	}

	public Carotte(int m, Loft loft, Case maCase) {
		super(3, loft, maCase, "Carotte");
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
		g.setColor(Color.ORANGE);
		g.fillOval(20 * getLaCase().getWPosition() + 4, 20 * getLaCase()
				.getHPosition() + 4, 12, 12);
		g.setColor(c);
	}
}
