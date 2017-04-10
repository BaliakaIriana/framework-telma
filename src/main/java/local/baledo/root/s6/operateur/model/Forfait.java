package local.baledo.root.s6.operateur.model;

public class Forfait extends Data{
	String nomforfait;

	public Forfait(){
		super();
	}
	public Forfait(int id, String nomforfait) {
		super(id);
		this.nomforfait = nomforfait;
	}

	/**
	 * @return the nomforfait
	 */
	public String getNomforfait() {
		return nomforfait;
	}

	/**
	 * @param nomforfait the nomforfait to set
	 */
	public void setNomforfait(String nomforfait) {
		this.nomforfait = nomforfait;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Forfait [nomforfait=" + nomforfait + "]";
	}
	
}
