package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Test;

public class IServiceCompteurImplTest {
	IServiceCompteurImpl serviceCompteur=new IServiceCompteurImpl();
	Compteur compteur =new Compteur("c13", 100, 200);
	Compteur compteur1 =new Compteur("c53", 200, 350);
	@Test
	public void testCreer() {
		serviceCompteur.creer(compteur);
		serviceCompteur.creer(compteur1);
	}

	@Test
	public void testMisAjour() {
		serviceCompteur.MisAjour(compteur);
	}

	@Test
	public void testLister() {
		serviceCompteur.lister();
	}

	@Test
	public void testSupprimer() {
		serviceCompteur.supprimer(compteur1);
	}

}
