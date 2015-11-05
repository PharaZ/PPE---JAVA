/**
 * 
 */
package gsb.modele;

/**
 * @author Guillaume
 *
 */
public class Offrir {
	   protected Medicament unMedicament;
	   protected int qteOfferte;
	/**
	 * @param unMedicament
	 * @param qteOfferte
	 */
	public Offrir(Medicament unMedicament, int qteOfferte) {
		super();
		this.unMedicament = unMedicament;
		this.qteOfferte = qteOfferte;
	}
	/**
	 * @return the unMedicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}
	/**
	 * @param unMedicament the unMedicament to set
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	/**
	 * @return the qteOfferte
	 */
	public int getQteOfferte() {
		return qteOfferte;
	}
	/**
	 * @param qteOfferte the qteOfferte to set
	 */
	public void setQteOfferte(int qteOfferte) {
		this.qteOfferte = qteOfferte;
	}
	   
	   
}