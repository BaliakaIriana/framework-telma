package local.baledo.root.s6.operateur.model;

public class Sim extends Data{
	String numero;
	String pin;
	String puk;
	Utilisateur utilisateur;
//	double solde;
	
	public Sim(){}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur owner) {
		this.utilisateur = owner;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPuk() {
		return puk;
	}
	public void setPuk(String puk) {
		this.puk = puk;
	}
	public Sim(int idsim, String numero, String pin, String puk,Utilisateur owner) {
		super(idsim);
		this.setNumero(numero);
		this.setPin(pin);
		this.setPuk(puk);
		this.setUtilisateur(owner);
	}
//	/**
//	 * @return the solde
//	 */
//	public double getSolde() {
//		return solde;
//	}
//	/**
//	 * @param solde the solde to set
//	 */
//	public void setSolde(double solde) {
//		this.solde = solde;
//	}
//	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sim [numero=" + numero + ", pin=" + pin + ", puk=" + puk + ", utilisateur=" + utilisateur + "]";
	}
	
}
