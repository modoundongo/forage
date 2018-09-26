package sn.ndongoinformatique.forage;
/**
 * 
 * @author NdongoInfo
 *
 */
public class Compteur {
	private String numeroCompteur;
	private int ancienIndex;
	private int nouveauIndex;
	public Compteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compteur(String numeroCompteur, int ancienIndex, int nouveauIndex) {
		super();
		this.numeroCompteur = numeroCompteur;
		this.ancienIndex = ancienIndex;
		this.nouveauIndex = nouveauIndex;
	}
	public String getNumeroCompteur() {
		return numeroCompteur;
	}
	public void setNumeroCompteur(String numeroCompteur) {
		this.numeroCompteur = numeroCompteur;
	}
	public int getAncienIndex() {
		return ancienIndex;
	}
	public void setAncienIndex(int ancienIndex) {
		this.ancienIndex = ancienIndex;
	}
	public int getNouveauIndex() {
		return nouveauIndex;
	}
	public void setNouveauIndex(int nouveauIndex) {
		this.nouveauIndex = nouveauIndex;
	}
	@Override
	public String toString() {
		
		return "\nNumero:" + numeroCompteur + "\nAncien Index:" + ancienIndex + "\nNouveau Index:"
				+ nouveauIndex ;
		
	}
	

}
