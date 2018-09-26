package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Test;

public class IServiceVillageImplTest {
	private IServiceVillageImpl serviceImpl=new IServiceVillageImpl();
	private Village village =new Village(579,"saintloiuis", 300);
	private Village village1 =new Village(5234,"thies", 450);

	@Test
	public void testCreer() {
		serviceImpl.creer(village);
		serviceImpl.creer(village1);
	}

	@Test
	public void testMisAjour() {
		serviceImpl.MisAjour(village);
	}

	@Test
	public void testLister() {
		serviceImpl.lister();
	}

	@Test
	public void testSupprimer() {
		serviceImpl.supprimer(village1);
	}

}
