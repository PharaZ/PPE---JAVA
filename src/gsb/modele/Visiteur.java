/**
 * 
 */
package gsb.modele;
/**
 * @author Guillaume
 *
 */
import java.util.Date;

public class Visiteur {
	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String mdp;
	protected String adresse;
	protected String cp;
	protected String ville;
	protected String telephone;
	protected Date dateEntree;
	protected int prime;
	protected String codeUnite;
	protected String nomUnite;
	/**
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param mdp
	 * @param adresse
	 * @param cp
	 * @param ville
	 * @param telephone
	 * @param dateEntree
	 * @param prime
	 * @param codeUnite
	 * @param nomUnite
	 */
	public Visiteur(String matricule, String nom, String prenom, String login,
			String mdp, String adresse, String cp, String ville,
			String telephone, Date dateEntree, int prime, String codeUnite,
			String nomUnite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telephone = telephone;
		this.dateEntree = dateEntree;
		this.prime = prime;
		this.codeUnite = codeUnite;
		this.nomUnite = nomUnite;
	}
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the dateEntree
	 */
	public Date getDateEntree() {
		return dateEntree;
	}
	/**
	 * @param dateEntree the dateEntree to set
	 */
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	/**
	 * @return the prime
	 */
	public int getPrime() {
		return prime;
	}
	/**
	 * @param prime the prime to set
	 */
	public void setPrime(int prime) {
		this.prime = prime;
	}
	/**
	 * @return the codeUnite
	 */
	public String getCodeUnite() {
		return codeUnite;
	}
	/**
	 * @param codeUnite the codeUnite to set
	 */
	public void setCodeUnite(String codeUnite) {
		this.codeUnite = codeUnite;
	}
	/**
	 * @return the nomUnite
	 */
	public String getNomUnite() {
		return nomUnite;
	}
	/**
	 * @param nomUnite the nomUnite to set
	 */
	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}

	
}