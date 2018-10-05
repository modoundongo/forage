package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import java.sql.Date;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;

import junit.framework.Assert;

public class IServiceAbonnementImplTest {
	
	//IServiceAbonnementImpl serviceAbonnement=new IServiceAbonnementImpl();
	private IServiceAbonnementImpl serviceAbonnementImpl;
	private IServiceAbonnement serviceAbonnement;
	
IDaoAbonnement mockAbonnement=mock(IDaoAbonnement.class,"mockAbon");
	ClientForage client = DaoUtilites.recupererClientForage("567");
	Compteur compteur = DaoUtilites.recupererCompteur("c2");
	Date da=new Date(0);
	Abonnement abonnement =new Abonnement(5478,client,compteur,da,"actif");
	@Before
    public void setUp() {
		serviceAbonnementImpl =new IServiceAbonnementImpl();
		serviceAbonnement =mock(IServiceAbonnement.class);
		serviceAbonnementImpl.setServiceAbonnement(serviceAbonnement);
	}

	@Test
	public void testCreer() {
	//serviceAbonnement.creer(abonnement);	
	//doNothing().when(serviceAbonnement).creer(isA(Abonnement.class));
		when(serviceAbonnement.creer(abonnement)).thenReturn(true);
	//serviceAbonnement.creer(abonnement);
   assertTrue(serviceAbonnementImpl.creer(abonnement));
	verify(serviceAbonnement,times(1)).creer(abonnement);
	}
/*
	@Test
	public void testMisAjour() {
		serviceAbonnement.MisAjour(abonnement);
	}

	@Test
	public void testLister() {
		//when(mockAbonnement.lister()).thenReturn(serviceAbonnement.lister());
		serviceAbonnement.lister();
	}

	@Test
	public void testSupprimer() {
		serviceAbonnement.supprimer(abonnement);
	}
*/
}
