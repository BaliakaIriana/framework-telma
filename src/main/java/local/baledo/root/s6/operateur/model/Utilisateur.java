package local.baledo.root.s6.operateur.model;

import java.util.Date;

public class Utilisateur extends Data{
	String nom;
	String prenom;
	String cin;
	Date naissance;
//	List<CarteSim> simUtilisateur;
	
	public Utilisateur(){}
	
	public Utilisateur(int idutilisateur, String nom, String prenom, String cin,Date naissance) {
		super(idutilisateur);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setCin(cin);
		this.setNaissance(naissance);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	/**
	 * @return the naissance
	 */
	public Date getNaissance() {
		return naissance;
	}
	/**
	 * @param naissance the naissance to set
	 */
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", naissance=" + naissance + "]";
	}
	
//	public List<CarteSim> getSimUtilisateur() {
//		return simUtilisateur;
//	}
//	public void setSimUtilisateur(List<CarteSim> simUtilisateur) {
//		this.simUtilisateur = simUtilisateur;
//	}
	
	
	
}
