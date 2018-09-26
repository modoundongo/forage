package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Ignore;
import org.junit.Test;

public class IDaoAbonnementImplTest {
	IDaoAbonnementImpl daoAbonnementImpl=new IDaoAbonnementImpl();
	IDaoClientForageImpl daoClientImpl=new IDaoClientForageImpl();
	ClientForage client = DaoUtilites.recupererClientForage("567");
	Compteur compteur = DaoUtilites.recupererCompteur("c2");
	Date da=new Date(0);
	Abonnement abonnement =new Abonnement(457,client,compteur,da,"actif");
	@Test
	public void testCreate() {
	
		daoAbonnementImpl.create(abonnement);
		
	}

	@Test
	public void testUpdate() {
		daoAbonnementImpl.update(abonnement);
	}

	@Test
	public void testList() {
		daoAbonnementImpl.list();
	}

	@Test
	public void testDelete() {
		daoAbonnementImpl.delete(abonnement);
	}


}
