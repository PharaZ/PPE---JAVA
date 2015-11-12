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
	
	public static int creer(Medicament unMedicament){
		int result = 0;
		String requeteInsertion;
		String depotLegal = unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets = unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		Float prixEchantillon = unMedicament.getPrixEchantillon();
		String codeFamille = unMedicament.getCodeFamille();
		String libelleFamille = unMedicament.getLibelleFamille();
		
		requeteInsertion = "insert into Medicament values('"+depotLegal+"','"+nomCommercial+"','"+composition+"','"+effets+"','"+contreIndication+"','"+prixEchantillon+"','"+codeFamille+"','"+libelleFamille+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion MEDICAMENT");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static int supprimer(String depotLegal){
		String requeteSuppression = "delete from MEDICAMENT where DEPOTLEGAL='"+depotLegal+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Medicament unMedicament){
		String requeteModification;
		String depotLegal= unMedicament.getDepotLegal();
		String nomCommercial = unMedicament.getNomCommercial();
		String composition = unMedicament.getComposition();
		String effets =  unMedicament.getEffets();
		String contreIndication = unMedicament.getContreIndication();
		float prixEchantillon =  unMedicament.getPrixEchantillon();
		String codeFamille = unMedicament.getCodeFamille();
		String libelleFamille = unMedicament.getLibelleFamille();
		requeteModification = "update MEDICAMENT set NOMCOMMERCIAL='"+nomCommercial+"',COMPOSITION='"+composition+"',EFFETS='"+effets+"',CONTREINDICATION='"+contreIndication+"',PRIXECHANTILLON='"+prixEchantillon+"',CODEFAMILLE='"+codeFamille+"',LIBELLEFAMILLE='"+libelleFamille+"' where DEPOTLEGAL='"+depotLegal+"'";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
}
