import java.awt.Color;
import java.awt.Graphics;


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
	@Override
	public void dessinerObjet(Graphics g) {
		// TODO Auto-generated method stub
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(20*getLaCase().getWPosition()+4, 20*getLaCase().getHPosition()+4, 12, 12);
		g.setColor(c);
	}
}
