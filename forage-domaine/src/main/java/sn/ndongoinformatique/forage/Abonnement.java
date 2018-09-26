package sn.ndongoinformatique.forage;

import java.util.Arrays;
import java.sql.Date;
import java.util.List;

public class Abonnement {
	private int idAbonnement;
	private ClientForage clientForage;
	private Compteur compteur;
	private Date dateAbonnement;
	private String etatAbonnement;
	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Abonnement(int idAbonnement, ClientForage clientForage, Compteur compteur, Date dateAbonnement,
			String etatAbonnement) {
		super();
		this.idAbonnement = idAbonnement;
		this.clientForage = clientForage;
		this.compteur = compteur;
		this.dateAbonnement = dateAbonnement;
		this.etatAbonnement = etatAbonnement;
	}
	

	public Abonnement(int idAbonnement, ClientForage clientForage, Compteur compteur, String etatAbonnement) {
		super();
		this.idAbonnement = idAbonnement;
		this.clientForage = clientForage;
		this.compteur = compteur;
		this.etatAbonnement = etatAbonnement;
	}

	public Abonnement(ClientForage clientForage, Compteur compteur) {
		super();
		this.clientForage = clientForage;
		this.compteur = compteur;
	}

	public Abonnement(ClientForage clientForage, Compteur compteur, Date dateAbonnement, String etatAbonnement) {
		super();
		this.clientForage = clientForage;
		this.compteur = compteur;
		this.dateAbonnement = dateAbonnement;
		this.etatAbonnement = etatAbonnement;
	}

	public ClientForage getClientForage() {
		return clientForage;
	}

	public void setClientForage(ClientForage clientForage) {
		this.clientForage = clientForage;
	}

	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	public Date getDateAbonnement() {
		return dateAbonnement;
	}

	public void setDateAbonnement(Date dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}

	public String getEtatAbonnement() {
		return etatAbonnement;
	}

	public void setEtatAbonnement(String etatAbonnement) {
		this.etatAbonnement = etatAbonnement;
	}

	public int getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}



}
