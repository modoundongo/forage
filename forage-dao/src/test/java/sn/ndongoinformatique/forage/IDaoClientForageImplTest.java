package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class IDaoClientForageImplTest {
Village village =new Village(123,"Ndia Ndongo");
ClientForage clientForage=new ClientForage("123", "Modou", "Ndongo", village);
ClientForage clientTest=new ClientForage("612", "test", "test", village);
ClientForage clientForageUpdate=new ClientForage("123", "Ass", "Sylla", village);
ClientForage clientForageSupprime=new ClientForage("1000", "ka", "aicha", village);
IDaoVillageImpl villageImpl=new IDaoVillageImpl();
IDaoClientForageImpl clientImpl=new IDaoClientForageImpl();
	@Test
	public void testCreate() {
	//villageImpl.create(village);	
	clientImpl.create(clientTest);
	ClientForage resultat=DaoUtilites.recupererClientForage(clientTest.getCodePersonne());
	Assert.assertNotNull(resultat.getCodePersonne());
	//clientImpl.create(clientForageSupprime);
	}

	@Test
	public void testUpdate() {
		clientImpl.update(clientForageUpdate);
	}

	@Test
	public void testList() {
	clientImpl.list();
	}

	@Test
	public void testDelete() {
	clientImpl.delete(clientForageSupprime);
	}

}
