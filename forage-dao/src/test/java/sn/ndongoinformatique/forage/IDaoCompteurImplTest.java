package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class IDaoCompteurImplTest {
	IDaoCompteurImpl daoCompteurImpl=new IDaoCompteurImpl();
	Compteur compteur =new Compteur("c1", 100, 200);
	Compteur compteur1 =new Compteur("c5", 200, 350);
	@Test
	public void testCreate() {
		
		daoCompteurImpl.create(compteur);
	}

	@Test
	public void testUpdate() {
	daoCompteurImpl.update(compteur);
	}

	@Test
	public void testList() {
		daoCompteurImpl.list();
	}

	@Test
	public void testDelete() {
		daoCompteurImpl.delete(compteur);
	}

}
