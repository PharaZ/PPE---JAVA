package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {
//Recherche le depot legal d'un medicament.
	public static Medicament rechercherMedicament(String unDepotLegalMedicament){
		Medicament unMedicament = null;
		try{
		if (unDepotLegalMedicament==null) {
            throw new Exception("Donn�e obligatoire : Depot Legal");
        }
		unMedicament = MedicamentDao.rechercher(unDepotLegalMedicament);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
	
	public static int creerMedicament(String depotLegal, String nonomCommercialm, String composition, String effets, String contreIndication,
			 float prixEchantillon, String codeFamille, String libelleFamille){
		Medicament unMedicament;
		int resultat = 0;
		
		try{ // controle des param�tres d'entr�e
			 // Si le donn�es est manquante on l�ve une exception
	        if (depotLegal==null || nomCommercial == null || composition == null || effets == null || contreIndication == null || prixEchantillon == null || codeFamille == null || libelleFamille == null) {
	            throw new Exception("Donn�es obligatoires : depot legal, nom commercial, composition, effets, contre indication, prix echantillon, code famille,  libelle famille");
	        }/*
	        if (!ValidationUtils.isEmailValide(email)) {
	            // Si l'email  saisi est invalide on l�ve une exception
	            throw new Exception("L'email n'est pas valide");
	        }

	        if (!ValidationUtils.isTelephoneValide(telephone)) {
	            // Si le t�l�phone saisi est invalide on l�ve une exception
	            throw new Exception("Le t�l�phone n'est pas valide");
	        }
	        
	        if ( !ValidationUtils.isCodePostalValide(cp)) {
	            // Si le code postal saisi est invalide on l�ve une exception
	            throw new Exception("Le code postal n'est pas valide");
	        }*/

	        if (ClientDao.rechercher(code) != null) {
	            // Si la base de donn�e contient d�j� un client ayant ce code on envoie une exception
	            throw new Exception("Un contact avec le code " + code  + " existe d�j�");
	        }
	        unClient = new Clients(code, nom, prenom, email, telephone, adresse, cp, ville);
	        resultat = ClientDao.creer(unClient);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		
		return resultat;

	
}
