package gsb.vue;


import gsb.modele.Stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JIFListeStock extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Stock> lesStock;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedecin;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	public JIFListeStock(MenuPrincipal uneFenetreContainer){
		fenetreContainer = uneFenetreContainer;
		
	}
		
	}

}
