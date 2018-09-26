package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class IDaoFactureImplTest {
	Village village = new Village(10000, "Dakar", 12000);
	ClientForage client = new ClientForage("5020", "ouseynou", "Sene", village);
	Compteur compteur = new Compteur("3000", 100, 200);
	Abonnement abonnement = new Abonnement(1500, client, compteur, "actif");
	Facture facture = new Facture(12, abonnement);
	IDaoAbonnementImpl daoAbonnementImpl=new IDaoAbonnementImpl();
	IDaoClientForageImpl daoClientImpl=new IDaoClientForageImpl();
	IDaoVillageImpl daoVillage=new IDaoVillageImpl();
	IDaoCompteurImpl daoCompteur=new IDaoCompteurImpl();
	IDaoFactureImpl daoFacture=new IDaoFactureImpl();

	@Test
	public void testCreate() {
		daoVillage.create(village);
		daoClientImpl.create(client);
		daoCompteur.create(compteur);
		daoAbonnementImpl.create(abonnement);
		daoFacture.create(facture);
	}

	@Test
	public void testUpdate() {
		daoFacture.update(facture);
	}

	@Test
	public void testList() {
		daoFacture.list();
	}

	@Test
	public void testDelete() {
		daoFacture.delete(facture);
		daoAbonnementImpl.delete(abonnement);
		daoCompteur.delete(compteur);
		daoClientImpl.delete(client);
		daoVillage.delete(village);
	}

}
