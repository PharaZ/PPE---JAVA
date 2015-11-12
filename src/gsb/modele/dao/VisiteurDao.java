/**
 * 
 */
package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	
	public static int creer(Visiteur unVisiteur){
		int result = 0;
		String requeteInsertion;
		String matricule= unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login =  unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		String adresse =  unVisiteur.getAdresse();
		String cp = unVisiteur.getCp();
		String ville = unVisiteur.getVille();
		String telephone = unVisiteur.getTelephone();
		Date dateEntree= unVisiteur.getDateEntree();
		int prime= unVisiteur.getPrime();
		String codeUnite= unVisiteur.getCodeUnite();
		String nomUnite= unVisiteur.getNomUnite();
		requeteInsertion = "insert into VISITEUR values('"+matricule+"','"+nom+"','"+prenom+"','"+login+"','"+adresse+"','"+cp+"','"+ville+"','"+telephone+"','"+dateEntree+"','"+prime+"','"+codeUnite+"','"+nomUnite+"')";
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Visiteur");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int supprimer(String matricule){
		String requeteSuppression = "delete from VISITEUR where MATRICULE='"+matricule+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	
	public static int modifier(Visiteur unVisiteur){
		String requeteModification;
		String matricule= unVisiteur.getMatricule();
		String nom = unVisiteur.getNom();
		String prenom = unVisiteur.getPrenom();
		String login =  unVisiteur.getLogin();
		String mdp = unVisiteur.getMdp();
		String adresse =  unVisiteur.getAdresse();
		String cp = unVisiteur.getCp();
		String ville = unVisiteur.getVille();
		String telephone = unVisiteur.getTelephone();
		Date dateEntree= unVisiteur.getDateEntree();
		int prime= unVisiteur.getPrime();
		String codeUnite= unVisiteur.getCodeUnite();
		String nomUnite= unVisiteur.getNomUnite();
		requeteModification = "update VISITEUR set NOM='"+nom+"',PRENOM='"+prenom+"',LOGIN='"+login+"',MDP='"+mdp+"',ADRESSE='"+adresse+"',CODEPOSTAL='"+cp+"',VILLE='"+ville+"',TELEPHONE='"+telephone+"',DATEENTREE='"+dateEntree+"',PRIME='"+prime+"',CODEUNIT='"+codeUnite+"',NOMUNITE='"+nomUnite+"' where MATRICULE='"+matricule+"'";
		int result = ConnexionMySql.execReqMaj(requeteModification);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

}
