package sn.ndongoinformatique.forage;
/**
 * Cette permetre denregistrer les clients 
 * @author NdongoInfo
 *
 */

public class Personne {
	private String codePersonne;
	private String prenomPersonne;
	private String nomPersonne;	
	private Village villageClient;
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Personne(String codePersonne, String prenomPersonne, String nomPersonne) {
		super();
		this.codePersonne = codePersonne;
		this.prenomPersonne = prenomPersonne;
		this.nomPersonne = nomPersonne;
	}
	public Personne(String codePersonne, String prenomPersonne, String nomPersonne, Village villageClient) {
		super();
		this.codePersonne = codePersonne;
		this.prenomPersonne = prenomPersonne;
		this.nomPersonne = nomPersonne;
		this.villageClient = villageClient;
	}
	public String getCodePersonne() {
		return codePersonne;
	}
	public void setCodePersonne(String codePersonne) {
		this.codePersonne = codePersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public Village getVillageClient() {
		return villageClient;
	}
	public void setVillageClient(Village villageClient) {
		this.villageClient = villageClient;
	}
	@Override
	public String toString() {
		return "code:" + codePersonne + " \nPrenom :" + prenomPersonne + "\nNom:"
				+ nomPersonne + "\nVillage:" + villageClient ;
	}
	
	

}
