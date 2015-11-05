/**
 * 
 */
package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import gsb.modele.Visiteur;

/**
 * @author Guillaume
 *
 */
public class VisiteurDao {
	
	public static Visiteur rechercher(String matricule){
		Visiteur unVisiteur=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITEUR where MATRICULE ='"+matricule+"'");
		try {
			if (reqSelection.next()) {
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8), reqSelection.getString(9), reqSelection.getDate(10), reqSelection.getInt(11), reqSelection.getString(12), reqSelection.getString(13));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE ='"+matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static ArrayList<Visiteur> retournerCollectionDesVisiteurs(){
		ArrayList<Visiteur> collectionDesVisiteurs = new ArrayList<Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from VISITEUR");
		try{
		while (reqSelection.next()) {
			String matricule = reqSelection.getString(1);
		    collectionDesVisiteurs.add(VisiteurDao.rechercher(matricule));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisiteurs()");
		}
		return collectionDesVisiteurs;
	}
	
	public static HashMap<String,Visiteur> retournerDictionnaireDesVisiteurs(){
		HashMap<String, Visiteur> diccoDesVisiteurs = new HashMap<String, Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from VISITEUR");
		try{
		while (reqSelection.next()) {
			String matricule = reqSelection.getString(1);
		    diccoDesVisiteurs.put(matricule, VisiteurDao.rechercher(matricule));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisiteurs()");
		}
		return diccoDesVisiteurs;
	}

}
