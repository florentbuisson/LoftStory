
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * un panneau de dessin pour le loft
 * 
 * @author moreau
 *
 */
class LoftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * r�f�rence sur la liste des objets � dessiner
	 */
	private LinkedList<ObjetDessinable> listeObjets;
	
	/**
	 * constructeur
	 * 
	 * @param listeObjets r�f�rence sur la liste des objets (g�r�e par la ZoneGraphique)
	 */
	public LoftPanel(LinkedList<ObjetDessinable> listeObjets) {
		this.listeObjets = listeObjets;
	}
	
	/**
	 * on red�finit la m�thode paint() : elle se contente d'appeler les m�thodes
	 * dessinerObjet() de la liste d'objets dessinables
	 */
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		// on redessine tout
		for (ObjetDessinable x : listeObjets) {
			x.dessinerObjet(g);
		}
	}
}
