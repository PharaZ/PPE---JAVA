package gsb.service;

import gsb.modele.Offrir;
import gsb.modele.dao.OffrirDao;


public class OffrirService {

		//Recherche le depot legal d'un medicament dans offrir.
			public static Offrir rechercherOffre(String unDepotLegalMedicament){
				Offrir uneOffre = null;
				try{
				if (unDepotLegalMedicament==null) {
		            throw new Exception("Donn�e obligatoire : Depot Legal");
		        }
				uneOffre = OffrirDao.rechercher(unDepotLegalMedicament);
				}
				catch(Exception e){
					System.out.println( e.getMessage());
				}
				return uneOffre;
			}
			
	 		

}
