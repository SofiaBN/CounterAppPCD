import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;





public class FenetreGraphique {

	static Compteur c=new Compteur(0);
	
	static Integer valmin=-17;
	static Integer valmax=54;
	static JLabel valMin = new JLabel("                     "+valmin);
	static JLabel valMax = new JLabel(valmax+"                     ");



	static JLabel afficheur = new JLabel("                        "+c.getValeur());


	JMenuBar menu = new JMenuBar();
	JMenu m1 = new JMenu("Fichier");	  
	JMenu m2 = new JMenu("Modifier");
	JMenu m3 = new JMenu("Intervalle");

	JMenuItem item1 = new JMenuItem("-1");
	JMenuItem item2 = new JMenuItem("+1");
	JMenuItem item3 = new JMenuItem("Définir valeur minimale");
	JMenuItem item4 = new JMenuItem("Définir valeur maximale");
	JMenuItem item5 = new JMenuItem("Quitter");




	public FenetreGraphique() {
	

		//titre
		JFrame fenetre = new JFrame("CounterApp");



		//On demande à notre objet de se positionner au centre
		fenetre.setLocationRelativeTo(null);


		Container contenu = fenetre.getContentPane();
		contenu.setLayout(new java.awt.BorderLayout());



		JButton bDecrementer = new JButton("-1");
		contenu.add(bDecrementer);

		contenu.add( valMin );

		contenu.add( afficheur );

		contenu.add( valMax );



		JButton bIncrementer = new JButton("+1");
		contenu.add(bIncrementer);

		JPanel p = new JPanel();
		p.add(bDecrementer);
		p.add(bIncrementer);
		contenu.add(p,BorderLayout.SOUTH);
		contenu.add(valMax,BorderLayout.EAST);
		contenu.add(valMin,BorderLayout.WEST);
		contenu.add(afficheur, BorderLayout.CENTER);
		fenetre.setSize(333,200);


		// Definition controleur
		bIncrementer.addActionListener(new ActionD());
		bDecrementer.addActionListener(new ActionD());

		


		fenetre.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);


		this.initMenu();

		this.menu.add(m1);
		this.menu.add(m2);
		this.menu.add(m3);
		fenetre.setJMenuBar(menu);


		item1.addActionListener(new ActionI1());
		item2.addActionListener(new ActionI2());
		
		item3.addActionListener(new ActionI3());
		item4.addActionListener(new ActionI4());
		item5.addActionListener(new ActionI5());

		fenetre.setVisible(true); // la rendre visible

	}



	private void initMenu(){
		m1.add(item5);

		m2.add(item1);
		m2.add(item2);

		m3.add(item3);
		m3.add(item4);
	}



	

	

	class ActionI3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			new FenetreSec();
		}
		
	}
	
	class ActionI4 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new FenetreSec2();
		}
	}
	class ActionI5 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit (0);
		}
	}


	class ActionD implements ActionListener {
		public void actionPerformed(ActionEvent ev) {

			String btnLabel = ev.getActionCommand();
			// event.getActionCommand() retourne le label du boutton
			if (btnLabel.equals("-1") && c.getValeur()>valmin) {

				c.decrement();

			} else if (btnLabel.equals("+1") && c.getValeur()<valmax) {
				c.increment();
			} 

			afficheur.setText("                        "+c.getValeur());

		}

	}
	
	
	
	
	class ActionI1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (c.getValeur()>valmin)
				
				c.decrement();
			afficheur.setText("                        "+c.getValeur());
		}
	}
	
	class ActionI2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (c.getValeur()<valmax) 

				c.increment();
			afficheur.setText("                        "+c.getValeur());
		}
	}
	



	public static class Compteur {
		protected int valeur; // valeur du compteur

		/* Initialiser la valeur du compteur */
		public Compteur(int v) { this.valeur = v; }

		/* Augmenter de 1 le compteur */

		public void increment() { this.valeur++; }
		public void decrement() { this.valeur--; }

		/* Obtenir la valeur du compteur */
		public int getValeur() { return this.valeur ; }

	}

	
	
	
	
}
