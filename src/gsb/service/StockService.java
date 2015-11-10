package gsb.service;
import gsb.modele.Stock;
import gsb.modele.dao.StockDao;

public class StockService {

	//Recherche le depot legal d'un medicament dans Stock.
	public static Stock rechercherStock(String unDepotLegalMedicament){
		Stock unStock = null;
		try{
		if (unDepotLegalMedicament==null) {
            throw new Exception("Donn�e obligatoire : Depot Legal");
        }
		unStock = StockDao.rechercher(unDepotLegalMedicament);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unStock;
	}

}
