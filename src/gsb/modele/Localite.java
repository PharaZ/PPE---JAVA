
package gsb.modele;

/**
 * @author Guillaume
 * 
 */
public class Localite {
	protected String codePostal;
	protected String ville;
	/**
	 * @param codePostal
	 * @param ville
	 */
	public Localite(String codePostal, String ville) {
		this.codePostal = codePostal;
		this.ville = ville;
	}
	/**
	 * @return Renvoie codePostal.
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal codePostal à définir.
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return Renvoie ville.
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville ville à définir.
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
}

