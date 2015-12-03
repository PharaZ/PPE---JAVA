package gsb.vue;


import gsb.modele.Stock;
import gsb.modele.dao.StockDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
		
	public JIFListeStock(MenuPrincipal uneFenetreContainer){
		fenetreContainer = uneFenetreContainer;
		//recuperation des données dans la collection
		lesStock = StockDao.retournerCollectionDesStocks();
		
		int nbLignes = lesStock.size();
		
		JTable table;
		
		p = new JPanel();//Panneau principal de la fenetre
		
		int i = 0;
		String[][] data = new String[nbLignes][3];
		for(Stock unStock : lesStock){
			data[i][0] = unStock.getUnVisiteur();
			data[i][1] = unStock.getUnMedicament();
			data[i][2] = unStock.getQteStock();
			i++;			
		}
		
		
	}
		
	}

