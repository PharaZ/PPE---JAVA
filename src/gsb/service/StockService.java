package gsb.service;
import gsb.modele.Medicament;
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
	
	public static int creerStock(String depotLegal, String MatriculeVist, String qteStock){
		Stock unStock;
		int resultat = 0;
		
		try{ // controle des param�tres d'entr�e
			 // Si le donn�es est manquante on l�ve une exception
	        if (depotLegal==null || MatriculeVist == null || qteStock == null) {
	            throw new Exception("Donn�es obligatoires : depot legal, matricule visiteur, quantite stock");


