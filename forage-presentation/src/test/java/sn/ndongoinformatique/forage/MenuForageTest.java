package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.logging.Logger;

public class MenuForageTest {
	private Logger logger = Logger.getLogger("log");

	@Test
	public void testMain() {
		//fail("Not yet implemented");
		
		assertEquals(logger.getName(),MenuForage.logger.getName());
	
	}

}
