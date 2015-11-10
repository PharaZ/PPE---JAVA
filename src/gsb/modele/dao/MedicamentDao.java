/**
 * 
 */
package gsb.modele.dao;

import gsb.modele.Medicament;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Guillaume
 *
 */
public class MedicamentDao {
	public static Medicament rechercher(String depotLegal){
		Medicament unMedicament=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getFloat(6), reqSelection.getString(7), reqSelection.getString(8));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from MEDICAMENT where DEPOTLEGAl ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	public static ArrayList<Medicament> retournerCollectionDesMedicaments(){
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    collectionDesMedicaments.add(MedicamentDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}
	
	public static HashMap<String,Medicament> retournerDictionnaireDesMedicaments(){
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
		    diccoDesMedicaments.put(depotLegal, MedicamentDao.rechercher(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicaments()");
		}
		return diccoDesMedicaments;
	}

}
