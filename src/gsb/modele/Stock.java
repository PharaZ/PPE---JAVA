/**
 * 
 */
package gsb.modele;

import java.util.ArrayList;

/**
 * @author Guillaume
 *
 */
public class Stock {
	   public int qteStock;
	   public Visiteur  unVisiteur;
	   public Medicament unMedicament;
	   public ArrayList<Stock> lesStock;
	/**
	 * @param qteStock
	 * @param unVisiteur
	 * @param unMedicament
	 */
	public Stock(int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		super();
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}
	/**
	 * @return the qteStock
	 */
	public int getQteStock() {
		return qteStock;
	}
	/**
	 * @param qteStock the qteStock to set
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	/**
	 * @return the unVisiteur
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}
	/**
	 * @param unVisiteur the unVisiteur to set
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	/**
	 * @return the unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}
	/**
	 * @param unMedicament the unMedicament to set
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	
	public ArrayList<Stock> getLesStock() {
		return lesStock;
	}

	public void setLesTaches(ArrayList<Stock> lesStock) {
		this.lesStock = lesStock;
	} 

	public void ajouterTache(Stock unStock){
		if(lesStock == null) lesStock = new ArrayList<Stock>();
		lesStock.add(unStock);
		}
	
	}

