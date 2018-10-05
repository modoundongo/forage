package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Test;

public class IServiceFactureJmplTest {
	Village village = new Village(10100010, "Dakar", 12000);
	ClientForage client = new ClientForage("5055820", "ouseynou", "Sene", village);
	Compteur compteur = new Compteur("3002130", 100, 200);
	Abonnement abonnement = new Abonnement(15485300, client, compteur, "actif");
	Facture facture = new Facture(5587, abonnement);
	Facture facture1 = new Facture(4879, abonnement);
	IServiceAbonnementImpl serviceAbon = new IServiceAbonnementImpl();
	IServiceClientForageImpl serviceClient = new IServiceClientForageImpl();
	IServiceVillageImpl serviceVillage = new IServiceVillageImpl();
	IServiceCompteurImpl serviceCompteur = new IServiceCompteurImpl();
	IServiceFactureJmpl serviceFacture = new IServiceFactureJmpl();
/*
	@Test
	public void testCreer() {
		serviceVillage.creer(village);
		serviceClient.creer(client);
		serviceCompteur.creer(compteur);
		serviceAbon.creer(abonnement);
		serviceFacture.creer(facture);
		serviceFacture.creer(facture1);
	}
*/
	@Test
	public void testMisAjour() {
		serviceFacture.MisAjour(facture);
	}

	@Test
	public void testLister() {
		serviceFacture.lister();
	}

	@Test
	public void testSupprimer() {
		serviceFacture.supprimer(facture);
	}

}
