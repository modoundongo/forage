package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import java.sql.Date;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;

public class IServiceAbonnementImplTest {
	
	//IServiceAbonnementImpl serviceAbonnement=new IServiceAbonnementImpl();
	IServiceAbonnement serviceAbonnement;
	
IDaoAbonnement mockAbonnement=mock(IDaoAbonnement.class,"mockAbon");
	ClientForage client = DaoUtilites.recupererClientForage("567");
	Compteur compteur = DaoUtilites.recupererCompteur("c2");
	Date da=new Date(0);
	Abonnement abonnement =new Abonnement(578,client,compteur,da,"actif");

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
		//when(mockAbonnement.lister()).thenReturn(serviceAbonnement.lister());
		serviceAbonnement.lister();
	}

	@Test
	public void testSupprimer() {
		serviceAbonnement.supprimer(abonnement);
	}

}
