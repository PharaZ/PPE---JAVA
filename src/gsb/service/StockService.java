package gsb.service;
import gsb.modele.Visiteur;
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
	
	public static int creerStock(Medicament unMedicament, Visiteur unVisiteur, int qteStock){
		Stock unStock;
		int resultat = 0;
		
		try{ // controle des param�tres d'entr�e
			 // Si le donn�es est manquante on l�ve une exception
	        if (unMedicament==null || unVisiteur == null || qteStock == 0) {
	            throw new Exception("Donn�es obligatoires : depot legal, matricule visiteur, quantite stock");
	        }
	        if (StockDao.rechercher() != null) {
	            // Si la base de donn�e contient d�j� un client ayant ce code on envoie une exception
	            throw new Exception("Un stock avec le depot legal " + unMedicament  + " existe d�j�");
	        }
	        unStock = new Stock(qteStock, unVisiteur, unMedicament);
	        resultat = StockDao.creer(unStock);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		
		return resultat;
	        
		}
	}
