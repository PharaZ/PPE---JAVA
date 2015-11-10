package gsb.service;

import gsb.modele.Medicament;
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
	
}
