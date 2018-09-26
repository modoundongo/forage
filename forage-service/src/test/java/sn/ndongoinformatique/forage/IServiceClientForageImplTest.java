package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Test;

public class IServiceClientForageImplTest {
	private IServiceClientForageImpl serviceClientImpl=new IServiceClientForageImpl();
	private Village village =new Village(378,"yatiyone", 300);
	private ClientForage clientForage=new ClientForage("500","Maguette","Gueye", village);

	@Test
	public void testCreer() {
		serviceClientImpl.creer(clientForage);
	}

	@Test
	public void testMisAjour() {
		serviceClientImpl.MisAjour(clientForage);
	}

	@Test
	public void testLister() {
		serviceClientImpl.lister();
	}

	@Test
	public void testSupprimer() {
		serviceClientImpl.supprimer(clientForage);
	}

}
