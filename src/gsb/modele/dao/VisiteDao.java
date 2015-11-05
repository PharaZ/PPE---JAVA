/**
 * 
 */
package gsb.modele.dao;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Guillaume
 *
 */
public class VisiteDao {
	public static Visite rechercher(String reference){
		Visite uneVisite=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE where REFERENCE ='"+reference+"'");
		try {
			if (reqSelection.next()) {
				Medecin unMedecin = MedecinDao.rechercher(reqSelection.getString(4));
				Visiteur unVisiteur = VisiteurDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), unMedecin, unVisiteur);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITE where REFERENCE ='"+reference+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	public static ArrayList<Visite> retournerCollectionDesVisites(){
		ArrayList<Visite> collectionDesVisites = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
		try{
		while (reqSelection.next()) {
			String reference = reqSelection.getString(1);
		    collectionDesVisites.add(VisiteDao.rechercher(reference));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisites()");
		}
		return collectionDesVisites;
	}
	
	public static HashMap<String,Visite> retournerDictionnaireDesVisites(){
		HashMap<String, Visite> diccoDesVisites = new HashMap<String, Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
		try{
		while (reqSelection.next()) {
			String reference = reqSelection.getString(1);
		    diccoDesVisites.put(reference, VisiteDao.rechercher(reference));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisites()");
		}
		return diccoDesVisites;
	}
}
