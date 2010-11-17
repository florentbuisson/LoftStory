import java.awt.Color;
import java.awt.Graphics;

public class Alcool extends Nonneuneu {

	public Alcool(Loft loft, Case maCase) {
		super(5, loft, maCase, "Picole");
		this.masse = (int) (Math.random() * 4);
	}

	public Alcool(int m, Loft loft, Case maCase) {
		super(5, loft, maCase, "Picole");
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
		g.setColor(Color.GREEN);
		g.fillOval(20 * getLaCase().getWPosition() + 4, 20 * getLaCase()
				.getHPosition() + 4, 12, 12);
		g.setColor(c);
	}
}
