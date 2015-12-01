package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFAjoutStock extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	protected JPanel p;
	protected JPanel pSaisie;
	protected JPanel pText;
	protected JPanel pBouton;
	
	protected JButton JBajouter;
	
	protected JLabel JLMatVist;
	protected JLabel JLDepotLegal;
	protected JLabel JLQte;
	
	protected JTextField JTMatVist;
	protected JTextField JTDepotLegal;
	protected JTextField JTQte;
	
	public JIFAjoutStock(){
		p = new JPanel(); //paneau principale fenetre
		pSaisie = new JPanel();
		pBouton = new JPanel(); //-- suportant les boutons
		pText = new JPanel(new GridLayout(10, 3));
		
		JLMatVist = new JLabel("Matricule Visiteur"); //instanciation des composant graphique
		JLDepotLegal = new JLabel("Depot legal");
		JLQte = new JLabel("Quantite");
		
		JTMatVist = new JTextField("Matricule Visiteur");
		JTDepotLegal = new JTextField("Depot legal");
		JTQte = new JTextField("Quantite");
		
		pSaisie.add(JTMatVist);
		pSaisie.add(JBajouter);
		p.add(pSaisie);
		
        pText.add(JLMatVist);
        pText.add(JTMatVist);
        pText.add(JLDepotLegal);
        pText.add(JTDepotLegal);
        pText.add(JLQte);
        pText.add(JTQte);
        
        // mise en forme de la fen�tre

        p.add(pText);
        p.add(pBouton);
        Container contentPane = getContentPane();
        contentPane.add(p);
        
        
		
	}	

}
