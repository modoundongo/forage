package sn.ndongoinformatique.forage;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class IDaoVillageImplTest {
Village vAjouter =new Village(287, "thilmakha",100);
IDaoVillageImpl vi=new IDaoVillageImpl();
	@Test
	public void testCreate() {
		vi.create(vAjouter);
	}

	@Test
	public void testUpdate() {
		vi.update(vAjouter);
	}

	@Test
	public void testList() {
		vi.list();
	}

	@Test
	public void testDelete() {
		vi.delete(vAjouter);
	}

}
