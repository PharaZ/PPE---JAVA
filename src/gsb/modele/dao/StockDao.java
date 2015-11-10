/**
 * 
 */
package gsb.modele.dao;

import gsb.modele.Medicament;
import gsb.modele.Stock;
import gsb.modele.Visiteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Guillaume
 *
 */
public class StockDao {
	public static Stock rechercher(String depotLegal){
		Stock unStock=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from STOCK where DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				Visiteur unVisiteur = VisiteurDao.rechercher(reqSelection.getString(2));
				Medicament unMedicament = MedicamentDao.rechercher(reqSelection.getString(3));
				unStock = new Stock(reqSelection.getInt(1),unVisiteur, unMedicament);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from STOCK where DEPOTLEGAl ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unStock;
	}
	
	public static ArrayList<Stock> retournerCollectionDesStocks(){
		ArrayList<Stock> collectionDesStocks = new ArrayList<Stock>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from STOCK");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    collectionDesStocks.add(StockDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesStocks()");
		}
		return collectionDesStocks;
	}
	
	public static HashMap<String,Stock> retournerDictionnaireDesStocks(){
		HashMap<String, Stock> diccoDesStocks = new HashMap<String, Stock>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from STOCK");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    diccoDesStocks.put(depotLegal, StockDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesStocks()");
		}
		return diccoDesStocks;
	}
}
dsfdsf
