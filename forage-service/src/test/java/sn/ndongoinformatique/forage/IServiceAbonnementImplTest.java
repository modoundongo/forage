package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class IServiceAbonnementImplTest {
	
	IServiceAbonnementImpl serviceAbonnement=new IServiceAbonnementImpl();
	
	ClientForage client = DaoUtilites.recupererClientForage("567");
	Compteur compteur = DaoUtilites.recupererCompteur("c2");
	Date da=new Date(0);
	Abonnement abonnement =new Abonnement(457,client,compteur,da,"actif");

	@Test
	public void testCreer() {
	serviceAbonnement.creer(abonnement);
	}

	@Test
	public void testMisAjour() {
		serviceAbonnement.MisAjour(abonnement);
	}

	@Test
	public void testLister() {
		serviceAbonnement.lister();
	}

	@Test
	public void testSupprimer() {
		serviceAbonnement.supprimer(abonnement);
	}

}
