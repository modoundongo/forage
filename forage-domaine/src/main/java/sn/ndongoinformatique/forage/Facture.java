package sn.ndongoinformatique.forage;

import java.util.Date;

public class Facture {
	private int codeFacture;
	private Abonnement abonnement;
	private Date dateDebutFacturation;
	private Date dateLimiteFacturation;
	private Date dateFinFacturation;
	private  static  float prixIndex=100;
	public Facture() {
		super();
		
	}
	public Facture(Abonnement abonnement, Date dateDebutFacturation, Date dateLimiteFacturation,
			Date dateFinFacturation) {
		super();
		this.abonnement = abonnement;
		this.dateDebutFacturation = dateDebutFacturation;
		this.dateLimiteFacturation = dateLimiteFacturation;
		this.dateFinFacturation = dateFinFacturation;
		
	}
	public Facture(Abonnement abonnement, Date dateLimiteFacturationt) {
		super();
		this.abonnement = abonnement;
		this.dateLimiteFacturation = dateLimiteFacturation;
		
	}

	public Facture(int codeFacture, Abonnement abonnement, Date dateDebutFacturation, Date dateLimiteFacturation,
			Date dateFinFacturation) {
		super();
		this.codeFacture = codeFacture;
		this.abonnement = abonnement;
		this.dateDebutFacturation = dateDebutFacturation;
		this.dateLimiteFacturation = dateLimiteFacturation;
		this.dateFinFacturation = dateFinFacturation;
		
	}
	public Facture(int codeFacture, Abonnement abonnement) {
		super();
		this.codeFacture = codeFacture;
		this.abonnement = abonnement;
		
	}
	public int getCodeFacture() {
		return codeFacture;
	}
	public void setCodeFacture(int codeFacture) {
		this.codeFacture = codeFacture;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public Date getDateDebutFacturation() {
		return dateDebutFacturation;
	}
	public void setDateDebutFacturation(Date dateDebutFacturation) {
		this.dateDebutFacturation = dateDebutFacturation;
	}
	public Date getDateLimiteFacturation() {
		return dateLimiteFacturation;
	}
	public void setDateLimiteFacturation(Date dateLimiteFacturation) {
		this.dateLimiteFacturation = dateLimiteFacturation;
	}
	public Date getDateFinFacturation() {
		return dateFinFacturation;
	}
	public void setDateFinFacturation(Date dateFinFacturation) {
		this.dateFinFacturation = dateFinFacturation;
	}
	public static double getPrixIndex() {
		return prixIndex;
	}
	public static void setPrixIndex(float prixIndex) {
		Facture.prixIndex = prixIndex;
	}
	
	
}
