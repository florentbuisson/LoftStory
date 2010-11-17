import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

/**
 * une classe comportant une zone graphique dans laquelle on peut dessiner ; le
 * dessin est refait automatiquement par la classe Panel associ�e ; tous les
 * objets de type ObjetDessinable ajout�s � la liste sont redessin�s par un
 * appel � leur m�thode dessinerObjet(Graphics g)
 * 
 * @see ObjectDessinable,LoftPanel
 * @author moreau
 * 
 */
public class ZoneGraphique extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * la liste d'objets � dessiner
	 */
	LinkedList<ObjetDessinable> liste;

	/**
	 * constructeur
	 * 
	 * @param titre
	 *            le nom de l'application
	 */
	public ZoneGraphique(String titre) {
		// appel au constructeur de base
		super(titre);

		// ajout d'une taille par d�faut
		setSize(600, 600);

		// cr�ation de la liste d'objets
		liste = new LinkedList<ObjetDessinable>();

		// ajout d'un listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// cr�ation du panneau
		LoftPanel a = new LoftPanel(liste);
		getContentPane().add(a);

		setVisible(true);
	}// TODO Auto-generated method stub

	/**
	 * ajout d'un objet dans la zone graphique
	 */
	void ajouterObjet(ObjetDessinable o) {
		liste.add(o);
	}

	void retirerObjet(ObjetDessinable o) {
		liste.remove(o);
	}

	/**
	 * largeur de la partie dessinable
	 */
	public int getWidth() {
		return getContentPane().getWidth();
	}

	/**
	 * hauteur de la partie dessinable
	 */
	public int getHeight() {
		return getContentPane().getHeight();
	}

}
