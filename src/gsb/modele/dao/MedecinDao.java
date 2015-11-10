/*
 * Créé le 22 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.modele.dao;

import gsb.modele.Medecin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;




/**
 * @author Isabelle
 * 22 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinDao {
	
	public static Medecin rechercher(String codeMedecin){
		Medecin unMedecin=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
		try {
			if (reqSelection.next()) {
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8), reqSelection.getString(9));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins(){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMedecin, MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	
	public static int creer(Medecin unMedecin){
		int result = 0;
		String requeteInsertion;
		String codeMed= unMedecin.getCodeMed();
		String nom = unMedecin.getNom();
		String prenom = unMedecin.getPrenom();
		String adresse =  unMedecin.getAdresse();
		String telephone = unMedecin.getTelephone();
		String potentiel =  unMedecin.getPotentiel();
		String specialite = unMedecin.getSpecialite();
		String ville = unMedecin.getVille();
		String cp = unMedecin.getCp();
		requeteInsertion = "insert into MEDECIN values('"+codeMed+"','"+nom+"','"+prenom+"','"+adresse+"','"+telephone+"','"+potentiel+"','"+specialite+"','"+ville+"','"+cp+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Medecin");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int supprimer(String codeMed){
		String requeteSuppression = "delete from MEDECIN where CODEMED='"+codeMed+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Medecin unMedecin){
		String requeteModification;
		String codeMed= unMedecin.getCodeMed();
		String nom = unMedecin.getNom();
		String prenom = unMedecin.getPrenom();
		String adresse =  unMedecin.getAdresse();
		String telephone = unMedecin.getTelephone();
		String potentiel =  unMedecin.getPotentiel();
		String specialite = unMedecin.getSpecialite();
		String ville = unMedecin.getVille();
		String cp = unMedecin.getCp();
		requeteModification = "update MEDECIN set NOM='"+nom+"',PRENOM='"+prenom+"',ADRESSE='"+adresse+"',TELEPHONE='"+telephone+"',POTENTIEL='"+potentiel+"',SPECIALITE='"+specialite+"',VILLE='"+ville+"',CP='"+cp+"' where CODEMED='"+codeMed+"'";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
