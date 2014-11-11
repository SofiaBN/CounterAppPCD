import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class FenetreSec2 extends JFrame {
  private JPanel container = new JPanel();
  private JTextField zone_texte = new JTextField("");
  private JLabel label = new JLabel("Valeur maximale");
  private JButton b = new JButton ("OK");
  private JButton b2 = new JButton ("Annuler");

  public FenetreSec2(){
    this.setTitle("Definition de la valeur maximale");
    this.setSize(500, 150);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);

    container.setLayout(new BorderLayout());
    JPanel top1 = new JPanel();
    JPanel top = new JPanel();
   
    zone_texte.setPreferredSize(new Dimension(150, 30));

    top1.add(label);
    top1.add(zone_texte);
    top.add(b);
    top.add(b2);

    container.add(top1, BorderLayout.CENTER);
    container.add(top, BorderLayout.SOUTH);
    this.setContentPane(container);
    
    b.addActionListener(new ActionOK());
    b2.addActionListener(new ActionA());
    
    this.setVisible(true);            
  }
  
  
  class ActionOK extends FenetreGraphique implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			valMax.setText(zone_texte.getText()+"                        ");
			valmax=Integer.parseInt(zone_texte.getText().toString());
			
			if(c.getValeur()>valmax) {
				afficheur.setText("                        "+valmax); 
			c.valeur=valmax;}
			
			dispose();
					
		}
	}
  
  class ActionA extends FenetreGraphique implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();			
		}
	}
  

  
  
}