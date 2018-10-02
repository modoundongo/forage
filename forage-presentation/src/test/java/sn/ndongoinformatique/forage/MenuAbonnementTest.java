package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

public class MenuAbonnementTest {
	private Logger logger = Logger.getLogger("logg");

	@Test
	public void testAffMenuAbonnement() {
		assertEquals(logger.getName(),MenuAbonnement.logger.getName());
	}

}
